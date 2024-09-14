package br.com.mcoder.jetpackpdm

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.mcoder.jetpackpdm.data.Repositorio

@Composable
fun ListarScreen(navController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Campo de pesquisa
        Text("Pesquisar por nome:", fontSize = 18.sp, modifier = Modifier.padding(bottom = 8.dp))
        BasicTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Exibir lista de jogadores filtrados
        val jogadoresFiltrados = Repositorio.jogadores.filter {
            it.nome.contains(searchQuery, ignoreCase = true)
        }

        Text("Jogadores:", fontSize = 20.sp, modifier = Modifier.padding(bottom = 8.dp))
        jogadoresFiltrados.forEach { jogador ->
            Text("Nome: ${jogador.nome}, Idade: ${jogador.idade}, Posição: ${jogador.posicao}")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Exibir lista de times filtrados
        val timesFiltrados = Repositorio.times.filter {
            it.nome.contains(searchQuery, ignoreCase = true)
        }

        Text("Times:", fontSize = 20.sp, modifier = Modifier.padding(bottom = 8.dp))
        timesFiltrados.forEach { time ->
            Text("Nome: ${time.nome}, Liga: ${time.liga}, Ano Fundação: ${time.anoFundacao}")
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Botão de Voltar
        Button(
            onClick = {
                navController.popBackStack() // Volta para a tela anterior
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text("Voltar", fontSize = 18.sp)
        }
    }
}
