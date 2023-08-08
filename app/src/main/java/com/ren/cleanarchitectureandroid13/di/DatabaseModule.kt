package com.ren.cleanarchitectureandroid13.di

import android.content.Context
import androidx.room.Room
import com.ren.cleanarchitectureandroid13.data.local.room.RickAndMortyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideRickAndMortyDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, RickAndMortyDatabase::class.java, "rick_and_morty_database"
    ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideCharacterDao(database: RickAndMortyDatabase) = database.characterDao()
}