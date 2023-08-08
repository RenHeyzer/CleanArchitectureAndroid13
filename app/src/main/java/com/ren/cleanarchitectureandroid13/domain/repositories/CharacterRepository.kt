package com.ren.cleanarchitectureandroid13.domain.repositories

import com.ren.cleanarchitectureandroid13.domain.either.Either
import com.ren.cleanarchitectureandroid13.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun fetchCharacters(): Flow<Either<String, List<Character>>>

    suspend fun insertCharacters(characters: List<Character>)

    fun fetchLocalCharacters(): Flow<Either<String, List<Character>>>

    fun fetchLocalCharactersFlow(): Flow<List<Character>>
}