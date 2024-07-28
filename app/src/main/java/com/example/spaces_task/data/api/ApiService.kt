package com.example.spaces_task.data.api

import com.example.spaces_task.data.model.UniversityResponseItem
import retrofit2.http.GET

interface ApiService {

    @GET("search?country=United%20Arab%20Emirates")
    suspend fun getUniversity(): List<UniversityResponseItem>

}