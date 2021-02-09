/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.synapse.v2020_12_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.synapse.v2020_12_01.RestorableDroppedSqlPools;
import rx.Observable;
import rx.functions.Func1;
import java.util.List;
import com.microsoft.azure.management.synapse.v2020_12_01.RestorableDroppedSqlPool;

class RestorableDroppedSqlPoolsImpl extends WrapperImpl<RestorableDroppedSqlPoolsInner> implements RestorableDroppedSqlPools {
    private final SynapseManager manager;

    RestorableDroppedSqlPoolsImpl(SynapseManager manager) {
        super(manager.inner().restorableDroppedSqlPools());
        this.manager = manager;
    }

    public SynapseManager manager() {
        return this.manager;
    }

    private RestorableDroppedSqlPoolImpl wrapModel(RestorableDroppedSqlPoolInner inner) {
        return  new RestorableDroppedSqlPoolImpl(inner, manager());
    }

    @Override
    public Observable<RestorableDroppedSqlPool> listByWorkspaceAsync(String resourceGroupName, String workspaceName) {
        RestorableDroppedSqlPoolsInner client = this.inner();
        return client.listByWorkspaceAsync(resourceGroupName, workspaceName)
        .flatMap(new Func1<List<RestorableDroppedSqlPoolInner>, Observable<RestorableDroppedSqlPoolInner>>() {
            @Override
            public Observable<RestorableDroppedSqlPoolInner> call(List<RestorableDroppedSqlPoolInner> innerList) {
                return Observable.from(innerList);
            }
        })
        .map(new Func1<RestorableDroppedSqlPoolInner, RestorableDroppedSqlPool>() {
            @Override
            public RestorableDroppedSqlPool call(RestorableDroppedSqlPoolInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public Observable<RestorableDroppedSqlPool> getAsync(String resourceGroupName, String workspaceName, String restorableDroppedSqlPoolId) {
        RestorableDroppedSqlPoolsInner client = this.inner();
        return client.getAsync(resourceGroupName, workspaceName, restorableDroppedSqlPoolId)
        .flatMap(new Func1<RestorableDroppedSqlPoolInner, Observable<RestorableDroppedSqlPool>>() {
            @Override
            public Observable<RestorableDroppedSqlPool> call(RestorableDroppedSqlPoolInner inner) {
                if (inner == null) {
                    return Observable.empty();
                } else {
                    return Observable.just((RestorableDroppedSqlPool)wrapModel(inner));
                }
            }
       });
    }

}
