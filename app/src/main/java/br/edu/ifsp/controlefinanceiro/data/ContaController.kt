package br.edu.ifsp.controlefinanceiro.data

import android.app.Activity

class ContaController (val activity: Activity){

    val contaDAO: ContaDAO

    init {
        contaDAO = ContaDAO(activity)
    }

    fun adicionaConta(conta: Conta){
        contaDAO.incluirConta(conta)

    }

    fun listagemConta(): List<Conta>{
        return contaDAO.listaContas()
    }
}