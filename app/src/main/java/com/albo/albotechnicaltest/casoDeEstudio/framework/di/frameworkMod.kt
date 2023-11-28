package com.albo.albotechnicaltest.casoDeEstudio.framework.di

import com.albo.albotechnicaltest.casoDeEstudio.framework.ui.viewModels.TaskMainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val frameworkMod = module {
    //View Models
    viewModelOf(::TaskMainScreenViewModel) /**Creación del ViewModel, Koin gestiona las dependecias del ViewModel*/
}