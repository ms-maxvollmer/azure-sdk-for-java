/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.compute.v2020_10_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * LogAnalytics output properties.
 */
public class LogAnalyticsOutput {
    /**
     * Output file Uri path to blob container.
     */
    @JsonProperty(value = "output", access = JsonProperty.Access.WRITE_ONLY)
    private String output;

    /**
     * Get output file Uri path to blob container.
     *
     * @return the output value
     */
    public String output() {
        return this.output;
    }

}
