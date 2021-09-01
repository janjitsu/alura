package br.com.alura.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class AtualizacaoTopicoForm(
    val id: Long? = null,

    @field:Size(min = 5, max = 100)
    val titulo: String,

    @field:NotEmpty
    val mensagem: String
)
