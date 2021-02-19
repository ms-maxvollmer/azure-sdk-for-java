// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.netapp.NetAppManager;
import com.azure.resourcemanager.netapp.fluent.VaultsClient;
import com.azure.resourcemanager.netapp.fluent.models.VaultInner;
import com.azure.resourcemanager.netapp.models.Vault;
import com.azure.resourcemanager.netapp.models.Vaults;
import com.fasterxml.jackson.annotation.JsonIgnore;

public final class VaultsImpl implements Vaults {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(VaultsImpl.class);

    private final VaultsClient innerClient;

    private final NetAppManager serviceManager;

    public VaultsImpl(VaultsClient innerClient, NetAppManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<Vault> list(String resourceGroupName, String accountName) {
        PagedIterable<VaultInner> inner = this.serviceClient().list(resourceGroupName, accountName);
        return Utils.mapPage(inner, inner1 -> new VaultImpl(inner1, this.manager()));
    }

    public PagedIterable<Vault> list(String resourceGroupName, String accountName, Context context) {
        PagedIterable<VaultInner> inner = this.serviceClient().list(resourceGroupName, accountName, context);
        return Utils.mapPage(inner, inner1 -> new VaultImpl(inner1, this.manager()));
    }

    private VaultsClient serviceClient() {
        return this.innerClient;
    }

    private NetAppManager manager() {
        return this.serviceManager;
    }
}
