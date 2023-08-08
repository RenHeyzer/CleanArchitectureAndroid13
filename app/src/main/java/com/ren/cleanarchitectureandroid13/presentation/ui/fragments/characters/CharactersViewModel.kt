package com.ren.cleanarchitectureandroid13.presentation.ui.fragments.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ren.cleanarchitectureandroid13.domain.either.Either
import com.ren.cleanarchitectureandroid13.domain.usecases.FetchCharactersUseCase
import com.ren.cleanarchitectureandroid13.domain.usecases.FetchLocalCharactersFlowUseCase
import com.ren.cleanarchitectureandroid13.domain.usecases.FetchLocalCharactersUseCase
import com.ren.cleanarchitectureandroid13.domain.usecases.InsertCharactersUseCase
import com.ren.cleanarchitectureandroid13.presentation.models.CharacterUI
import com.ren.cleanarchitectureandroid13.presentation.state.UIState
import com.ren.cleanarchitectureandroid13.utils.mapper.CharacterMapperUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val fetchCharactersUseCase: FetchCharactersUseCase,
    private val fetchLocalCharactersUseCase: FetchLocalCharactersUseCase,
    private val fetchLocalCharactersFlowUseCase: FetchLocalCharactersFlowUseCase,
    private val insertCharactersUseCase: InsertCharactersUseCase,
) : ViewModel() {

    private val _charactersState = MutableStateFlow<UIState<List<CharacterUI>>>(UIState.Loading())
    val charactersState = _charactersState.asStateFlow()

    private val _localState = MutableStateFlow<UIState<List<CharacterUI>>>(UIState.Loading())
    val localState = _localState.asStateFlow()

    init {
        fetchCharacters()
        fetchLocalCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            fetchCharactersUseCase().collect {
                when (it) {
                    is Either.Left -> {
                        it.message?.let { error ->
                            _charactersState.value = UIState.Error(error)
                        }
                    }

                    is Either.Right -> {
                        it.data?.let { characters ->
                            insertCharactersUseCase(characters)
                            _charactersState.value = UIState.Success(characters.map { character ->
                                CharacterMapperUI.toModel(character)
                            })
                        }
                    }
                }
            }
        }
    }

    private fun fetchLocalCharacters() {
        viewModelScope.launch {
            fetchLocalCharactersUseCase().collect {
                when (it) {
                    is Either.Left -> {
                        it.message?.let { error ->
                            _localState.value = UIState.Error(error)
                        }
                    }

                    is Either.Right -> {
                        it.data?.let { characters ->
                            _localState.value = UIState.Success(characters.map { character ->
                                CharacterMapperUI.toModel(character)
                            })
                        }
                    }
                }
            }
        }
    }

    fun fetchLocalCharactersFlow() {
        viewModelScope.launch {
            fetchLocalCharactersFlowUseCase().collect {
                _localState.value = UIState.Success(it.map { character ->
                    CharacterMapperUI.toModel(character)
                })
            }
        }
    }
}