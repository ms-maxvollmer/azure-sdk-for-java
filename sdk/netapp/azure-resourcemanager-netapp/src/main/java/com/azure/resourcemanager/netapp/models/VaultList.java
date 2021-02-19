// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.netapp.fluent.models.VaultInner;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** List of Vaults. */
@Fluent
public final class VaultList {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(VaultList.class);

    /*
     * A list of vaults
     */
    @JsonProperty(value = "value")
    private List<VaultInner> value;

    /**
     * Get the value property: A list of vaults.
     *
     * @return the value value.
     */
    public List<VaultInner> value() {
        return this.value;
    }

    /**
     * Set the value property: A list of vaults.
     *
     * @param value the value value to set.
     * @return the VaultList object itself.
     */
    public VaultList withValue(List<VaultInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }
}
