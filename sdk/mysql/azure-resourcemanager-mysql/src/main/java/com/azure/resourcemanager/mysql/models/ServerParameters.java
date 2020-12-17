// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mysql.models;

import com.azure.core.util.Context;
import com.azure.resourcemanager.mysql.fluent.models.ConfigurationListResultInner;

/** Resource collection API of ServerParameters. */
public interface ServerParameters {
    /**
     * Update a list of configurations in a given server.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serverName The name of the server.
     * @param value The parameters for updating a list of server configuration.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of server configurations.
     */
    ConfigurationListResult listUpdateConfigurations(
        String resourceGroupName, String serverName, ConfigurationListResultInner value);

    /**
     * Update a list of configurations in a given server.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serverName The name of the server.
     * @param value The parameters for updating a list of server configuration.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of server configurations.
     */
    ConfigurationListResult listUpdateConfigurations(
        String resourceGroupName, String serverName, ConfigurationListResultInner value, Context context);
}
