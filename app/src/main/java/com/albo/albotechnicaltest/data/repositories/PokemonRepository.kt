package com.albo.albotechnicaltest.data.repositories

import com.albo.albotechnicaltest.data.remote.dataSources.RemoteDataSource
import com.albo.albotechnicaltest.data.remote.dtos.PokemonListResponse
import com.albo.albotechnicaltest.data.remote.dtos.toPokemonListDomain
import com.albo.albotechnicaltest.domain.interfacesRepositories.IPokemonRepository
import com.albo.albotechnicaltest.domain.models.Pokemon
import java.lang.Exception

class PokemonRepository(private val remoteDataSource: RemoteDataSource) : IPokemonRepository {
    override suspend fun requestPokemonList(): List<Pokemon> {
        val response = remoteDataSource.requestPokemonList()
        val body = response.body()
        if (body != null) {
            val listPokemon = body.results.mapIndexed { index, pokemonResponse ->
                Pokemon(index, pokemonResponse.name, pokemonResponse.url)
            }
            return listPokemon
        }
        if (response.errorBody() != null) {
            throw Exception("Error Api")
        }
        throw Exception("Unknown Error")
    }
}