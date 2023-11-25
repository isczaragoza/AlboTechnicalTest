package com.albo.albotechnicaltest.data.remote.dataSources

import com.albo.albotechnicaltest.data.remote.api.PokemonApiService
import com.albo.albotechnicaltest.data.remote.dtos.PokemonListResponse
import retrofit2.Response

class RemoteDataSource(private val pokemonApiService: PokemonApiService) {
    suspend fun requestPokemonList(): Response<PokemonListResponse> {
        return pokemonApiService.requestPokemonList()
    }
}