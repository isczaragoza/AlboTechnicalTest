package com.albo.albotechnicaltest.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonEntity(
    val id: Int,
    @PrimaryKey(autoGenerate = false)
    val name: String,
    val url: String
)
