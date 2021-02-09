/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.compute.v2020_10_01_preview;

import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Maintenance Operation Status.
 */
public class MaintenanceRedeployStatus {
    /**
     * True, if customer is allowed to perform Maintenance.
     */
    @JsonProperty(value = "isCustomerInitiatedMaintenanceAllowed")
    private Boolean isCustomerInitiatedMaintenanceAllowed;

    /**
     * Start Time for the Pre Maintenance Window.
     */
    @JsonProperty(value = "preMaintenanceWindowStartTime")
    private DateTime preMaintenanceWindowStartTime;

    /**
     * End Time for the Pre Maintenance Window.
     */
    @JsonProperty(value = "preMaintenanceWindowEndTime")
    private DateTime preMaintenanceWindowEndTime;

    /**
     * Start Time for the Maintenance Window.
     */
    @JsonProperty(value = "maintenanceWindowStartTime")
    private DateTime maintenanceWindowStartTime;

    /**
     * End Time for the Maintenance Window.
     */
    @JsonProperty(value = "maintenanceWindowEndTime")
    private DateTime maintenanceWindowEndTime;

    /**
     * The Last Maintenance Operation Result Code. Possible values include:
     * 'None', 'RetryLater', 'MaintenanceAborted', 'MaintenanceCompleted'.
     */
    @JsonProperty(value = "lastOperationResultCode")
    private MaintenanceOperationResultCodeTypes lastOperationResultCode;

    /**
     * Message returned for the last Maintenance Operation.
     */
    @JsonProperty(value = "lastOperationMessage")
    private String lastOperationMessage;

    /**
     * Get true, if customer is allowed to perform Maintenance.
     *
     * @return the isCustomerInitiatedMaintenanceAllowed value
     */
    public Boolean isCustomerInitiatedMaintenanceAllowed() {
        return this.isCustomerInitiatedMaintenanceAllowed;
    }

    /**
     * Set true, if customer is allowed to perform Maintenance.
     *
     * @param isCustomerInitiatedMaintenanceAllowed the isCustomerInitiatedMaintenanceAllowed value to set
     * @return the MaintenanceRedeployStatus object itself.
     */
    public MaintenanceRedeployStatus withIsCustomerInitiatedMaintenanceAllowed(Boolean isCustomerInitiatedMaintenanceAllowed) {
        this.isCustomerInitiatedMaintenanceAllowed = isCustomerInitiatedMaintenanceAllowed;
        return this;
    }

    /**
     * Get start Time for the Pre Maintenance Window.
     *
     * @return the preMaintenanceWindowStartTime value
     */
    public DateTime preMaintenanceWindowStartTime() {
        return this.preMaintenanceWindowStartTime;
    }

    /**
     * Set start Time for the Pre Maintenance Window.
     *
     * @param preMaintenanceWindowStartTime the preMaintenanceWindowStartTime value to set
     * @return the MaintenanceRedeployStatus object itself.
     */
    public MaintenanceRedeployStatus withPreMaintenanceWindowStartTime(DateTime preMaintenanceWindowStartTime) {
        this.preMaintenanceWindowStartTime = preMaintenanceWindowStartTime;
        return this;
    }

    /**
     * Get end Time for the Pre Maintenance Window.
     *
     * @return the preMaintenanceWindowEndTime value
     */
    public DateTime preMaintenanceWindowEndTime() {
        return this.preMaintenanceWindowEndTime;
    }

    /**
     * Set end Time for the Pre Maintenance Window.
     *
     * @param preMaintenanceWindowEndTime the preMaintenanceWindowEndTime value to set
     * @return the MaintenanceRedeployStatus object itself.
     */
    public MaintenanceRedeployStatus withPreMaintenanceWindowEndTime(DateTime preMaintenanceWindowEndTime) {
        this.preMaintenanceWindowEndTime = preMaintenanceWindowEndTime;
        return this;
    }

    /**
     * Get start Time for the Maintenance Window.
     *
     * @return the maintenanceWindowStartTime value
     */
    public DateTime maintenanceWindowStartTime() {
        return this.maintenanceWindowStartTime;
    }

    /**
     * Set start Time for the Maintenance Window.
     *
     * @param maintenanceWindowStartTime the maintenanceWindowStartTime value to set
     * @return the MaintenanceRedeployStatus object itself.
     */
    public MaintenanceRedeployStatus withMaintenanceWindowStartTime(DateTime maintenanceWindowStartTime) {
        this.maintenanceWindowStartTime = maintenanceWindowStartTime;
        return this;
    }

    /**
     * Get end Time for the Maintenance Window.
     *
     * @return the maintenanceWindowEndTime value
     */
    public DateTime maintenanceWindowEndTime() {
        return this.maintenanceWindowEndTime;
    }

    /**
     * Set end Time for the Maintenance Window.
     *
     * @param maintenanceWindowEndTime the maintenanceWindowEndTime value to set
     * @return the MaintenanceRedeployStatus object itself.
     */
    public MaintenanceRedeployStatus withMaintenanceWindowEndTime(DateTime maintenanceWindowEndTime) {
        this.maintenanceWindowEndTime = maintenanceWindowEndTime;
        return this;
    }

    /**
     * Get the Last Maintenance Operation Result Code. Possible values include: 'None', 'RetryLater', 'MaintenanceAborted', 'MaintenanceCompleted'.
     *
     * @return the lastOperationResultCode value
     */
    public MaintenanceOperationResultCodeTypes lastOperationResultCode() {
        return this.lastOperationResultCode;
    }

    /**
     * Set the Last Maintenance Operation Result Code. Possible values include: 'None', 'RetryLater', 'MaintenanceAborted', 'MaintenanceCompleted'.
     *
     * @param lastOperationResultCode the lastOperationResultCode value to set
     * @return the MaintenanceRedeployStatus object itself.
     */
    public MaintenanceRedeployStatus withLastOperationResultCode(MaintenanceOperationResultCodeTypes lastOperationResultCode) {
        this.lastOperationResultCode = lastOperationResultCode;
        return this;
    }

    /**
     * Get message returned for the last Maintenance Operation.
     *
     * @return the lastOperationMessage value
     */
    public String lastOperationMessage() {
        return this.lastOperationMessage;
    }

    /**
     * Set message returned for the last Maintenance Operation.
     *
     * @param lastOperationMessage the lastOperationMessage value to set
     * @return the MaintenanceRedeployStatus object itself.
     */
    public MaintenanceRedeployStatus withLastOperationMessage(String lastOperationMessage) {
        this.lastOperationMessage = lastOperationMessage;
        return this;
    }

}
