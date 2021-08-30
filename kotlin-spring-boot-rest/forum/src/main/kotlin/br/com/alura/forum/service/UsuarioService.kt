package br.com.alura.forum.service

import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(var usuarios: List<Usuario>) {
    init {
        usuarios = listOf(
            Usuario(
                id = 1,
                nome = "Jan",
                email = "jan@email.com"
            )
        )
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.first { it.id == id }
    }
}
