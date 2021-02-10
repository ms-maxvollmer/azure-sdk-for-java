package com.azure.mixedreality.remoterendering;

import com.azure.core.util.polling.AsyncPollResponse;
import com.azure.core.util.polling.LongRunningOperationStatus;
import com.azure.core.util.polling.PollerFlux;
import com.azure.mixedreality.remoterendering.implementation.models.ErrorResponseException;
import com.azure.mixedreality.remoterendering.models.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.azure.core.http.HttpClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class RemoteRenderingAsyncClientTest extends RemoteRenderingTestBase {
    private static final String DISPLAY_NAME_WITH_ARGUMENTS = "{displayName} with [{arguments}]";

    private RemoteRenderingAsyncClient getClient(HttpClient httpClient) {
        return new RemoteRenderingClientBuilder()
            .accountId(super.getAccountId())
            .accountDomain(super.getAccountDomain())
            .credential(super.getAccountKey())
            .endpoint(super.getServiceEndpoint())
            .pipeline(super.getHttpPipeline(httpClient))
            .buildAsyncClient();
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getHttpClients")
    public void conversionTest(HttpClient httpClient) {
        RemoteRenderingAsyncClient client = getClient(httpClient);

        ConversionOptions conversionOptions = new ConversionOptions()
            .inputStorageContainerUrl(getStorageUrl())
            .inputRelativeAssetPath("testBox.fbx")
            .inputBlobPrefix("Input")
            .inputStorageContainerReadListSas(getBlobContainerSasToken())
            .outputStorageContainerUrl(getStorageUrl())
            .outputBlobPrefix("Output")
            .outputStorageContainerWriteSas(getBlobContainerSasToken());

        String conversionId = getRandomId("asyncConversionTest");

        PollerFlux<Conversion, Conversion> poller = client.beginConversion(conversionId, conversionOptions);

        Flux<AsyncPollResponse<Conversion, Conversion>> terminalPoller = poller.map(response -> {
            Conversion conversion = response.getValue();
            assertEquals(conversionId, conversion.getId());
            assertEquals(conversionOptions.getInputRelativeAssetPath(), conversion.getOptions().getInputRelativeAssetPath());
            assertNotEquals(ConversionStatus.FAILED, conversion.getStatus());
            return response;
        }).filter(response -> {
            return ((response.getStatus() != LongRunningOperationStatus.NOT_STARTED)
                                  && (response.getStatus() != LongRunningOperationStatus.IN_PROGRESS));
        });

        StepVerifier.create(terminalPoller)
            .assertNext(response -> {
                assertEquals(response.getStatus(), LongRunningOperationStatus.SUCCESSFULLY_COMPLETED);

                Conversion conversion = response.getValue();
                assertEquals(conversion.getStatus(), ConversionStatus.SUCCEEDED);
                assertTrue(conversion.getOutputAssetUrl().endsWith("Output/testBox.arrAsset"));
            })
            .verifyComplete();

        StepVerifier.create(client.getConversion(conversionId))
            .assertNext(conversion -> {
                assertEquals(conversion.getStatus(), ConversionStatus.SUCCEEDED);
                assertTrue(conversion.getOutputAssetUrl().endsWith("Output/testBox.arrAsset"));
            })
            .verifyComplete();

        Mono<Boolean> foundConversion = client.listConversions().any(conversion -> {
            return conversion.getId().equals(conversionId);
        });

        assertTrue(foundConversion.block());
    };

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getHttpClients")
    public void failedConversionNoAccessTest(HttpClient httpClient) {
        RemoteRenderingAsyncClient client = getClient(httpClient);

        // Don't provide SAS tokens.
        ConversionOptions conversionOptions = new ConversionOptions()
            .inputStorageContainerUrl(getStorageUrl())
            .inputRelativeAssetPath("testBox.fbx")
            .inputBlobPrefix("Input")
            .outputStorageContainerUrl(getStorageUrl())
            .outputBlobPrefix("Output");

        String conversionId = getRandomId("failedConversionNoAccessAsync");

        PollerFlux<Conversion, Conversion> poller = client.beginConversion(conversionId, conversionOptions);

        StepVerifier.create(poller).expectErrorMatches(error -> {
            // Error accessing connected storage account due to insufficient permissions. Check if the Mixed Reality resource has correct permissions assigned
            return (error instanceof ErrorResponseException)
                && error.getMessage().contains("400")
                && error.getMessage().toLowerCase(Locale.ROOT).contains("storage")
                && error.getMessage().toLowerCase(Locale.ROOT).contains("permissions");
        }).verify();
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getHttpClients")
    public void failedConversionMissingAssetTest(HttpClient httpClient) {
        RemoteRenderingAsyncClient client = getClient(httpClient);

        ConversionOptions conversionOptions = new ConversionOptions()
            .inputStorageContainerUrl(getStorageUrl())
            .inputRelativeAssetPath("boxWhichDoesNotExist.fbx")
            .inputBlobPrefix("Input")
            .inputStorageContainerReadListSas(getBlobContainerSasToken())
            .outputStorageContainerUrl(getStorageUrl())
            .outputBlobPrefix("Output")
            .outputStorageContainerWriteSas(getBlobContainerSasToken());

        String conversionId = getRandomId("failedConversionMissingAssetAsync");

        PollerFlux<Conversion, Conversion> poller = client.beginConversion(conversionId, conversionOptions);

        Flux<AsyncPollResponse<Conversion, Conversion>> terminalPoller = poller.map(response -> {
            Conversion conversion = response.getValue();
            assertEquals(conversionId, conversion.getId());
            assertEquals(conversionOptions.getInputRelativeAssetPath(), conversion.getOptions().getInputRelativeAssetPath());
            assertNotEquals(ConversionStatus.SUCCEEDED, conversion.getStatus());
            return response;
        }).filter(response -> {
            return ((response.getStatus() != LongRunningOperationStatus.NOT_STARTED)
                && (response.getStatus() != LongRunningOperationStatus.IN_PROGRESS));
        });

        StepVerifier.create(terminalPoller)
            .assertNext(response -> {
                assertEquals(response.getStatus(), LongRunningOperationStatus.FAILED);

                Conversion conversion = response.getValue();

                assertEquals(ConversionStatus.FAILED, conversion.getStatus());
                assertNotNull(conversion.getError());
                // Invalid input provided. Check logs in output container for details.
                assertTrue(conversion.getError().getMessage().toLowerCase(Locale.ROOT).contains("invalid input"));
                assertTrue(conversion.getError().getMessage().toLowerCase(Locale.ROOT).contains("logs"));
            })
            .verifyComplete();
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getHttpClients")
    public void sessionTest(HttpClient httpClient) {
        RemoteRenderingAsyncClient client = getClient(httpClient);

        BeginSessionOptions options = new BeginSessionOptions().setMaxLeaseTime(Duration.ofMinutes(4)).setSize(RenderingSessionSize.STANDARD);

        String sessionId = getRandomId("ayncSessionTest");

        PollerFlux<RenderingSession, RenderingSession> sessionPoller = client.beginSession(sessionId, options);

        Flux<AsyncPollResponse<RenderingSession, RenderingSession>> terminalPoller = sessionPoller.map(response -> {
            RenderingSession session = response.getValue();
            assertEquals(sessionId, session.getId());
            assertNotEquals(RenderingSessionStatus.ERROR, session.getStatus());
            return response;
        }).filter(response -> {
            return ((response.getStatus() != LongRunningOperationStatus.NOT_STARTED)
                && (response.getStatus() != LongRunningOperationStatus.IN_PROGRESS));
        });

        StepVerifier.create(terminalPoller)
            .assertNext(response -> {
                assertEquals(response.getStatus(), LongRunningOperationStatus.SUCCESSFULLY_COMPLETED);

                RenderingSession readyRenderingSession = response.getValue();
                assertEquals(readyRenderingSession.getStatus(), RenderingSessionStatus.READY);

                assertTrue(readyRenderingSession.getMaxLeaseTime().toMinutes() == 4);
                assertNotNull(readyRenderingSession.getHostname());
                assertNotNull(readyRenderingSession.getArrInspectorPort());
                assertNotNull(readyRenderingSession.getHostname());
                assertEquals(readyRenderingSession.getSize(), options.getSize());
            })
            .verifyComplete();

        StepVerifier.create(client.getSession(sessionId))
            .assertNext(session -> {
                assertEquals(session.getStatus(), RenderingSessionStatus.READY);
                assertNotNull(session.getHostname());
                assertNotNull(session.getArrInspectorPort());
                assertNotNull(session.getHostname());
                assertEquals(session.getSize(), options.getSize());
            })
            .verifyComplete();

        UpdateSessionOptions updateOptions = new UpdateSessionOptions().maxLeaseTime(Duration.ofMinutes(5));

        StepVerifier.create(client.updateSession(sessionId, updateOptions))
            .assertNext(session -> {
                assertTrue(session.getMaxLeaseTime().toMinutes() == 5);
            }).verifyComplete();

        Mono<Boolean> foundSession = client.listSessions().any(session -> {
            return session.getId().equals(sessionId);
        });

        assertTrue(foundSession.block());

        client.endSession(sessionId).block();
    };

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getHttpClients")
    public void failedSessionTest(HttpClient httpClient) {
        RemoteRenderingAsyncClient client = getClient(httpClient);
        BeginSessionOptions options = new BeginSessionOptions().setMaxLeaseTime(Duration.ofMinutes(-4)).setSize(RenderingSessionSize.STANDARD);

        String sessionId = getRandomId("failedSessionTestAsync");

        PollerFlux<RenderingSession, RenderingSession> poller = client.beginSession(sessionId, options);

        StepVerifier.create(poller).expectErrorMatches(error -> {
            // The maxLeaseTimeMinutes value cannot be negative
            return (error instanceof ErrorResponseException)
                && error.getMessage().contains("400")
                && error.getMessage().toLowerCase(Locale.ROOT).contains("lease")
                && error.getMessage().toLowerCase(Locale.ROOT).contains("negative");
        }).verify();
    }
}
