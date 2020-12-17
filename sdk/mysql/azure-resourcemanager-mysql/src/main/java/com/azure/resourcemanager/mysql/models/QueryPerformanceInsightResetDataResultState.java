// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mysql.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for QueryPerformanceInsightResetDataResultState. */
public final class QueryPerformanceInsightResetDataResultState
    extends ExpandableStringEnum<QueryPerformanceInsightResetDataResultState> {
    /** Static value Succeeded for QueryPerformanceInsightResetDataResultState. */
    public static final QueryPerformanceInsightResetDataResultState SUCCEEDED = fromString("Succeeded");

    /** Static value Failed for QueryPerformanceInsightResetDataResultState. */
    public static final QueryPerformanceInsightResetDataResultState FAILED = fromString("Failed");

    /**
     * Creates or finds a QueryPerformanceInsightResetDataResultState from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding QueryPerformanceInsightResetDataResultState.
     */
    @JsonCreator
    public static QueryPerformanceInsightResetDataResultState fromString(String name) {
        return fromString(name, QueryPerformanceInsightResetDataResultState.class);
    }

    /** @return known QueryPerformanceInsightResetDataResultState values. */
    public static Collection<QueryPerformanceInsightResetDataResultState> values() {
        return values(QueryPerformanceInsightResetDataResultState.class);
    }
}
