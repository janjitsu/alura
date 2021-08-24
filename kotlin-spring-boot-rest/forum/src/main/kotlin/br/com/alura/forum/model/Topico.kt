package br.com.alura.forum.model

import java.time.LocalDateTime

data class Topico (
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val curso: Curso,
    val autor: Usuario,
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    val respostas: List<Resposta> = ArrayList(),
    val dataCriacao: LocalDateTime = LocalDateTime.now()
)
