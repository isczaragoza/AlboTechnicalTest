package com.albo.albotechnicaltest.casoDeEstudio.framework.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albo.albotechnicaltest.casoDeEstudio.domain.useCases.FetchTasksUseCase
import com.albo.albotechnicaltest.casoDeEstudio.framework.ui.states.TaskMainScreenState
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**Uso del ViewModel*/
class TaskMainScreenViewModel(private val fetchTasksUseCase: FetchTasksUseCase) : ViewModel() {

    /**Uso de Live Data*/
    private val _state: MutableLiveData<TaskMainScreenState> = MutableLiveData<TaskMainScreenState>(
        TaskMainScreenState(isLoading = false)
    )
    /**Uso de Live Data*/
    val state: LiveData<TaskMainScreenState> = _state
    private var fetchTaskListJob: Job? = null

    fun fetchTaskList() {
        fetchTaskListJob = viewModelScope.launch {
            try {
                val taskList = fetchTasksUseCase()
                _state.value = state.value?.copy(isLoading = false, taskList = taskList)
            } catch (e: Exception) {
                _state.value = state.value?.copy(isLoading = false)
            }
        }
    }
}
