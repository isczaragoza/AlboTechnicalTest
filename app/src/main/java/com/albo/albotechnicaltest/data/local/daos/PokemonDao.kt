package com.albo.albotechnicaltest.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.albo.albotechnicaltest.data.local.entities.PokemonEntity
import com.albo.albotechnicaltest.data.local.entities.PokemonResultMetaEntity

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonPokemonResultMeta(pokemonResultMetaEntity: PokemonResultMetaEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonList(listPokemonResult: List<PokemonEntity>)

    @Query("SELECT * FROM PokemonEntity LIMIT 100")
    suspend fun getPokemonList(): List<PokemonEntity>
}