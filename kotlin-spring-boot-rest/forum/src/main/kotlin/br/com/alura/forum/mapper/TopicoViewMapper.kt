package br.com.alura.forum.mapper

import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.model.Topico
import br.com.alura.forum.service.RespostaService
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper(
    val respostaService: RespostaService
) : Mapper<Topico, TopicoView> {

    override fun map(t: Topico): TopicoView = TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            status = t.status,
            respostas = respostaService.buscarPorIdTopico(t.id!!),
            dataCriacao = t.dataCriacao
        )
}
