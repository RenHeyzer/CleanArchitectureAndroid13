package com.ren.cleanarchitectureandroid13.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ren.cleanarchitectureandroid13.data.local.room.daos.CharacterDao
import com.ren.cleanarchitectureandroid13.data.local.room.entities.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 2, exportSchema = false)
abstract class RickAndMortyDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao
}