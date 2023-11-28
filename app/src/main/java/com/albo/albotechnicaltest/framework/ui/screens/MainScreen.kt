package com.albo.albotechnicaltest.framework.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albo.albotechnicaltest.domain.models.Pokemon
import com.albo.albotechnicaltest.framework.ui.viewModels.MainScreenViewModel
import com.albo.albotechnicaltest.ui.theme.AlboTechnicalTestTheme
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainScreenViewModel = koinViewModel()) {
    val state by viewModel.state.observeAsState()
    val nonNullState = state!!
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LaunchedEffect(key1 = Unit) {
                if (nonNullState.pokemonListFetch.not()) {
                    viewModel.fetchPokemonList()
                }
            }
            if (nonNullState.isLoading) {
                AnimatedVisibility(visible = true) {
                    CircularProgressIndicator(
                        modifier = Modifier.padding(16.dp)
                    )
                }
                return@Scaffold
            }
            if (nonNullState.isLoading.not() && nonNullState.pokemonList.isEmpty()) {
                Text(text = "No hay Datos")
                return@Scaffold
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
            ) {
                itemsIndexed(nonNullState.pokemonList) { index, pokemon ->
                    PokemonRow(pokemon = pokemon)
                }
            }

        }
    }

}

@Composable
private fun PokemonRow(pokemon: Pokemon) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 10.dp, bottom = 10.dp)
    ) {
        Card(modifier = Modifier.fillMaxSize(), border = BorderStroke(2.dp, Color.Gray)) {
            Row(
                modifier = Modifier.padding(
                    start = 10.dp,
                    top = 20.dp,
                    end = 10.dp,
                    bottom = 20.dp
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(end = 10.dp),
                    text = pokemon.id.toString(),
                    fontSize = 25.sp
                )
                Text(
                    modifier = Modifier.padding(end = 10.dp),
                    text = pokemon.name.replaceFirstChar {
                        it.uppercase()
                    },
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun MainScreenPreview() {
    AlboTechnicalTestTheme {
        MainScreen()
    }
}