package com.digiteqautomotive.elevationmapdataprovider.api

import kotlinx.coroutines.flow.Flow

interface DataProviderApi {
    fun getElevation(): Flow<List<String>>
}