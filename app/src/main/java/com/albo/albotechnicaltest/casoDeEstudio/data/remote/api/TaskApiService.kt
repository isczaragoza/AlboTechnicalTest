package com.albo.albotechnicaltest.casoDeEstudio.data.remote.api

import com.albo.albotechnicaltest.casoDeEstudio.data.remote.dtos.TaskBody
import com.albo.albotechnicaltest.casoDeEstudio.data.remote.dtos.TaskResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**Uso de Retrofit*/
interface TaskApiService {

    @POST("url")
    suspend fun insertTask(@Body taskBody: TaskBody)
    @GET("url")
    suspend fun requestTaskList(): List<TaskResponse>
}