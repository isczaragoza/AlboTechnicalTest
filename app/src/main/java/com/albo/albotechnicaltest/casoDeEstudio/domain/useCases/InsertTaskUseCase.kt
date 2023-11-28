package com.albo.albotechnicaltest.casoDeEstudio.domain.useCases

import com.albo.albotechnicaltest.casoDeEstudio.domain.interfacesRepositories.ITaskRepository
import com.albo.albotechnicaltest.casoDeEstudio.domain.models.Task

class InsertTaskUseCase(private val iTaskRepository: ITaskRepository) {
    suspend operator fun invoke(task: Task) {
        iTaskRepository.insertTask(task)
    }
}