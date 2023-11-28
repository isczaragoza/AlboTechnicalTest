package com.albo.albotechnicaltest.casoDeEstudio.framework.ui.states

import com.albo.albotechnicaltest.casoDeEstudio.domain.models.Task

data class TaskMainScreenState(
    val isLoading: Boolean = false,
    val taskList: List<Task> = emptyList()
)
