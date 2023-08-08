package com.ren.cleanarchitectureandroid13.data.repositories

import com.ren.cleanarchitectureandroid13.data.local.room.daos.CharacterDao
import com.ren.cleanarchitectureandroid13.data.remote.api.CharacterApiService
import com.ren.cleanarchitectureandroid13.data.remote.dtos.character.CharacterDto
import com.ren.cleanarchitectureandroid13.domain.either.Either
import com.ren.cleanarchitectureandroid13.domain.models.Character
import com.ren.cleanarchitectureandroid13.domain.repositories.CharacterRepository
import com.ren.cleanarchitectureandroid13.utils.mapper.CharacterEntityMapper
import com.ren.cleanarchitectureandroid13.utils.mapper.CharacterMapperDomain
import com.ren.cleanarchitectureandroid13.utils.mapper.Mapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterApiService: CharacterApiService,
    private val characterMapper: Mapper<CharacterDto, Character>,
    private val characterDao: CharacterDao
) : CharacterRepository {

    override fun fetchCharacters() = flow<Either<String, List<Character>>> {
        emit(Either.Right(characterApiService.fetchCharacters().results.map {
            characterMapper.toModel(it)
        }))
    }.flowOn(Dispatchers.IO).catch {
        emit(Either.Left(it.localizedMessage ?: "Error occurred!"))
    }

    override suspend fun insertCharacters(characters: List<Character>) {
        withContext(Dispatchers.IO) {
            characterDao.insertCharacters(characters.map {
                CharacterEntityMapper.fromModel(it)
            })
        }
    }

    override fun fetchLocalCharacters() = flow<Either<String, List<Character>>> {
        emit(Either.Right(characterDao.fetchLocalCharacters().map {
            CharacterEntityMapper.toModel(it)
        }))
    }.flowOn(Dispatchers.IO).catch {
        emit(Either.Left(it.localizedMessage ?: "Error occurred!"))
    }

    override fun fetchLocalCharactersFlow() = characterDao.fetchLocalCharactersFlow().map {
        it.map { entity ->
            CharacterEntityMapper.toModel(entity)
        }
    }
}