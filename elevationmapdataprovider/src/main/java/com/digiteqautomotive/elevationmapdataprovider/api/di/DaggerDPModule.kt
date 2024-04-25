package com.digiteqautomotive.elevationmapdataprovider.api.di

import com.digiteqautomotive.elevationmapdataprovider.api.DataProviderApi
import com.digiteqautomotive.elevationmapdataprovider.implementation.DataProviderImpl
import dagger.Provides
import dagger.Module
import javax.inject.Singleton

@Module
class DaggerDPModule {
    @Singleton
    @Provides
    fun provideLoginRetrofitService(): DataProviderApi {
        return DataProviderImpl()
    }
}