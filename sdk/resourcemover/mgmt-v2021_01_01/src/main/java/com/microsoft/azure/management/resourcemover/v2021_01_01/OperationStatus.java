/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.resourcemover.v2021_01_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.resourcemover.v2021_01_01.implementation.ResourceMoverManager;
import com.microsoft.azure.management.resourcemover.v2021_01_01.implementation.OperationStatusInner;

/**
 * Type representing OperationStatus.
 */
public interface OperationStatus extends HasInner<OperationStatusInner>, HasManager<ResourceMoverManager> {
    /**
     * @return the endTime value.
     */
    String endTime();

    /**
     * @return the error value.
     */
    OperationStatusError error();

    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the properties value.
     */
    Object properties();

    /**
     * @return the startTime value.
     */
    String startTime();

    /**
     * @return the status value.
     */
    String status();

}
