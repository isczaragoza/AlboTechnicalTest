package com.albo.albotechnicaltest.domain.useCases

import com.albo.albotechnicaltest.domain.interfacesRepositories.IPokemonRepository
import com.albo.albotechnicaltest.domain.models.Pokemon

class FetchPokemonListUseCase(private val iPokemonRepository: IPokemonRepository) {
    suspend operator fun invoke(): List<Pokemon> {
        return iPokemonRepository.requestPokemonList()
    }
}