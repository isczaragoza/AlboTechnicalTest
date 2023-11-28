package com.albo.albotechnicaltest.casoDeEstudio.domain.interfacesRepositories

import com.albo.albotechnicaltest.casoDeEstudio.domain.models.Task

interface ITaskRepository {
    suspend fun insertTask(task: Task)
    suspend fun getTaskList(): List<Task>
    suspend fun getTaskListRemote(): List<Task>
}
