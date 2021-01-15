// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.mixedreality.remoterendering.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Settings for the conversion input. */
@Fluent
public final class ConversionInputSettings {
    /*
     * The URI of the Azure blob storage container containing the input model.
     */
    @JsonProperty(value = "storageContainerUri", required = true)
    private String storageContainerUri;

    /*
     * A Azure blob storage container shared access signature giving read and
     * list access to the storage container. Optional. If not is not provided
     * the Azure Remote Rendering rendering account needs to be linked with the
     * storage account containing the blob container.
     */
    @JsonProperty(value = "storageContainerReadListSas")
    private String storageContainerReadListSas;

    /*
     * Only Blobs starting with this prefix will be downloaded to perform the
     * conversion.
     */
    @JsonProperty(value = "blobPrefix")
    private String blobPrefix;

    /*
     * The relative path starting at blobPrefix (or at the container root if
     * blobPrefix is not specified) to the input model. Must point to file with
     * a supported file format ending.
     */
    @JsonProperty(value = "relativeInputAssetPath", required = true)
    private String relativeInputAssetPath;

    /**
     * Creates an instance of ConversionInputSettings class.
     *
     * @param storageContainerUri the storageContainerUri value to set.
     * @param relativeInputAssetPath the relativeInputAssetPath value to set.
     */
    @JsonCreator
    public ConversionInputSettings(
            @JsonProperty(value = "storageContainerUri", required = true) String storageContainerUri,
            @JsonProperty(value = "relativeInputAssetPath", required = true) String relativeInputAssetPath) {
        this.storageContainerUri = storageContainerUri;
        this.relativeInputAssetPath = relativeInputAssetPath;
    }

    /**
     * Get the storageContainerUri property: The URI of the Azure blob storage container containing the input model.
     *
     * @return the storageContainerUri value.
     */
    public String getStorageContainerUri() {
        return this.storageContainerUri;
    }

    /**
     * Get the storageContainerReadListSas property: A Azure blob storage container shared access signature giving read
     * and list access to the storage container. Optional. If not is not provided the Azure Remote Rendering rendering
     * account needs to be linked with the storage account containing the blob container.
     *
     * @return the storageContainerReadListSas value.
     */
    public String getStorageContainerReadListSas() {
        return this.storageContainerReadListSas;
    }

    /**
     * Set the storageContainerReadListSas property: A Azure blob storage container shared access signature giving read
     * and list access to the storage container. Optional. If not is not provided the Azure Remote Rendering rendering
     * account needs to be linked with the storage account containing the blob container.
     *
     * @param storageContainerReadListSas the storageContainerReadListSas value to set.
     * @return the ConversionInputSettings object itself.
     */
    public ConversionInputSettings setStorageContainerReadListSas(String storageContainerReadListSas) {
        this.storageContainerReadListSas = storageContainerReadListSas;
        return this;
    }

    /**
     * Get the blobPrefix property: Only Blobs starting with this prefix will be downloaded to perform the conversion.
     *
     * @return the blobPrefix value.
     */
    public String getBlobPrefix() {
        return this.blobPrefix;
    }

    /**
     * Set the blobPrefix property: Only Blobs starting with this prefix will be downloaded to perform the conversion.
     *
     * @param blobPrefix the blobPrefix value to set.
     * @return the ConversionInputSettings object itself.
     */
    public ConversionInputSettings setBlobPrefix(String blobPrefix) {
        this.blobPrefix = blobPrefix;
        return this;
    }

    /**
     * Get the relativeInputAssetPath property: The relative path starting at blobPrefix (or at the container root if
     * blobPrefix is not specified) to the input model. Must point to file with a supported file format ending.
     *
     * @return the relativeInputAssetPath value.
     */
    public String getRelativeInputAssetPath() {
        return this.relativeInputAssetPath;
    }
}
