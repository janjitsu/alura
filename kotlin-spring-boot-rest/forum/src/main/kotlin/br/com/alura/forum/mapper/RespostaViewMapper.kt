package br.com.alura.forum.mapper

import br.com.alura.forum.dto.RespostaView
import br.com.alura.forum.model.Resposta
import org.springframework.stereotype.Component

@Component
class RespostaViewMapper : Mapper<Resposta, RespostaView> {

    override fun map(t: Resposta): RespostaView = RespostaView(
        id = t.id,
        mensagem = t.mensagem,
        nomeAutor = t.autor.nome,
        solucao = t.solucao,
        dataCriacao = t.dataCriacao
    )
}
