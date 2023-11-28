package com.albo.albotechnicaltest.framework.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albo.albotechnicaltest.domain.models.Pokemon
import com.albo.albotechnicaltest.domain.useCases.FetchPokemonListUseCase
import com.albo.albotechnicaltest.framework.ui.states.MainScreenState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * ViewModel y LiveData:
 * ● Proporcione un fragmento de código para un ViewModel que maneje una operación
 * de red asincrónica utilizando LiveData.
 * ● Explique cómo se gestionaría el ciclo de vida de este ViewModel en una actividad.
 * */
class MainScreenViewModel(
    /**Inyección de Dependencia:
    ● Escriba un ejemplo de cómo se usaría Koin para inyectar una dependencia en un
    ViewModel.*/
    private val fetchPokemonListUseCase: FetchPokemonListUseCase
    /**Dependencia inyectada con Koin*/
) : ViewModel() {
    /**
     * El alcance de los objetos ViewModel se determina según el Lifecycle que se pasa al
     * ViewModelProvider cuando se recibe el ViewModel.
     * El ViewModel permanece en la memoria hasta que el Lifecycle que determina su alcance
     * desaparece de forma permanente.
     * En el caso de una actividad, cuando termina; en el caso de un fragmento, cuando se desconecta.
     * */

    private val _state: MutableLiveData<MainScreenState> = MutableLiveData<MainScreenState>(
        MainScreenState(isLoading = false, pokemonListFetch = false)
    )
    val state: LiveData<MainScreenState> = _state
    private var fetchPokemonListJob: Job? = null

    suspend fun fetchPokemonList() {
        if (fetchPokemonListJob != null) return

        _state.value = _state.value?.copy(isLoading = true, pokemonListFetch = true)
        fetchPokemonListJob = viewModelScope.launch {
            try {
                /**
                 * Operación de Red Asincrona
                 * */
                val pokemonList = fetchPokemonListUseCase()
                _state.value = state.value?.copy(isLoading = false, pokemonList = pokemonList)
            } catch (e: Exception) {
                _state.value = state.value?.copy(isLoading = false)
            }
        }
    }

}
