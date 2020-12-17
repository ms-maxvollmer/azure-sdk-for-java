// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mysql.models;

import com.azure.resourcemanager.mysql.fluent.models.OperationListResultInner;
import java.util.List;

/** An immutable client-side representation of OperationListResult. */
public interface OperationListResult {
    /**
     * Gets the value property: The list of resource provider operations.
     *
     * @return the value value.
     */
    List<Operation> value();

    /**
     * Gets the inner com.azure.resourcemanager.mysql.fluent.models.OperationListResultInner object.
     *
     * @return the inner object.
     */
    OperationListResultInner innerModel();
}
