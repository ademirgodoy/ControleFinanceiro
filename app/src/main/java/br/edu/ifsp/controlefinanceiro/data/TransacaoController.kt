package br.edu.ifsp.controlefinanceiro.data

import android.app.Activity

class TransacaoController(val activity: Activity) {
    val transacaoDAO: TransacaoDAO

    init {
        transacaoDAO = TransacaoDAO(activity)
    }

    fun adicionaTransacao(transacao: Transacao){
        transacaoDAO.incluirTransacao(transacao)

    }

    fun listagemTransacao(): List<Transacao>{
        return transacaoDAO.listaTranscacoes()
    }

}