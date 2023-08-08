package com.ren.cleanarchitectureandroid13.domain.usecases

import com.ren.cleanarchitectureandroid13.domain.models.Character
import com.ren.cleanarchitectureandroid13.domain.repositories.CharacterRepository
import javax.inject.Inject

class InsertCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {

    suspend operator fun invoke(characters: List<Character>) =
        repository.insertCharacters(characters)
}