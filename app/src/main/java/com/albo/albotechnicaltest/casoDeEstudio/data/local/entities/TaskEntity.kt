package com.albo.albotechnicaltest.casoDeEstudio.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**Uso de Room*/
@Entity
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val detail: String,
    val status: Boolean
)
