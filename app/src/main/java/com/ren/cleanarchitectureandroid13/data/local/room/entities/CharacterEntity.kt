package com.ren.cleanarchitectureandroid13.data.local.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character_entity")
data class CharacterEntity(
    val image: String,
    val gender: String,
    val species: String,
    val created: String,
    val name: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val type: String,
    val url: String,
    val status: String
)