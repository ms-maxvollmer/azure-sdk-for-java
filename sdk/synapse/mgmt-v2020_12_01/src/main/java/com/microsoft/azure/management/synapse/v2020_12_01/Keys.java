/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.synapse.v2020_12_01;

import com.microsoft.azure.arm.collection.SupportsCreating;
import rx.Completable;
import rx.Observable;
import com.microsoft.azure.management.synapse.v2020_12_01.implementation.KeysInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing Keys.
 */
public interface Keys extends SupportsCreating<Key.DefinitionStages.Blank>, HasInner<KeysInner> {
    /**
     * Gets a workspace key.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace
     * @param keyName The name of the workspace key
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<Key> getAsync(String resourceGroupName, String workspaceName, String keyName);

    /**
     * Returns a list of keys in a workspace.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<Key> listByWorkspaceAsync(final String resourceGroupName, final String workspaceName);

    /**
     * Deletes a workspace key.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace
     * @param keyName The name of the workspace key
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable deleteAsync(String resourceGroupName, String workspaceName, String keyName);

}
