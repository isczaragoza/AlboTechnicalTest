package com.albo.albotechnicaltest.data.di

import com.albo.albotechnicaltest.data.local.daos.PokemonDao
import com.albo.albotechnicaltest.data.local.dataSources.LocalDataSource
import com.albo.albotechnicaltest.data.remote.api.PokemonApiService
import com.albo.albotechnicaltest.data.remote.dataSources.RemoteDataSource
import com.albo.albotechnicaltest.data.repositories.PokemonRepository
import com.albo.albotechnicaltest.domain.interfacesRepositories.IPokemonRepository
import com.albo.albotechnicaltest.framework.database.PokemonDatabase
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val dataModule = module {
    //Api Services
    single { get<Retrofit>().create<PokemonApiService>() }
    //Daos
    single { get<PokemonDatabase>().pokemonDao() }
    //Data Sources
    factoryOf(::RemoteDataSource)
    factoryOf(::LocalDataSource)
    //Repositories
    //factory { PokemonRepository(get()) as IPokemonRepository }
    factoryOf(::PokemonRepository) { bind<IPokemonRepository>() }
}