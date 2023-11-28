package com.albo.albotechnicaltest.casoDeEstudio.data.repositories

import com.albo.albotechnicaltest.casoDeEstudio.data.local.dataSources.TaskLocalDataSource
import com.albo.albotechnicaltest.casoDeEstudio.data.local.entities.TaskEntity
import com.albo.albotechnicaltest.casoDeEstudio.data.remote.dataSources.TaskRemoteDataSource
import com.albo.albotechnicaltest.casoDeEstudio.data.remote.dtos.TaskBody
import com.albo.albotechnicaltest.casoDeEstudio.domain.interfacesRepositories.ITaskRepository
import com.albo.albotechnicaltest.casoDeEstudio.domain.models.Task
import com.albo.albotechnicaltest.data.local.dataSources.LocalDataSource
import com.albo.albotechnicaltest.data.remote.dataSources.RemoteDataSource

class TaskRepository(
    private val taskLocalDataSource: TaskLocalDataSource,
    private val taskRemoteDataSource: TaskRemoteDataSource
) : ITaskRepository {
    override suspend fun insertTask(task: Task) {
        /*Local*/
        taskLocalDataSource.insertTask(TaskEntity(task.id, task.name, task.detail, task.status))
        /*Remote*/
        taskRemoteDataSource.insertTask(TaskBody(task.id, task.name, task.detail, task.status))
        /**La lógica de negocio se puede controlar y manejar de una mejor manera, pero este uso
         * es simplemente para mostrar el uso de ROOM y Retrofit*/
    }

    override suspend fun getTaskList(): List<Task> {
        return taskLocalDataSource.getTaskList().map { item ->
            Task(item.id, item.name, item.detail, item.status)
        }
    }

    override suspend fun getTaskListRemote(): List<Task> {
        return taskRemoteDataSource.requestTaskList().map { item ->
            Task(item.id, item.name, item.detail, item.status)
        }
    }


}