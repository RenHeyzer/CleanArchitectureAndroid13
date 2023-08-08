package com.ren.cleanarchitectureandroid13.data.local.room.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ren.cleanarchitectureandroid13.data.local.room.entities.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character_entity")
    suspend fun fetchLocalCharacters(): List<CharacterEntity>

    @Query("SELECT * FROM character_entity")
    fun fetchLocalCharactersFlow(): Flow<List<CharacterEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(characterEntity: CharacterEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characterEntity: List<CharacterEntity>)

    @Update
    suspend fun updateCharacter(characterEntity: CharacterEntity)

    @Delete
    suspend fun deleteCharacter(characterEntity: CharacterEntity)

    @Query("DELETE FROM character_entity")
    suspend fun clear()
}