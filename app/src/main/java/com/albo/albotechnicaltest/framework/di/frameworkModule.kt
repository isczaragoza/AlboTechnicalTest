package com.albo.albotechnicaltest.framework.di

import androidx.room.Room
import com.albo.albotechnicaltest.framework.database.PokemonDatabase
import com.albo.albotechnicaltest.framework.network.RetrofitProvider
import com.albo.albotechnicaltest.framework.ui.viewModels.MainScreenViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val frameworkModule = module {
    //Retrofit Provider
    single { RetrofitProvider().provideRetrofit() }
    //Database Provider
    single {
        Room.databaseBuilder(
            androidApplication(),
            PokemonDatabase::class.java,
            PokemonDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }
    //View Models
    viewModelOf(::MainScreenViewModel)
}