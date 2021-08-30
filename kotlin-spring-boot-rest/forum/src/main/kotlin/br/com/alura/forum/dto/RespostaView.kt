package br.com.alura.forum.dto

import java.time.LocalDateTime

data class RespostaView(
    val id: Long?,
    val mensagem: String,
    val nomeAutor: String,
    val solucao: Boolean?,
    val dataCriacao: LocalDateTime
)

