package com.albo.albotechnicaltest.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class PokemonListResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String,
    @SerializedName("results") val results: List<PokemonResponse>
)
fun PokemonListResponse.toPokemonListDomain () {
    return
}