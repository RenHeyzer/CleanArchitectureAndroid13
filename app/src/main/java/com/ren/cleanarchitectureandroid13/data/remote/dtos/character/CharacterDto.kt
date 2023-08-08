package com.ren.cleanarchitectureandroid13.data.remote.dtos.character

import com.google.gson.annotations.SerializedName
import com.ren.cleanarchitectureandroid13.domain.models.Character
import com.ren.cleanarchitectureandroid13.utils.mapper.MapperData

data class CharacterDto(
    @SerializedName("image")
    val image: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("created")
    val created: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("status")
    val status: String
) : MapperData<Character> {
    override fun toModel() = Character(
        image, gender, species, created, name, id, type, url, status
    )
}