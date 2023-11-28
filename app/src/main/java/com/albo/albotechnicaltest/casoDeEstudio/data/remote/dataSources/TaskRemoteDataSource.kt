package com.albo.albotechnicaltest.casoDeEstudio.data.remote.dataSources

import com.albo.albotechnicaltest.casoDeEstudio.data.remote.api.TaskApiService
import com.albo.albotechnicaltest.casoDeEstudio.data.remote.dtos.TaskBody
import com.albo.albotechnicaltest.casoDeEstudio.data.remote.dtos.TaskResponse

class TaskRemoteDataSource(private val taskApiService: TaskApiService) {

    suspend fun insertTask(taskBody: TaskBody) {
        taskApiService.insertTask(taskBody)
    }
    suspend fun requestTaskList(): List<TaskResponse> {
        return taskApiService.requestTaskList()
    }
}