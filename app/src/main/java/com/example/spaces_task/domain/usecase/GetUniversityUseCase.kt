package com.example.spaces_task.domain.usecase

import com.example.spaces_task.data.repository.UniversityRepository
import com.example.spaces_task.domain.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetUniversityUseCase @Inject constructor(private val universityRepository: UniversityRepository) {

    suspend fun getUniversity() = flow {
        try {
            val result = universityRepository.getUniversity()
            emit(ResultWrapper.Success(result))
        } catch (e: Exception) {
            emit(ResultWrapper.Error(e))
        }
    }.flowOn(Dispatchers.IO)
}

