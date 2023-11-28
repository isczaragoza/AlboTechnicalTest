package com.albo.albotechnicaltest.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonResultMetaEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val count: Int,
    val next: String,
    val previous: String
)
