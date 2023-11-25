package com.albo.albotechnicaltest.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)
