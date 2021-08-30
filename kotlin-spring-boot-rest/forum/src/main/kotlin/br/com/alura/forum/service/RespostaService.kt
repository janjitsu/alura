package br.com.alura.forum.service

import br.com.alura.forum.dto.NovaRespostaForm
import br.com.alura.forum.dto.RespostaView
import br.com.alura.forum.mapper.RespostaFormMapper
import br.com.alura.forum.mapper.RespostaViewMapper
import br.com.alura.forum.model.Resposta
import org.springframework.stereotype.Service

@Service
class RespostaService (
    private var respostas: List<Resposta>,
    private val respostaViewMapper: RespostaViewMapper,
    private val respostaFormMapper: RespostaFormMapper
    ){

    fun buscarPorIdTopico(idTopico: Long): List<RespostaView> {
        return respostas.filter { it.idTopico == idTopico }.map { t ->
            respostaViewMapper.map(t)
        }
    }

    fun cadastrar(dto: NovaRespostaForm): RespostaView {
        val resposta = respostaFormMapper.map(dto)
        resposta.id = respostas.size.toLong() + 1
        respostas = respostas.plus(resposta)
        return respostaViewMapper.map(resposta)
    }
}
