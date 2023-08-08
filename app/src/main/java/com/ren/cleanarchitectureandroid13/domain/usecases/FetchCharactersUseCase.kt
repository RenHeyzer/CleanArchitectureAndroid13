package com.ren.cleanarchitectureandroid13.domain.usecases

import com.ren.cleanarchitectureandroid13.domain.repositories.CharacterRepository
import javax.inject.Inject

class FetchCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {

    operator fun invoke() = repository.fetchCharacters()
}