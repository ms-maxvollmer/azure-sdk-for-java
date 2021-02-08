// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.mixedreality.remoterendering;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.mixedreality.remoterendering.models.*;

@ServiceClient(builder = RemoteRenderingClientBuilder.class)
public final class RemoteRenderingClient {
    private final RemoteRenderingAsyncClient client;

    RemoteRenderingClient(RemoteRenderingAsyncClient client) {
        this.client = client;
    }

    /**
     * Creates a new rendering session.
     *
     * @param sessionId An ID uniquely identifying the rendering session for the given account. The ID is case
     *     sensitive, can contain any combination of alphanumeric characters including hyphens and underscores, and
     *     cannot contain more than 256 characters.
     * @param options Options for the session to be created.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the rendering session.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SyncPoller<RenderingSession, RenderingSession> beginSession(String sessionId, CreateSessionOptions options) {
        return client.beginSession(sessionId, options).getSyncPoller();
    }

    @ServiceMethod(returns = ReturnType.SINGLE)
    public SyncPoller<RenderingSession, RenderingSession> beginSession(String sessionId) {
        return beginSession(sessionId, new CreateSessionOptions());
    }

    @ServiceMethod(returns = ReturnType.SINGLE)
    public SyncPoller<Response<RenderingSession>, Response<RenderingSession>> beginSessionWithResponse(String sessionId, CreateSessionOptions options, Context context) {
        return client.beginSessionWithResponse(sessionId, options, context).getSyncPoller();
    }

    /**
     * Gets properties of a particular rendering session.
     *
     * @param sessionId An ID uniquely identifying the rendering session for the given account. The ID is case
     *     sensitive, can contain any combination of alphanumeric characters including hyphens and underscores, and
     *     cannot contain more than 256 characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the rendering session.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public RenderingSession getSession(String sessionId) {
        return client.getSession(sessionId).block();
    }

    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<RenderingSession> getSessionWithResponse(String sessionId, Context context) {
        return client.getSessionWithResponse(sessionId, context).block();
    }

    /**
     * Updates a particular rendering session.
     *
     * @param sessionId An ID uniquely identifying the rendering session for the given account. The ID is case
     *     sensitive, can contain any combination of alphanumeric characters including hyphens and underscores, and
     *     cannot contain more than 256 characters.
     * @param options Options for the session to be updated.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the rendering session.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public RenderingSession updateSession(String sessionId, UpdateSessionOptions options) {
        return client.updateSession(sessionId, options).block();
    }

    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<RenderingSession> updateSessionWithResponse(String sessionId, UpdateSessionOptions options, Context context) {
        return client.updateSessionWithResponse(sessionId, options, context).block();
    }

    /**
     * Stops a particular rendering session.
     *
     * @param sessionId An ID uniquely identifying the rendering session for the given account. The ID is case
     *     sensitive, can contain any combination of alphanumeric characters including hyphens and underscores, and
     *     cannot contain more than 256 characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void stopSession(String sessionId) {
        client.stopSession(sessionId).block();
    }

    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> stopSessionWithResponse(String sessionId, Context context) {
        return client.stopSessionWithResponse(sessionId, context).block();
    }

    /**
     * Get a list of all rendering sessions.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of all rendering sessions.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<RenderingSession> listSessions() {
        return new PagedIterable<>(client.listSessions());
    }

    /**
     * Starts a conversion using an asset stored in an Azure Blob Storage account. If the remote rendering account has
     * been linked with the storage account no Shared Access Signatures (storageContainerReadListSas,
     * storageContainerWriteSas) for storage access need to be provided. Documentation how to link your Azure Remote
     * Rendering account with the Azure Blob Storage account can be found in the
     * [documentation](https://docs.microsoft.com/azure/remote-rendering/how-tos/create-an-account#link-storage-accounts).
     *
     * <p>All files in the input container starting with the blobPrefix will be retrieved to perform the conversion. To
     * cut down on conversion times only necessary files should be available under the blobPrefix.
     *
     * @param conversionId An ID uniquely identifying the conversion for the given account. The ID is case sensitive,
     *     can contain any combination of alphanumeric characters including hyphens and underscores, and cannot contain
     *     more than 256 characters.
     * @param options The conversion options.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the conversion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SyncPoller<Conversion, Conversion> beginConversion(String conversionId, ConversionOptions options) {
        return client.beginConversion(conversionId, options).getSyncPoller();
    }

    @ServiceMethod(returns = ReturnType.SINGLE)
    public SyncPoller<Response<Conversion>, Response<Conversion>> beginConversionWithResponse(String conversionId, ConversionOptions options, Context context) {
        return client.beginConversionWithResponse(conversionId, options, context).getSyncPoller();
    }

    /**
     * Gets the status of a previously created asset conversion.
     *
     * @param conversionId An ID uniquely identifying the conversion for the given account. The ID is case sensitive,
     *     can contain any combination of alphanumeric characters including hyphens and underscores, and cannot contain
     *     more than 256 characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the conversion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Conversion getConversion(String conversionId) {
        return client.getConversion(conversionId).block();
    }

    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Conversion> getConversionWithResponse(String conversionId, Context context) {
        return client.getConversionWithResponse(conversionId, context).block();
    }

    /**
     * Gets a list of all conversions.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of all conversions.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<Conversion> listConversions() {
        return new PagedIterable<>(client.listConversions());
    }
}
