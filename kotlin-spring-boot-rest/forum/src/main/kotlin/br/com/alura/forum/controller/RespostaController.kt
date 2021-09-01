package br.com.alura.forum.controller

import br.com.alura.forum.dto.AtualizacaoRespostaForm
import br.com.alura.forum.dto.AtualizacaoTopicoForm
import br.com.alura.forum.dto.NovaRespostaForm
import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.RespostaView
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.model.Resposta
import br.com.alura.forum.model.Topico
import br.com.alura.forum.service.RespostaService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topicos/{id}/respostas")
class RespostaController(private val service: RespostaService) {

    @GetMapping
    fun listar(@PathVariable id: Long): List<RespostaView> {
        return service.buscarPorIdTopico(id)
    }

    @PostMapping
    fun cadastrar(
        @RequestBody @Valid form: NovaRespostaForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<RespostaView> {
        val respostaView = service.cadastrar(form)
        val uriAddress = "/topicos/${form.idTopico}/respostas/${respostaView.id}"
        val uri = uriBuilder.path(uriAddress).build().toUri()
        return ResponseEntity.created(uri).body(respostaView)
    }

    @PutMapping("/{id}")
    fun atualizar(
        @PathVariable id: Long,
        @RequestBody @Valid form: AtualizacaoRespostaForm
    ): ResponseEntity<RespostaView> {
        return ResponseEntity.ok(service.atualizar(form))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long): Unit {
        service.deletar(id)
    }
}
