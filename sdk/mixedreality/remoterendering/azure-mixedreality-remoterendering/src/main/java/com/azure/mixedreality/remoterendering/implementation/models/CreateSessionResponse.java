// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.mixedreality.remoterendering.implementation.models;

import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.rest.ResponseBase;

/** Contains all response data for the createSession operation. */
public final class CreateSessionResponse extends ResponseBase<CreateSessionHeaders, SessionProperties> {
    /**
     * Creates an instance of CreateSessionResponse.
     *
     * @param request the request which resulted in this CreateSessionResponse.
     * @param statusCode the status code of the HTTP response.
     * @param rawHeaders the raw headers of the HTTP response.
     * @param value the deserialized value of the HTTP response.
     * @param headers the deserialized headers of the HTTP response.
     */
    public CreateSessionResponse(
            HttpRequest request,
            int statusCode,
            HttpHeaders rawHeaders,
            SessionProperties value,
            CreateSessionHeaders headers) {
        super(request, statusCode, rawHeaders, value, headers);
    }

    /** @return the deserialized response body. */
    @Override
    public SessionProperties getValue() {
        return super.getValue();
    }
}
