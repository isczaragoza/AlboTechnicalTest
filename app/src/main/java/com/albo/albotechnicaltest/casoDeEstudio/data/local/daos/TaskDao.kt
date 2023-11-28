package com.albo.albotechnicaltest.casoDeEstudio.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.albo.albotechnicaltest.casoDeEstudio.data.local.entities.TaskEntity

/**Uso de Room*/
@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskEntity)

    @Query("SELECT * FROM TaskEntity")
    suspend fun getTaskList(): List<TaskEntity>
}