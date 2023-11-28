package com.albo.albotechnicaltest.framework.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.albo.albotechnicaltest.ui.theme.AlboTechnicalTestTheme

/**
 * Ejemplo de UI:
 * ● Demuestra tus habilidades de UI desarrollando el siguiente componente. Es una
 * barra de progreso que puede estar vacía, en cualquier punto intermedio y totalmente
 * llena.
 * */
@Composable
fun CustomProgressIndicatorExample(tarjetazos: Int) {
    val percentage = if (tarjetazos <= 25) {
        tarjetazos * 100 / 25
    } else {
        100
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(color = Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .clip(shape = RoundedCornerShape(5.dp))
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 5.dp, top = 10.dp, end = 5.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val colorStops = arrayOf(
                    0.2f to Color.LightGray,
                    0.7f to Color.Blue,
                )
                //val brush = Brush.horizontalGradient(colorStops = colorStops)
                val brush = Brush.linearGradient(
                    colors = listOf(Color.LightGray, Color.Blue)
                )
                Row(
                    modifier = Modifier
                        .height(15.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(brush)
                ) {
                    repeat(5) {
                        val isFragmentBarActive = when {
                            percentage in 1..20 && it == 0 -> true
                            percentage in 21..40 && (it in 0..1) -> true
                            percentage in 41..60 && (it in 0..2) -> true
                            percentage in 61..80 && (it in 0..3) -> true
                            percentage in 81..100 && (it in 0..4) -> true
                            else -> false
                        }
                        Box(
                            modifier = Modifier
                                .height(15.dp)
                                .weight(1f)
                                .clip(
                                    shape = when (it) {
                                        0 -> RoundedCornerShape(
                                            topStart = 10.dp,
                                            bottomStart = 10.dp
                                        )

                                        4 -> RoundedCornerShape(
                                            topEnd = 10.dp,
                                            bottomEnd = 10.dp
                                        )

                                        else -> RoundedCornerShape(0.dp)
                                    }
                                )
                                .background(
                                    if (isFragmentBarActive) {
                                        Color.Transparent
                                    } else Color.LightGray
                                )
                        ) {

                        }
                        if (it < 4) {
                            Spacer(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(2.dp)
                                    .background(Color.White)
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row {
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 5.dp)
                        .wrapContentWidth(Alignment.Start), color = Color.Gray, text = "0"
                )
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 5.dp)
                        .wrapContentWidth(Alignment.End),
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Black)) {
                            append(tarjetazos.toString())
                        }
                        withStyle(style = SpanStyle(color = Color.Gray)) {
                            append("/tarjetazos")
                        }
                    }
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CustomProgressIndicatorExamplePreview() {
    /**Ejemplo de la barra dinámica según el valor que se le proporcione*/
    AlboTechnicalTestTheme {
        Column {
            CustomProgressIndicatorExample(0)
            CustomProgressIndicatorExample(2)
            CustomProgressIndicatorExample(7)
            CustomProgressIndicatorExample(11)
            CustomProgressIndicatorExample(16)
            CustomProgressIndicatorExample(21)
        }
    }
}