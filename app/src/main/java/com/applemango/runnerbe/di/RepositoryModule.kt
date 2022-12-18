package com.applemango.runnerbe.di

import com.applemango.runnerbe.network.repository.UserRepository
import com.applemango.runnerbe.network.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindProgramListRepo(
        repo : UserRepositoryImpl
    ) : UserRepository
}