package com.example.spaces_task.view.university

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spaces_task.data.model.UniversityResponseItem
import com.example.spaces_task.domain.ResultWrapper
import com.example.spaces_task.domain.usecase.GetUniversityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UniversityViewModel @Inject constructor(private val getUniversityUseCase: GetUniversityUseCase) :
    ViewModel() {

    val universityLivedata = MutableLiveData<List<UniversityResponseItem>>()
    val errorLiveData = MutableLiveData<Exception>()

    fun getUniversity() {
        viewModelScope.launch {
            getUniversityUseCase.getUniversity().collect {
                when (it) {
                    is ResultWrapper.Success -> {
                        universityLivedata.value = it.data
                    }

                    is ResultWrapper.Error -> {
                        errorLiveData.value = it.exception
                    }
                }
            }
        }
    }
}