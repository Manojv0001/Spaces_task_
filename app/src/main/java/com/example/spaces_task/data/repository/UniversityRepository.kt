package com.example.spaces_task.data.repository

import com.example.spaces_task.data.model.UniversityResponseItem

interface UniversityRepository {

    suspend fun getUniversity(): List<UniversityResponseItem>

}