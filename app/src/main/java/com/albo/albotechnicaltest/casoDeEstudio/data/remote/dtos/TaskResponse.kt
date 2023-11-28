package com.albo.albotechnicaltest.casoDeEstudio.data.remote.dtos

import com.google.gson.annotations.SerializedName

/**Uso de Retrofit*/
data class TaskResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("detail") val detail: String,
    @SerializedName("status") val status: Boolean,
    @SerializedName("data_server") val dataServer: String
)
