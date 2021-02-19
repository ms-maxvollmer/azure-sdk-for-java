// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.storage.queue.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/** The StorageError model. */
@JacksonXmlRootElement(localName = "StorageError")
@Fluent
public final class StorageError {
    /*
     * The Message property.
     */
    @JsonProperty(value = "Message")
    private String message;

    /**
     * Get the message property: The Message property.
     *
     * @return the message value.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Set the message property: The Message property.
     *
     * @param message the message value to set.
     * @return the StorageError object itself.
     */
    public StorageError setMessage(String message) {
        this.message = message;
        return this;
    }
}
