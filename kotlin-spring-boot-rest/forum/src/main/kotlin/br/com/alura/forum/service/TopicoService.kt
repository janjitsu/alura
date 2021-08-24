package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService {
    fun listar(): List<Topico> = listOf(
        Topico(
            id = 1,
            titulo = "Duvida Kotlin",
            mensagem = "Teste do kotlin",
            curso = Curso(
                id = 1,
                nome = "kotlin",
                categoria = "Programacao"
            ),
            autor = Usuario(
                id = 1,
                nome = "Ana da Silva",
                email = "ana@email.com"
            )
        )
    )
}
