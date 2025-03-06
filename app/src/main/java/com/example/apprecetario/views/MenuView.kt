package com.example.apprecetario.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.apprecetario.R
import com.example.apprecetario.components.TitleBar
import com.example.apprecetario.components.RecipeCard

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuView(onRecipeSelected: (Recipe) -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar("Recetario") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF6200EE),
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->  // Captura el paddingValues del Scaffold
        ContentView(onRecipeSelected, paddingValues)  // Pasa el paddingValues a ContentView
    }
}

@Composable
private fun ContentView(onRecipeSelected: (Recipe) -> Unit, paddingValues: PaddingValues) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),  // Aplica el padding aquí
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            RecipeCard(
                name = "Galletitas en forma de corazón",
                imageRes = R.drawable.galletitascorazon,
                description = "¡Estas pepas en forma de corazón son una bonita manera de celebrar el amor en San Valentín! Dulces, suaves y con un toque de mermelada …",
                onViewRecipe = {
                    onRecipeSelected(
                        Recipe(
                            name = "Galletitas en forma de corazón",
                            imageRes = R.drawable.galletitascorazon,
                            introduction = "¡Estas pepas en forma de corazón son una bonita manera de celebrar el amor en San Valentín! Dulces, suaves y con un toque de mermelada que simboliza un corazón, son ideales para compartir con tu persona especial o regalar como un detalle hecho con mucho amor.",
                            ingredients = listOf(
                                "170 gramos manteca",
                                "150 gramos de azúcar mascabo",
                                "75 gramos de azúcar",
                                "1 huevo",
                                "1 cda de esencia de vainilla",
                                "280 gramos harina",
                                "1 cda bicarbonato de sodio",
                                "½ cda polvo de hornear",
                                "½ cucharadita sal",
                                "160 gramos chips de chocolate"
                            ),
                            preparation = listOf(
                                "Lo primero que vamos a hacer es precalentar el horno a 180 ºC.",
                                "En un bowl batimos la manteca junto con los azúcares.",
                                "Agregar el huevo y la vainilla y batimos hasta que este bien mezclado.",
                                "Agregar la harina tamizada, el bicarbonato, polvo de hornear y la sal. Batir.",
                                "Agregar el chocolate y con ayuda de una cuchara revolver.",
                                "Formar una bolita grande de unos 80 gramos y las aplastamos en una bandeja con papel manteca. Se le pueden poner más chispas por arriba si se desea.",
                                "Hornear de 10 a 12 minutos hasta que a que se vean doradas, y no tan cocidas por dentro.",
                                "Sacar y dejar reposar un rato. Opcional: Las podes decorar a tu gusto y ¡A disfrutarlas!"
                            )
                        )
                    )
                }
            )
        }

        item {
            RecipeCard(
                name = "Jesuitas de Jamón y Queso",
                imageRes = R.drawable.jesuitasjamonqueso,
                description = "Te dejamos esta receta de jesuitas de jamón y queso, son una delicia clásica que combina una base crocante con un relleno muy sabroso. Éstas …",
                onViewRecipe = {
                    onRecipeSelected(
                        Recipe(
                            name = "Jesuitas de Jamón y Queso",
                            imageRes = R.drawable.jesuitasjamonqueso,
                            introduction = "Te dejamos esta receta de jesuitas de jamón y queso, son una delicia clásica que combina una base crocante con un relleno muy sabroso. Éstas son perfectas para acompañar cualquier merienda o como un snack salado para acompañar el mate o café, su masa ligera y hojaldrosa, junto con el toque dulce de la cubierta, hacen de estas galletas una opción irresistible. Además, su preparación es sencilla, lo que te permitirá disfrutarlas en poco tiempo.",
                            ingredients = listOf(
                                "100 gramos de manteca",
                                "2 tazas de harina",
                                "½ cta. de sal",
                                "2 ctas. de polvo de hornear",
                                "½ taza de fécula de maíz",
                                "1 huevo",
                                "½ taza de leche aprox.",
                                "200 gramos de azúcar impalpable",
                                "250 gramos de queso de sándwich",
                                "250 gramos de jamón"
                            ),
                            preparation = listOf(
                                "En un bowl, mezcla la harina, la sal, el polvo de hornear y la fécula de maíz. Agrega la manteca y con un tenedor la deshacemos hasta que la mezcla tenga una textura granulada.",
                                "Añade la yema de huevo y la leche poco a poco, amasando suavemente hasta formar una masa homogénea. No trabajes demasiado la masa para mantenerla ligera.",
                                "Espolvorea la mesa con fécula de maíz y estira la masa en un rectángulo fino, como si fuera hojaldre. Enróllala y vuelve a estirar. Deja descansar la masa unos 10 minutos.",
                                "Bate la clara del huevo con el azúcar impalpable hasta que estén bien mezclados, pero sin montar completamente.",
                                "Enmanteca una asadera y divide la masa en dos partes. Coloca una parte sobre la bandeja, cúbrela con la mezcla de claras y azúcar, y hornea a 180 ºC por unos 10 minutos o hasta que la cubierta esté dorada y crocante.",
                                "Una vez que la masa esté fría, unta una fina capa de manteca en la otra mitad de la masa y coloca el jamón y el queso. Tapa con la parte horneada y crocante."
                            )
                        )
                    )
                }
            )
        }

        item {
            RecipeCard(
                name = "Pionono de Frutillas y Chantilly",
                imageRes = R.drawable.piononofrutillas,
                description = "Este pionono es suave, esponjoso y fácil de hacer. Perfecto para rellenarlo con frutillas frescas y chantilly, ideal para una ocasión especial o simplemente para …",
                onViewRecipe = {
                    onRecipeSelected(
                        Recipe(
                            name = "Pionono de Frutillas y Chantilly",
                            imageRes = R.drawable.piononofrutillas,
                            introduction = "Este pionono es suave, esponjoso y fácil de hacer. Perfecto para rellenarlo con frutillas frescas y chantilly, ideal para una ocasión especial o simplemente para disfrutar en familia.",
                            ingredients = listOf(
                                "4 huevos",
                                "250 gramos de azúcar",
                                "250 gramos de harina",
                                "1 cda de esencia de vainilla",
                                "1 cda de polvo para hornear"
                            ),
                            preparation = listOf(
                                "Precalentar el horno a 180 ºC. Forrar una bandeja grande con papel manteca y enmantecar ligeramente.",
                                "Batir los huevos a velocidad alta hasta que espumen, luego agregar el azúcar en forma de lluvia. Continuar batiendo hasta que la mezcla duplique su volumen y esté bien esponjosa.",
                                "Añadir la esencia de vainilla y tamizar la harina junto con el polvo de hornear. Incorporar de a poco a la mezcla anterior, mezclando con movimientos envolventes para no perder aire.",
                                "Verter la preparación sobre la bandeja forrada y extenderla de manera uniforme con una espátula, procurando que quede bien nivelada.",
                                "Hornear durante 10-15 minutos o hasta que los bordes comiencen a desprenderse del papel y el pionono esté ligeramente dorado.",
                                "Retirar del horno y dejar reposar unos minutos. Desmoldar con cuidado y retirar el papel manteca. Dejar enfriar sobre un paño limpio.",
                                "Relleno: Una vez frío, rellenar con chantilly y frutillas frescas cortadas en rodajas.",
                                "Enrollar el pionono con suavidad, ayudándote de un paño, y decorar a gusto. Puedes espolvorear azúcar impalpable o añadir más frutillas por encima."
                            )
                        )
                    )
                }
            )
        }

        item {
            RecipeCard(
                name = "Crumbl Cookies",
                imageRes = R.drawable.crumblcookies,
                description = "Prepara las galletitas virales del momento con esta versión fácil y rápida. Estas galletas, crocantes por fuera y suaves por dentro, son irresistibles y ahora …",
                onViewRecipe = {
                    onRecipeSelected(
                        Recipe(
                            name = "Crumbl Cookies",
                            imageRes = R.drawable.crumblcookies,
                            introduction = "Prepara las galletitas virales del momento con esta versión fácil y rápida. Estas galletas, crocantes por fuera y suaves por dentro, son irresistibles y ahora puedes hacerlas en casa sin complicaciones. ¡Perfectas para cualquier ocasión!",
                            ingredients = listOf(
                                "170 gramos manteca",
                                "150 gramos de azúcar mascabo",
                                "75 gramos de azúcar",
                                "1 huevo",
                                "1 cda de esencia de vainilla",
                                "280 gramos harina",
                                "1 cda bicarbonato de sodio",
                                "½ cda polvo de hornear",
                                "½ cucharadita sal",
                                "160 gramos chips de chocolate"
                            ),
                            preparation = listOf(
                                "Lo primero que vamos a hacer es precalentar el horno a 180 ºC.",
                                "En un bowl batimos la manteca junto con los azúcares.",
                                "Agregar el huevo y la vainilla y batimos hasta que este bien mezclado.",
                                "Agregar la harina tamizada, el bicarbonato, polvo de hornear y la sal. Batir.",
                                "Agregar el chocolate y con ayuda de una cuchara revolver.",
                                "Formar una bolita grande de unos 80 gramos y las aplastamos en una bandeja con papel manteca. Se le pueden poner más chispas por arriba si se desea.",
                                "Hornear de 10 a 12 minutos hasta que a que se vean doradas, y no tan cocidas por dentro.",
                                "Sacar y dejar reposar un rato. Opcional: Las podes decorar a tu gusto y ¡A disfrutarlas!"
                            )
                        )
                    )
                }
            )
        }
    }
}