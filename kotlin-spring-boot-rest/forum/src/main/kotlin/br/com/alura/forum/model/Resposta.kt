package br.com.alura.forum.model

import java.time.LocalDateTime

data class Resposta(
    var id: Long? = null,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val autor: Usuario,
    val idTopico: Long,
    val solucao: Boolean? = false
)
