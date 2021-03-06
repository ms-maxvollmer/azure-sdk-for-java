/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.mysql.v2020_01_01;

import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * Input to get top query statistics.
 */
@JsonFlatten
public class TopQueryStatisticsInput {
    /**
     * Max number of top queries to return.
     */
    @JsonProperty(value = "properties.numberOfTopQueries", required = true)
    private int numberOfTopQueries;

    /**
     * Aggregation function name.
     */
    @JsonProperty(value = "properties.aggregationFunction", required = true)
    private String aggregationFunction;

    /**
     * Observed metric name.
     */
    @JsonProperty(value = "properties.observedMetric", required = true)
    private String observedMetric;

    /**
     * Observation start time.
     */
    @JsonProperty(value = "properties.observationStartTime", required = true)
    private DateTime observationStartTime;

    /**
     * Observation end time.
     */
    @JsonProperty(value = "properties.observationEndTime", required = true)
    private DateTime observationEndTime;

    /**
     * Aggregation interval type in ISO 8601 format.
     */
    @JsonProperty(value = "properties.aggregationWindow", required = true)
    private String aggregationWindow;

    /**
     * Get max number of top queries to return.
     *
     * @return the numberOfTopQueries value
     */
    public int numberOfTopQueries() {
        return this.numberOfTopQueries;
    }

    /**
     * Set max number of top queries to return.
     *
     * @param numberOfTopQueries the numberOfTopQueries value to set
     * @return the TopQueryStatisticsInput object itself.
     */
    public TopQueryStatisticsInput withNumberOfTopQueries(int numberOfTopQueries) {
        this.numberOfTopQueries = numberOfTopQueries;
        return this;
    }

    /**
     * Get aggregation function name.
     *
     * @return the aggregationFunction value
     */
    public String aggregationFunction() {
        return this.aggregationFunction;
    }

    /**
     * Set aggregation function name.
     *
     * @param aggregationFunction the aggregationFunction value to set
     * @return the TopQueryStatisticsInput object itself.
     */
    public TopQueryStatisticsInput withAggregationFunction(String aggregationFunction) {
        this.aggregationFunction = aggregationFunction;
        return this;
    }

    /**
     * Get observed metric name.
     *
     * @return the observedMetric value
     */
    public String observedMetric() {
        return this.observedMetric;
    }

    /**
     * Set observed metric name.
     *
     * @param observedMetric the observedMetric value to set
     * @return the TopQueryStatisticsInput object itself.
     */
    public TopQueryStatisticsInput withObservedMetric(String observedMetric) {
        this.observedMetric = observedMetric;
        return this;
    }

    /**
     * Get observation start time.
     *
     * @return the observationStartTime value
     */
    public DateTime observationStartTime() {
        return this.observationStartTime;
    }

    /**
     * Set observation start time.
     *
     * @param observationStartTime the observationStartTime value to set
     * @return the TopQueryStatisticsInput object itself.
     */
    public TopQueryStatisticsInput withObservationStartTime(DateTime observationStartTime) {
        this.observationStartTime = observationStartTime;
        return this;
    }

    /**
     * Get observation end time.
     *
     * @return the observationEndTime value
     */
    public DateTime observationEndTime() {
        return this.observationEndTime;
    }

    /**
     * Set observation end time.
     *
     * @param observationEndTime the observationEndTime value to set
     * @return the TopQueryStatisticsInput object itself.
     */
    public TopQueryStatisticsInput withObservationEndTime(DateTime observationEndTime) {
        this.observationEndTime = observationEndTime;
        return this;
    }

    /**
     * Get aggregation interval type in ISO 8601 format.
     *
     * @return the aggregationWindow value
     */
    public String aggregationWindow() {
        return this.aggregationWindow;
    }

    /**
     * Set aggregation interval type in ISO 8601 format.
     *
     * @param aggregationWindow the aggregationWindow value to set
     * @return the TopQueryStatisticsInput object itself.
     */
    public TopQueryStatisticsInput withAggregationWindow(String aggregationWindow) {
        this.aggregationWindow = aggregationWindow;
        return this;
    }

}
