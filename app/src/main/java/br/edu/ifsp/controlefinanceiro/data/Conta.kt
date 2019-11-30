package br.edu.ifsp.controlefinanceiro.data

class Conta {
    var idConta: Long = 0L
    var descricao: String = ""
    var saldo: Float = 0F

    constructor(){

    }

    constructor(descricao: String, saldo: Float){
        this.descricao = descricao
        this.saldo = saldo
    }
}