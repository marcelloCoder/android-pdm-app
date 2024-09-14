package br.com.mcoder.jetpackpdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    // NavHost para gerenciar as rotas
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("cadastrarJogador") { CadastrarJogadorScreen(navController) }
        composable("cadastrarTime") { CadastrarTimeScreen(navController) }
        composable("listar") { ListarScreen(navController) } // Adicionando ListarScreen na navegação
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                navController.navigate("cadastrarJogador") // Navega para a tela de cadastro de jogador
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp, vertical = 8.dp) // Controla a largura e o espaçamento
        ) {
            Text("Cadastrar jogador", fontSize = 18.sp)
        }

        Button(
            onClick = {
                navController.navigate("cadastrarTime") // Navega para a tela de cadastro de time
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp, vertical = 8.dp)
        ) {
            Text("Cadastrar Time", fontSize = 18.sp)
        }

        Button(
            onClick = {
                navController.navigate("listar") // Navega para a tela de listar
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp, vertical = 8.dp)
        ) {
            Text("Listar", fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}