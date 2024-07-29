package com.example.spaces_task.data.repository

import com.example.spaces_task.data.api.ApiService
import javax.inject.Inject

class UniversityRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
): UniversityRepository {

    override suspend fun getUniversity() = apiService.getUniversity()
}

