/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.compute.v2020_12_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies the boot diagnostic settings state. &lt;br&gt;&lt;br&gt;Minimum
 * api-version: 2015-06-15.
 */
public class DiagnosticsProfile {
    /**
     * Boot Diagnostics is a debugging feature which allows you to view Console
     * Output and Screenshot to diagnose VM status. &lt;br&gt;&lt;br&gt; You
     * can easily view the output of your console log. &lt;br&gt;&lt;br&gt;
     * Azure also enables you to see a screenshot of the VM from the
     * hypervisor.
     */
    @JsonProperty(value = "bootDiagnostics")
    private BootDiagnostics bootDiagnostics;

    /**
     * Get boot Diagnostics is a debugging feature which allows you to view Console Output and Screenshot to diagnose VM status. &lt;br&gt;&lt;br&gt; You can easily view the output of your console log. &lt;br&gt;&lt;br&gt; Azure also enables you to see a screenshot of the VM from the hypervisor.
     *
     * @return the bootDiagnostics value
     */
    public BootDiagnostics bootDiagnostics() {
        return this.bootDiagnostics;
    }

    /**
     * Set boot Diagnostics is a debugging feature which allows you to view Console Output and Screenshot to diagnose VM status. &lt;br&gt;&lt;br&gt; You can easily view the output of your console log. &lt;br&gt;&lt;br&gt; Azure also enables you to see a screenshot of the VM from the hypervisor.
     *
     * @param bootDiagnostics the bootDiagnostics value to set
     * @return the DiagnosticsProfile object itself.
     */
    public DiagnosticsProfile withBootDiagnostics(BootDiagnostics bootDiagnostics) {
        this.bootDiagnostics = bootDiagnostics;
        return this;
    }

}
