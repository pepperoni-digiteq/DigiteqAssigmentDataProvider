package com.digiteqautomotive.elevationmapdataprovider.api.di

import com.digiteqautomotive.elevationmapdataprovider.api.DataProviderApi
import com.digiteqautomotive.elevationmapdataprovider.implementation.DataProviderImpl
import org.koin.dsl.module

val koinDPModule = module {
    single<DataProviderApi> { DataProviderImpl() }
}