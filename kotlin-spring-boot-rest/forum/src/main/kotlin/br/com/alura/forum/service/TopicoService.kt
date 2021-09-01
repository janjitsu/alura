package br.com.alura.forum.service

import br.com.alura.forum.dto.AtualizacaoTopicoForm
import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.Resposta
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = listOf(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map { t ->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList()) // para que isso?
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.first { it.id == id }
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = topicos.first { it.id == form.id }
        val topicoAtualizado = topico.copy(
                titulo = form.titulo,
                mensagem = form.mensagem
            )
        topicos = topicos.minus(topico).plus(topicoAtualizado)
        return topicoViewMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long): Unit {
        val topico = topicos.first { it.id == id }
        topicos = topicos.minus(topico)
    }
}
