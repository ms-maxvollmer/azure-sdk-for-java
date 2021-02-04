package com.azure.mixedreality.remoterendering.models;

import com.azure.mixedreality.remoterendering.models.internal.ModelTranslator;

import java.time.OffsetDateTime;

public class Conversion {
    private String id;
    private ConversionOptions options;
    private String outputAssetUri;
    private RemoteRenderingServiceError error;
    private ConversionStatus conversionStatus;
    private OffsetDateTime creationTime;


    public Conversion setId(String id) {
        this.id = id;
        return this;
    }

    public Conversion setOptions(ConversionOptions options) {
        this.options = options;
        return this;
    }

    public Conversion setOutputAssetUri(String outputAssetUri) {
        this.outputAssetUri = outputAssetUri;
        return this;
    }

    public Conversion setError(RemoteRenderingServiceError error) {
        this.error = error;
        return this;
    }

    public Conversion setConversionStatus(ConversionStatus conversionStatus) {
        this.conversionStatus = conversionStatus;
        return this;
    }

    public Conversion setCreationTime(OffsetDateTime creationTime) {
        this.creationTime = creationTime;
        return this;
    }



    /**
     * Get the id property: The id of the conversion supplied when the conversion was created.
     *
     * @return the id value.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Get the conversion options: Options for where to retrieve input files from and where to write output files.
     * Supplied when creating the conversion.
     *
     * @return the conversion options value.
     */
    public ConversionOptions getOptions() {
        return this.options;
    }

    /**
     * Get the outputAssetUri property: URL of the asset generated by the conversion process. Only present when the status of
     * the conversion is 'Succeeded'.
     *
     * @return the outputAssetUri value.
     */
    public String getOutputAssetUri() {
        return this.outputAssetUri;
    }

    /**
     * Get the error property: The error object containing details about the conversion failure.
     *
     * @return the error value.
     */
    public RemoteRenderingServiceError getError() {
        return this.error;
    }

    /**
     * Get the status property: The status of the conversion. Terminal states are CANCELLED, FAILED, or SUCCEEDED.
     *
     * @return the status value.
     */
    public ConversionStatus getStatus() {
        return this.conversionStatus;
    }

    /**
     * Get the creationTime property: The time when the conversion was created. Date and time in ISO 8601 format.
     *
     * @return the creationTime value.
     */
    public OffsetDateTime getCreationTime() {
        return this.creationTime;
    }
}
