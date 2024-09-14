package br.com.mcoder.jetpackpdm.data

// Modelo de dados para Jogador e Time
data class Jogador(val nome: String, val idade: String, val posicao: String)
data class Time(val nome: String, val liga: String, val anoFundacao: String)

// Repositório que armazena jogadores e times
object Repositorio {
    val jogadores = mutableListOf<Jogador>()
    val times = mutableListOf<Time>()
}