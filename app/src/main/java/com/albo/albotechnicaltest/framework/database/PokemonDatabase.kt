package com.albo.albotechnicaltest.framework.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.albo.albotechnicaltest.data.local.daos.PokemonDao
import com.albo.albotechnicaltest.data.local.entities.PokemonEntity
import com.albo.albotechnicaltest.data.local.entities.PokemonResultMetaEntity

@Database(
    entities = [PokemonResultMetaEntity::class, PokemonEntity::class],
    version = 1,
    exportSchema = false
)
abstract class PokemonDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "PokemonDatabase"
    }
    abstract fun pokemonDao() : PokemonDao
}