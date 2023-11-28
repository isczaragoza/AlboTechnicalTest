package com.albo.albotechnicaltest.casoDeEstudio.framework.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.albo.albotechnicaltest.casoDeEstudio.domain.models.Task
import com.albo.albotechnicaltest.casoDeEstudio.framework.ui.viewModels.TaskMainScreenViewModel
import com.albo.albotechnicaltest.ui.theme.AlboTechnicalTestTheme
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksMainScreen(viewModel: TaskMainScreenViewModel = koinViewModel()) {
    val state by viewModel.state.observeAsState()
    val nonNullState = state!!
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumn {
                itemsIndexed(nonNullState.taskList) { index, item ->
                    /**/
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun TasksMainScreenPrev() {
    AlboTechnicalTestTheme {
        TasksMainScreen()
    }
}