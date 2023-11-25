package com.albo.albotechnicaltest.domain.di

import com.albo.albotechnicaltest.domain.useCases.FetchPokemonListUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    //Use Cases
    factoryOf(::FetchPokemonListUseCase)
}