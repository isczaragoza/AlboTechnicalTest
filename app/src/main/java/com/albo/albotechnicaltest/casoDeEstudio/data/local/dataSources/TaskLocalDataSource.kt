package com.albo.albotechnicaltest.casoDeEstudio.data.local.dataSources

import com.albo.albotechnicaltest.casoDeEstudio.data.local.daos.TaskDao
import com.albo.albotechnicaltest.casoDeEstudio.data.local.entities.TaskEntity

class TaskLocalDataSource(private val taskDao: TaskDao) {
    suspend fun insertTask(taskEntity: TaskEntity) {
        taskDao.insertTask(taskEntity)
    }

    suspend fun getTaskList() : List<TaskEntity> {
        return taskDao.getTaskList()
    }
}