package com.example.fetchcodingexercise.name

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchcodingexercise.api.NetworkResult
import com.example.fetchcodingexercise.repo.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class NameViewModel @Inject constructor(
    private val repo: Repo
) : ViewModel() {
    private val _data: MutableStateFlow<List<DataUIModel>?> = MutableStateFlow(null)
    val data: StateFlow<List<DataUIModel>?> = _data.asStateFlow()

    fun fetchData() {
        viewModelScope.launch {
            val response = repo.getData()
            val dataList = mutableListOf<DataUIModel>()
            if (response is NetworkResult.Success) {
                val dataFromRepo = response.data.orEmpty()
                Timber.d("HEYY: $dataFromRepo")
                dataFromRepo.forEach {
                    if (!it.name.isNullOrEmpty()) {
                        dataList.add(dataToDataUI(it))
                    }
                }
                dataList.sortWith(
                    compareBy({ it.listId }, { it.name })
                )
                _data.value = dataList
            }
        }
    }
}