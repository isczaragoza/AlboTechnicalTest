package com.albo.albotechnicaltest.data.repositories

import com.albo.albotechnicaltest.data.local.dataSources.LocalDataSource
import com.albo.albotechnicaltest.data.local.entities.PokemonEntity
import com.albo.albotechnicaltest.data.local.entities.PokemonResultMetaEntity
import com.albo.albotechnicaltest.data.remote.dataSources.RemoteDataSource
import com.albo.albotechnicaltest.data.remote.dtos.PokemonListResponse
import com.albo.albotechnicaltest.data.remote.dtos.PokemonResponse
import com.albo.albotechnicaltest.domain.interfacesRepositories.IPokemonRepository
import com.albo.albotechnicaltest.domain.models.Pokemon
import kotlin.Exception

class PokemonRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : IPokemonRepository {
    companion object {
        const val ERROR_API = "Error_Api"
        const val UNKNOWN_ERROR = "Unknown_Error"
        const val EMPTY_DATA = "Empty_Data"
    }

    override suspend fun requestPokemonList(): List<Pokemon> {
        try {
            val response = remoteDataSource.requestPokemonList()
            val body = response.body()
            if (body != null) {
                insertPokemonResultMeta(body)
                insertPokemonList(body.results)

                val listPokemon = body.results.mapIndexed { index, pokemonResponse ->
                    Pokemon(index, pokemonResponse.name, pokemonResponse.url)
                }
                return listPokemon
            }
            if (response.errorBody() != null) {
                throw Exception(ERROR_API)
            }
            throw Exception(UNKNOWN_ERROR)
        } catch (e: Exception) {
            if (getPokemonList().isEmpty()) {
                throw Exception(EMPTY_DATA)
            }
            return getPokemonList()
        }
    }

    private suspend fun insertPokemonResultMeta(pokemonListResponse: PokemonListResponse) {
        val pokemonResultMeta = PokemonResultMetaEntity(
            0,
            pokemonListResponse.count,
            pokemonListResponse.next,
            pokemonListResponse.previous ?: ""
        )
        localDataSource.insertPokemonResultMeta(pokemonResultMeta)
    }

    private suspend fun insertPokemonList(pokemonListParams: List<PokemonResponse>) {
        val pokemonList = pokemonListParams.mapIndexed { index, pokemonResponse ->
            PokemonEntity(index, pokemonResponse.name, pokemonResponse.url)
        }
        localDataSource.insertPokemonList(pokemonList)
    }

    private suspend fun getPokemonList(): List<Pokemon> {
        val pokemonListDomain =
            localDataSource.getPokemonList().mapIndexed { _, pokemonEntity ->
                Pokemon(pokemonEntity.id, pokemonEntity.name, pokemonEntity.url)
            }
        return pokemonListDomain
    }
}