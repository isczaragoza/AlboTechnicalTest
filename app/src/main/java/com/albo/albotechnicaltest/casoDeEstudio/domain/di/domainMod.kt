package com.albo.albotechnicaltest.casoDeEstudio.domain.di

import com.albo.albotechnicaltest.casoDeEstudio.domain.useCases.FetchTasksUseCase
import com.albo.albotechnicaltest.casoDeEstudio.domain.useCases.InsertTaskUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainMod = module {
    //Use Cases para ViewModel
    factoryOf(::FetchTasksUseCase)
    factoryOf(::InsertTaskUseCase)
}