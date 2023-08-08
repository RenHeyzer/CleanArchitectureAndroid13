package com.ren.cleanarchitectureandroid13.utils.mapper

import com.ren.cleanarchitectureandroid13.domain.models.Character
import com.ren.cleanarchitectureandroid13.presentation.models.CharacterUI

object CharacterMapperUI :
    Mapper<Character, CharacterUI> {
    override fun toModel(value: Character) = CharacterUI(
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