package br.com.alura.forum.service

import br.com.alura.forum.dto.AtualizacaoRespostaForm
import br.com.alura.forum.dto.NovaRespostaForm
import br.com.alura.forum.dto.RespostaView
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.RespostaFormMapper
import br.com.alura.forum.mapper.RespostaViewMapper
import br.com.alura.forum.model.Resposta
import org.springframework.stereotype.Service

@Service
class RespostaService (
    private var respostas: List<Resposta>,
    private val respostaViewMapper: RespostaViewMapper,
    private val respostaFormMapper: RespostaFormMapper,
    private val notFoundMessage: String = "Resposta Não Encontrada"
    ){

    fun buscarPorIdTopico(idTopico: Long): List<RespostaView> {
        return respostas.filter { it.idTopico == idTopico }.map { t ->
            respostaViewMapper.map(t)
        }
    }

    fun cadastrar(form: NovaRespostaForm): RespostaView {
        val resposta = respostaFormMapper.map(form)
        resposta.id = respostas.size.toLong() + 1
        respostas = respostas.plus(resposta)
        return respostaViewMapper.map(resposta)
    }

    fun atualizar(form: AtualizacaoRespostaForm): RespostaView {
        val resposta = respostas.stream().filter {
            it.id == form.id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        val respostaAtualizada = resposta.copy(mensagem = form.mensagem)
        respostas = respostas.minus(resposta).plus(respostaAtualizada)
        return respostaViewMapper.map(respostaAtualizada)
    }

    fun deletar(id: Long): Unit {
        val resposta = respostas.stream().filter {
            it.id == id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        respostas = respostas.minus(resposta)
    }
}
