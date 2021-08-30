package br.com.alura.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class NovaRespostaForm (

    @field:NotEmpty
    val mensagem: String,

    @field:NotNull
    val idAutor: Long,

    val idTopico: Long? = null
)
