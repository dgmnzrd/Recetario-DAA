package com.example.apprecetario.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val primaryPurple = Color(0xFF6200EE)
private val deepPurple = Color(0xFF3700B3)
private val lightPurple = Color(0xFFBB86FC)
private val veryLightPurple = Color(0xFFF2E7FE)
private val purpleGray = Color(0xFF655E78)

@Composable
fun TitleView(name: String) {
    Text(
        text = name,
        fontSize = 25.sp,
        color = deepPurple,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun MainButton(name: String, backColor: Color, color: Color, onClick: ()->Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = color,
            containerColor = backColor
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp
        )
    ) {
        Text(
            text = name,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun RecipeCard(name: String, imageRes: Int, description: String, onViewRecipe: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen con forma circular
            Surface(
                modifier = Modifier
                    .size(110.dp)
                    .padding(4.dp),
                shape = RoundedCornerShape(12.dp),
                shadowElevation = 4.dp
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "Recipe Image",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            // Información y botón
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                // Título de la receta
                Text(
                    text = name,
                    fontSize = 20.sp,
                    color = deepPurple,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Descripción con fondo sutil
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = veryLightPurple,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = description,
                        fontSize = 14.sp,
                        color = purpleGray,
                        modifier = Modifier.padding(8.dp),
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Botón alineado al final
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    MainButton(
                        name = "Ver Receta",
                        backColor = primaryPurple,
                        color = Color.White,
                        onClick = onViewRecipe
                    )
                }
            }
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 12.dp)
    ) {
        Divider(
            color = lightPurple,
            modifier = Modifier
                .height(2.dp)
                .width(24.dp)
        )

        Text(
            text = title,
            color = deepPurple,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        Divider(
            color = lightPurple,
            modifier = Modifier
                .height(2.dp)
                .weight(1f)
        )
    }
}