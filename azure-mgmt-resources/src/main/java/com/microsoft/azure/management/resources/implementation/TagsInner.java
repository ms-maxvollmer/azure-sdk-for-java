/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.resources.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceCall;
import com.microsoft.azure.AzureServiceResponseBuilder;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.RestException;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.HTTP;
import retrofit2.http.Path;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in Tags.
 */
public final class TagsInner {
    /** The Retrofit service to perform REST calls. */
    private TagsService service;
    /** The service client containing this operation class. */
    private ResourceManagementClientImpl client;

    /**
     * Initializes an instance of TagsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public TagsInner(Retrofit retrofit, ResourceManagementClientImpl client) {
        this.service = retrofit.create(TagsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for Tags to be
     * used by Retrofit to perform actually REST calls.
     */
    interface TagsService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @HTTP(path = "subscriptions/{subscriptionId}/tagNames/{tagName}/tagValues/{tagValue}", method = "DELETE", hasBody = true)
        Observable<Response<ResponseBody>> deleteValue(@Path("tagName") String tagName, @Path("tagValue") String tagValue, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @PUT("subscriptions/{subscriptionId}/tagNames/{tagName}/tagValues/{tagValue}")
        Observable<Response<ResponseBody>> createOrUpdateValue(@Path("tagName") String tagName, @Path("tagValue") String tagValue, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @PUT("subscriptions/{subscriptionId}/tagNames/{tagName}")
        Observable<Response<ResponseBody>> createOrUpdate(@Path("tagName") String tagName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @HTTP(path = "subscriptions/{subscriptionId}/tagNames/{tagName}", method = "DELETE", hasBody = true)
        Observable<Response<ResponseBody>> delete(@Path("tagName") String tagName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/tagNames")
        Observable<Response<ResponseBody>> list(@Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("{nextLink}")
        Observable<Response<ResponseBody>> listNext(@Path(value = "nextLink", encoded = true) String nextPageLink, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Delete a subscription resource tag value.
     *
     * @param tagName The name of the tag.
     * @param tagValue The value of the tag.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    public ServiceResponse<Void> deleteValue(String tagName, String tagValue) throws CloudException, IOException, IllegalArgumentException {
        return deleteValueAsync(tagName, tagValue).toBlocking().single();
    }

    /**
     * Delete a subscription resource tag value.
     *
     * @param tagName The name of the tag.
     * @param tagValue The value of the tag.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<Void> deleteValueAsync(String tagName, String tagValue, final ServiceCallback<Void> serviceCallback) {
        return ServiceCall.create(deleteValueAsync(tagName, tagValue), serviceCallback);
    }

    /**
     * Delete a subscription resource tag value.
     *
     * @param tagName The name of the tag.
     * @param tagValue The value of the tag.
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<ServiceResponse<Void>> deleteValueAsync(String tagName, String tagValue) {
        if (tagName == null) {
            throw new IllegalArgumentException("Parameter tagName is required and cannot be null.");
        }
        if (tagValue == null) {
            throw new IllegalArgumentException("Parameter tagValue is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.deleteValue(tagName, tagValue, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Void>>>() {
                @Override
                public Observable<ServiceResponse<Void>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<Void> clientResponse = deleteValueDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<Void> deleteValueDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<Void>() { }.getType())
                .register(204, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * Create a subscription resource tag value.
     *
     * @param tagName The name of the tag.
     * @param tagValue The value of the tag.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the TagValueInner object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<TagValueInner> createOrUpdateValue(String tagName, String tagValue) throws CloudException, IOException, IllegalArgumentException {
        return createOrUpdateValueAsync(tagName, tagValue).toBlocking().single();
    }

    /**
     * Create a subscription resource tag value.
     *
     * @param tagName The name of the tag.
     * @param tagValue The value of the tag.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<TagValueInner> createOrUpdateValueAsync(String tagName, String tagValue, final ServiceCallback<TagValueInner> serviceCallback) {
        return ServiceCall.create(createOrUpdateValueAsync(tagName, tagValue), serviceCallback);
    }

    /**
     * Create a subscription resource tag value.
     *
     * @param tagName The name of the tag.
     * @param tagValue The value of the tag.
     * @return the observable to the TagValueInner object
     */
    public Observable<ServiceResponse<TagValueInner>> createOrUpdateValueAsync(String tagName, String tagValue) {
        if (tagName == null) {
            throw new IllegalArgumentException("Parameter tagName is required and cannot be null.");
        }
        if (tagValue == null) {
            throw new IllegalArgumentException("Parameter tagValue is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.createOrUpdateValue(tagName, tagValue, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<TagValueInner>>>() {
                @Override
                public Observable<ServiceResponse<TagValueInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<TagValueInner> clientResponse = createOrUpdateValueDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<TagValueInner> createOrUpdateValueDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<TagValueInner, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<TagValueInner>() { }.getType())
                .register(201, new TypeToken<TagValueInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Create a subscription resource tag.
     *
     * @param tagName The name of the tag.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the TagDetailsInner object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<TagDetailsInner> createOrUpdate(String tagName) throws CloudException, IOException, IllegalArgumentException {
        return createOrUpdateAsync(tagName).toBlocking().single();
    }

    /**
     * Create a subscription resource tag.
     *
     * @param tagName The name of the tag.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<TagDetailsInner> createOrUpdateAsync(String tagName, final ServiceCallback<TagDetailsInner> serviceCallback) {
        return ServiceCall.create(createOrUpdateAsync(tagName), serviceCallback);
    }

    /**
     * Create a subscription resource tag.
     *
     * @param tagName The name of the tag.
     * @return the observable to the TagDetailsInner object
     */
    public Observable<ServiceResponse<TagDetailsInner>> createOrUpdateAsync(String tagName) {
        if (tagName == null) {
            throw new IllegalArgumentException("Parameter tagName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.createOrUpdate(tagName, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<TagDetailsInner>>>() {
                @Override
                public Observable<ServiceResponse<TagDetailsInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<TagDetailsInner> clientResponse = createOrUpdateDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<TagDetailsInner> createOrUpdateDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<TagDetailsInner, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<TagDetailsInner>() { }.getType())
                .register(201, new TypeToken<TagDetailsInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Delete a subscription resource tag.
     *
     * @param tagName The name of the tag.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    public ServiceResponse<Void> delete(String tagName) throws CloudException, IOException, IllegalArgumentException {
        return deleteAsync(tagName).toBlocking().single();
    }

    /**
     * Delete a subscription resource tag.
     *
     * @param tagName The name of the tag.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<Void> deleteAsync(String tagName, final ServiceCallback<Void> serviceCallback) {
        return ServiceCall.create(deleteAsync(tagName), serviceCallback);
    }

    /**
     * Delete a subscription resource tag.
     *
     * @param tagName The name of the tag.
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<ServiceResponse<Void>> deleteAsync(String tagName) {
        if (tagName == null) {
            throw new IllegalArgumentException("Parameter tagName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.delete(tagName, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Void>>>() {
                @Override
                public Observable<ServiceResponse<Void>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<Void> clientResponse = deleteDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<Void> deleteDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<Void>() { }.getType())
                .register(204, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * Get a list of subscription resource tags.
     *
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;TagDetailsInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<PagedList<TagDetailsInner>> list() throws CloudException, IOException, IllegalArgumentException {
        ServiceResponse<Page<TagDetailsInner>> response = listSinglePageAsync().toBlocking().single();
        PagedList<TagDetailsInner> pagedList = new PagedList<TagDetailsInner>(response.getBody()) {
            @Override
            public Page<TagDetailsInner> nextPage(String nextPageLink) throws RestException, IOException {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().getBody();
            }
        };
        return new ServiceResponse<>(pagedList, response.getResponse());
    }

    /**
     * Get a list of subscription resource tags.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<Page<TagDetailsInner>> listAsync(final ListOperationCallback<TagDetailsInner> serviceCallback) {
        return AzureServiceCall.create(
            listSinglePageAsync(),
            new Func1<String, Observable<ServiceResponse<Page<TagDetailsInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TagDetailsInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Get a list of subscription resource tags.
     *
     * @return the observable to the List&lt;TagDetailsInner&gt; object
     */
    public Observable<ServiceResponse<Page<TagDetailsInner>>> listAsync() {
        return listSinglePageAsync()
            .concatMap(new Func1<ServiceResponse<Page<TagDetailsInner>>, Observable<ServiceResponse<Page<TagDetailsInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TagDetailsInner>>> call(ServiceResponse<Page<TagDetailsInner>> page) {
                    String nextPageLink = page.getBody().getNextPageLink();
                    return listNextSinglePageAsync(nextPageLink);
                }
            });
    }

    /**
     * Get a list of subscription resource tags.
     *
     * @return the List&lt;TagDetailsInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<TagDetailsInner>>> listSinglePageAsync() {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.list(this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<TagDetailsInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TagDetailsInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<TagDetailsInner>> result = listDelegate(response);
                        return Observable.just(new ServiceResponse<Page<TagDetailsInner>>(result.getBody(), result.getResponse()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<TagDetailsInner>> listDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<TagDetailsInner>, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<PageImpl<TagDetailsInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Get a list of subscription resource tags.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;TagDetailsInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<PagedList<TagDetailsInner>> listNext(final String nextPageLink) throws CloudException, IOException, IllegalArgumentException {
        ServiceResponse<Page<TagDetailsInner>> response = listNextSinglePageAsync(nextPageLink).toBlocking().single();
        PagedList<TagDetailsInner> pagedList = new PagedList<TagDetailsInner>(response.getBody()) {
            @Override
            public Page<TagDetailsInner> nextPage(String nextPageLink) throws RestException, IOException {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().getBody();
            }
        };
        return new ServiceResponse<>(pagedList, response.getResponse());
    }

    /**
     * Get a list of subscription resource tags.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<Page<TagDetailsInner>> listNextAsync(final String nextPageLink, final ServiceCall<Page<TagDetailsInner>> serviceCall, final ListOperationCallback<TagDetailsInner> serviceCallback) {
        return AzureServiceCall.create(
            listNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponse<Page<TagDetailsInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TagDetailsInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Get a list of subscription resource tags.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @return the observable to the List&lt;TagDetailsInner&gt; object
     */
    public Observable<ServiceResponse<Page<TagDetailsInner>>> listNextAsync(final String nextPageLink) {
        return listNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponse<Page<TagDetailsInner>>, Observable<ServiceResponse<Page<TagDetailsInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TagDetailsInner>>> call(ServiceResponse<Page<TagDetailsInner>> page) {
                    String nextPageLink = page.getBody().getNextPageLink();
                    return listNextSinglePageAsync(nextPageLink);
                }
            });
    }

    /**
     * Get a list of subscription resource tags.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @return the List&lt;TagDetailsInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<TagDetailsInner>>> listNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        return service.listNext(nextPageLink, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<TagDetailsInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TagDetailsInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<TagDetailsInner>> result = listNextDelegate(response);
                        return Observable.just(new ServiceResponse<Page<TagDetailsInner>>(result.getBody(), result.getResponse()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<TagDetailsInner>> listNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<TagDetailsInner>, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<PageImpl<TagDetailsInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
