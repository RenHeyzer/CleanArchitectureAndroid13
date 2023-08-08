package com.ren.cleanarchitectureandroid13.utils.mapper

import com.ren.cleanarchitectureandroid13.data.remote.dtos.character.CharacterDto
import com.ren.cleanarchitectureandroid13.domain.models.Character

object CharacterMapperDomain : Mapper<CharacterDto, Character> {
    override fun toModel(value: CharacterDto) = Character(
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