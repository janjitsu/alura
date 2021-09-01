package br.com.alura.forum.dto

import javax.validation.constraints.NotEmpty

data class AtualizacaoRespostaForm(
    val id: Long,

    @field:NotEmpty
    val mensagem: String
)
