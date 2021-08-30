package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import org.springframework.stereotype.Component

@Component
class CursoService(var cursos: List<Curso>) {

    init {
        cursos = listOf(
            Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação"
            )
        )
    }

    fun buscarPorId(id: Long) : Curso {
        return cursos.first { it.id == id }
    }
}
