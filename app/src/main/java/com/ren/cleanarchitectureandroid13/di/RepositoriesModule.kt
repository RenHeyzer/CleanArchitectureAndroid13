package com.ren.cleanarchitectureandroid13.di

import com.ren.cleanarchitectureandroid13.data.repositories.CharacterRepositoryImpl
import com.ren.cleanarchitectureandroid13.domain.repositories.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindCharacterRepository(repositoryImpl: CharacterRepositoryImpl): CharacterRepository
}