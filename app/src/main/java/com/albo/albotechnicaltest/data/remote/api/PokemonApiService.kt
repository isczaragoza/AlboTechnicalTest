package com.albo.albotechnicaltest.data.remote.api

import com.albo.albotechnicaltest.data.remote.dtos.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApiService {
    @GET("pokemon/?limit=30")
    suspend fun requestPokemonList(): Response<PokemonListResponse>
}