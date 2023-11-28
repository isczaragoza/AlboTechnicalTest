package com.albo.albotechnicaltest.casoDeEstudio.data.di

import com.albo.albotechnicaltest.casoDeEstudio.data.local.dataSources.TaskLocalDataSource
import com.albo.albotechnicaltest.casoDeEstudio.data.remote.api.TaskApiService
import com.albo.albotechnicaltest.casoDeEstudio.data.remote.dataSources.TaskRemoteDataSource
import com.albo.albotechnicaltest.casoDeEstudio.data.repositories.TaskRepository
import com.albo.albotechnicaltest.casoDeEstudio.domain.interfacesRepositories.ITaskRepository
import com.albo.albotechnicaltest.data.remote.api.PokemonApiService
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

/**Uso de Koin*/
val dataMod = module {
    //Api Services
    single { get<Retrofit>().create<TaskApiService>() } /**Ejemplo Retrofit Rest Koin*/
    //Daos
    /**single { get<TaskDataBase>().taskDao() } Ejemplo Dao Task Koin*/
    //Data Sources
    factoryOf(::TaskRemoteDataSource)
    factoryOf(::TaskLocalDataSource)
    //Repositories
    factoryOf(::TaskRepository) { bind<ITaskRepository>() }
}