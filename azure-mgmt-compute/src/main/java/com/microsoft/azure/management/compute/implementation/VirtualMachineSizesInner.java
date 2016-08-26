/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.compute.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceResponseBuilder;
import com.microsoft.azure.CloudException;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in VirtualMachineSizes.
 */
public final class VirtualMachineSizesInner {
    /** The Retrofit service to perform REST calls. */
    private VirtualMachineSizesService service;
    /** The service client containing this operation class. */
    private ComputeManagementClientImpl client;

    /**
     * Initializes an instance of VirtualMachineSizesInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public VirtualMachineSizesInner(Retrofit retrofit, ComputeManagementClientImpl client) {
        this.service = retrofit.create(VirtualMachineSizesService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for VirtualMachineSizes to be
     * used by Retrofit to perform actually REST calls.
     */
    interface VirtualMachineSizesService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.Compute/locations/{location}/vmSizes")
        Observable<Response<ResponseBody>> list(@Path("location") String location, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Lists all available virtual machine sizes for a subscription in a location.
     *
     * @param location The location upon which virtual-machine-sizes is queried.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;VirtualMachineSizeInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<List<VirtualMachineSizeInner>> list(String location) throws CloudException, IOException, IllegalArgumentException {
        return listAsync(location).toBlocking().single();
    }

    /**
     * Lists all available virtual machine sizes for a subscription in a location.
     *
     * @param location The location upon which virtual-machine-sizes is queried.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<List<VirtualMachineSizeInner>> listAsync(String location, final ServiceCallback<List<VirtualMachineSizeInner>> serviceCallback) {
        return ServiceCall.create(listAsync(location), serviceCallback);
    }

    /**
     * Lists all available virtual machine sizes for a subscription in a location.
     *
     * @param location The location upon which virtual-machine-sizes is queried.
     * @return the observable to the List&lt;VirtualMachineSizeInner&gt; object
     */
    public Observable<ServiceResponse<List<VirtualMachineSizeInner>>> listAsync(String location) {
        if (location == null) {
            throw new IllegalArgumentException("Parameter location is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.list(location, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<List<VirtualMachineSizeInner>>>>() {
                @Override
                public Observable<ServiceResponse<List<VirtualMachineSizeInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<VirtualMachineSizeInner>> result = listDelegate(response);
                        ServiceResponse<List<VirtualMachineSizeInner>> clientResponse = new ServiceResponse<>(result.getBody().getItems(), result.getResponse());
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<VirtualMachineSizeInner>> listDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<VirtualMachineSizeInner>, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<PageImpl<VirtualMachineSizeInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
