package com.ren.cleanarchitectureandroid13.utils.mapper

import com.ren.cleanarchitectureandroid13.data.local.room.entities.CharacterEntity
import com.ren.cleanarchitectureandroid13.domain.models.Character

object CharacterEntityMapper : Mapper<CharacterEntity, Character> {

    override fun toModel(value: CharacterEntity) = Character(
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

    override fun fromModel(value: Character) = CharacterEntity(
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