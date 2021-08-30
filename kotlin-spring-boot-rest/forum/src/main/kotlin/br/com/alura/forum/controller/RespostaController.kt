package br.com.alura.forum.controller

import br.com.alura.forum.dto.NovaRespostaForm
import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.RespostaView
import br.com.alura.forum.model.Resposta
import br.com.alura.forum.model.Topico
import br.com.alura.forum.service.RespostaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/topicos/{id}/respostas")
class RespostaController(private val service: RespostaService) {

    @GetMapping
    fun listar(@PathVariable id: Long): List<RespostaView> {
        return service.buscarPorIdTopico(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: NovaRespostaForm): RespostaView {
        return service.cadastrar(dto)
    }
}
