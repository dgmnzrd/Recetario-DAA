package com.example.apprecetario.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TitleBar(name: String) {
    Text(text = name, fontSize = 25.sp, color = Color.White)
}

@Composable
fun ActionButton(color: Color, onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        containerColor = color,
        contentColor = Color.White
    ) {
        Row {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Regresar") // Ícono de regreso
            Spacer(modifier = Modifier.width(8.dp)) // Espaciado entre el ícono y el texto
            Text(text = "Regresar", fontSize = 16.sp)
        }
    }
}