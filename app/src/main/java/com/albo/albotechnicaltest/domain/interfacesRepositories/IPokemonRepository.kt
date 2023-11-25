package com.albo.albotechnicaltest.domain.interfacesRepositories

import com.albo.albotechnicaltest.domain.models.Pokemon

interface IPokemonRepository {
    suspend fun requestPokemonList(): List<Pokemon>
}