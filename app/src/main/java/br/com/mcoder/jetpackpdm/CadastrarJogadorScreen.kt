package br.com.mcoder.jetpackpdm

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.mcoder.jetpackpdm.data.Repositorio
import br.com.mcoder.jetpackpdm.data.Jogador

@Composable
fun CadastrarJogadorScreen(navController: NavHostController) {
    var nome by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }
    var posicao by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Nome", fontSize = 18.sp)
        BasicTextField(
            value = nome,
            onValueChange = { nome = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .border(1.dp, Color.Black)
                .padding(8.dp)
        )

        Text("Idade", fontSize = 18.sp)
        BasicTextField(
            value = idade,
            onValueChange = { idade = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .border(1.dp, Color.Black)
                .padding(8.dp)
        )

        Text("Posição", fontSize = 18.sp)
        BasicTextField(
            value = posicao,
            onValueChange = { posicao = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .border(1.dp, Color.Black)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Armazenar os dados do jogador no repositório
                Repositorio.jogadores.add(Jogador(nome, idade, posicao))
                navController.popBackStack() // Volta à tela anterior após salvar
            },
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
        ) {
            Text("Salvar", fontSize = 18.sp)
        }
    }
}