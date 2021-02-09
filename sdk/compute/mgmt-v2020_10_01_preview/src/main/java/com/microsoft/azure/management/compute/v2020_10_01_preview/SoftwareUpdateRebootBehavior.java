/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.compute.v2020_10_01_preview;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for SoftwareUpdateRebootBehavior.
 */
public final class SoftwareUpdateRebootBehavior extends ExpandableStringEnum<SoftwareUpdateRebootBehavior> {
    /** Static value NeverReboots for SoftwareUpdateRebootBehavior. */
    public static final SoftwareUpdateRebootBehavior NEVER_REBOOTS = fromString("NeverReboots");

    /** Static value AlwaysRequiresReboot for SoftwareUpdateRebootBehavior. */
    public static final SoftwareUpdateRebootBehavior ALWAYS_REQUIRES_REBOOT = fromString("AlwaysRequiresReboot");

    /** Static value CanRequestReboot for SoftwareUpdateRebootBehavior. */
    public static final SoftwareUpdateRebootBehavior CAN_REQUEST_REBOOT = fromString("CanRequestReboot");

    /**
     * Creates or finds a SoftwareUpdateRebootBehavior from its string representation.
     * @param name a name to look for
     * @return the corresponding SoftwareUpdateRebootBehavior
     */
    @JsonCreator
    public static SoftwareUpdateRebootBehavior fromString(String name) {
        return fromString(name, SoftwareUpdateRebootBehavior.class);
    }

    /**
     * @return known SoftwareUpdateRebootBehavior values
     */
    public static Collection<SoftwareUpdateRebootBehavior> values() {
        return values(SoftwareUpdateRebootBehavior.class);
    }
}
