package com.example.spaces_task.di.module

import com.example.spaces_task.data.repository.UniversityRepository
import com.example.spaces_task.data.repository.UniversityRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoriesModule {

    @Binds
    fun universityRepository(universityRepositoryImpl: UniversityRepositoryImpl): UniversityRepository
}