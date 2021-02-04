// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.mixedreality.remoterendering.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The CreateSessionSettings model. */
@Fluent
public final class CreateSessionSettings {
    /*
     * The time in minutes the session will run after reaching the 'Ready'
     * state.
     */
    @JsonProperty(value = "maxLeaseTimeMinutes", required = true)
    private int maxLeaseTimeMinutes;

    /*
     * Size of the server used for the rendering session. Remote Rendering with
     * Standard size server has a maximum scene size of 20 million polygons.
     * Remote Rendering with Premium size does not enforce a hard maximum, but
     * performance may be degraded if your content exceeds the rendering
     * capabilities of the service.
     */
    @JsonProperty(value = "size", required = true)
    private SessionSize size;

    /**
     * Creates an instance of CreateSessionSettings class.
     *
     * @param maxLeaseTimeMinutes the maxLeaseTimeMinutes value to set.
     * @param size the size value to set.
     */
    @JsonCreator
    public CreateSessionSettings(
            @JsonProperty(value = "maxLeaseTimeMinutes", required = true) int maxLeaseTimeMinutes,
            @JsonProperty(value = "size", required = true) SessionSize size) {
        this.maxLeaseTimeMinutes = maxLeaseTimeMinutes;
        this.size = size;
    }

    /**
     * Get the maxLeaseTimeMinutes property: The time in minutes the session will run after reaching the 'Ready' state.
     *
     * @return the maxLeaseTimeMinutes value.
     */
    public int getMaxLeaseTimeMinutes() {
        return this.maxLeaseTimeMinutes;
    }

    /**
     * Get the size property: Size of the server used for the rendering session. Remote Rendering with Standard size
     * server has a maximum scene size of 20 million polygons. Remote Rendering with Premium size does not enforce a
     * hard maximum, but performance may be degraded if your content exceeds the rendering capabilities of the service.
     *
     * @return the size value.
     */
    public SessionSize getSize() {
        return this.size;
    }
}
