package com.albo.albotechnicaltest.framework.di

import com.albo.albotechnicaltest.framework.network.RetrofitProvider
import com.albo.albotechnicaltest.framework.ui.viewModels.MainScreenViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val frameworkModule = module {
    single { RetrofitProvider().provideRetrofit() }
    //View Models
    factoryOf(::MainScreenViewModel)
}