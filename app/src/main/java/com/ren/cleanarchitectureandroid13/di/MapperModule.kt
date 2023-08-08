package com.ren.cleanarchitectureandroid13.di

import com.ren.cleanarchitectureandroid13.data.remote.dtos.character.CharacterDto
import com.ren.cleanarchitectureandroid13.domain.models.Character
import com.ren.cleanarchitectureandroid13.presentation.models.CharacterUI
import com.ren.cleanarchitectureandroid13.utils.mapper.Mapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    @Singleton
    fun provideCharacterMapperUI() = object : Mapper<Character, CharacterUI> {
        override fun toModel(value: Character) = CharacterUI(
            value.image,
            value.gender,
            value.species,
            value.created,
            value.name,
            value.id,
            value.type,
            value.url,
            value.status,
        )

        override fun fromModel(value: CharacterUI) = Character(
            value.image,
            value.gender,
            value.species,
            value.created,
            value.name,
            value.id,
            value.type,
            value.url,
            value.status
        )
    }

    @Provides
    @Singleton
    fun provideCharacterMapperDomain() = object : Mapper<CharacterDto, Character> {
        override fun toModel(value: CharacterDto) = Character(
            value.image,
            value.gender,
            value.species,
            value.created,
            value.name,
            value.id,
            value.type,
            value.url,
            value.status,
        )

        override fun fromModel(value: Character) = CharacterDto(
            value.image,
            value.gender,
            value.species,
            value.created,
            value.name,
            value.id,
            value.type,
            value.url,
            value.status
        )
    }
}