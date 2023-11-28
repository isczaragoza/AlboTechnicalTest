package com.albo.albotechnicaltest.framework.ui.states

import com.albo.albotechnicaltest.domain.models.Pokemon

data class MainScreenState(
    val isLoading: Boolean = false,
    val pokemonListFetch: Boolean = false,
    val pokemonList: List<Pokemon> = emptyList()
)
