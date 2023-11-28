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

class MainScreenViewModel(private val fetchPokemonListUseCase: FetchPokemonListUseCase) :
    ViewModel() {

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
                val pokemonList = fetchPokemonListUseCase()
                _state.value = state.value?.copy(isLoading = false, pokemonList = pokemonList)
            } catch (e: Exception) {
                _state.value = state.value?.copy(isLoading = false)
            }
        }
    }

}
