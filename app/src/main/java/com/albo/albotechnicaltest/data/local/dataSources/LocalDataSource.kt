package com.albo.albotechnicaltest.data.local.dataSources

import com.albo.albotechnicaltest.data.local.daos.PokemonDao
import com.albo.albotechnicaltest.data.local.entities.PokemonEntity
import com.albo.albotechnicaltest.data.local.entities.PokemonResultMetaEntity

class LocalDataSource(private val pokemonDao: PokemonDao) {
    suspend fun insertPokemonResultMeta(pokemonResultMetaEntity: PokemonResultMetaEntity) {
        pokemonDao.insertPokemonPokemonResultMeta(pokemonResultMetaEntity)
    }

    suspend fun insertPokemonList(listPokemonResult: List<PokemonEntity>) {
        pokemonDao.insertPokemonList(listPokemonResult)
    }

    suspend fun getPokemonList(): List<PokemonEntity> {
        return pokemonDao.getPokemonList()
    }
}