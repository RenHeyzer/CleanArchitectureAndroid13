package com.ren.cleanarchitectureandroid13.data.remote.api

import com.ren.cleanarchitectureandroid13.data.remote.dtos.character.ApiResponse
import com.ren.cleanarchitectureandroid13.data.remote.dtos.character.CharacterDto
import retrofit2.http.GET

interface CharacterApiService {

    @GET("character")
    suspend fun fetchCharacters(): ApiResponse<CharacterDto>
}