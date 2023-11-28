package com.albo.albotechnicaltest.data.remote.api

import com.albo.albotechnicaltest.data.remote.dtos.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Uso de Retrofit:
 * ● Muestre un ejemplo de cómo crear un servicio web con Retrofit para consumir una
 * API REST.
 * */
interface PokemonApiService {
    @GET("pokemon/?limit=150")
    suspend fun requestPokemonList(): Response<PokemonListResponse>
}