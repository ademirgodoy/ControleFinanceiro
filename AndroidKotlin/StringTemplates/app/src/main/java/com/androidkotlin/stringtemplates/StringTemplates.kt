package com.androidkotlin.stringtemplates

fun main(args: Array<String>) {
    //exemplode variaveis e constantes
    var nome = "Ademir"
    println("Olá $nome")
    println("$nome possui ${nome.length} caracteres")
    val msg = "Meu nome é $nome"
    println(msg)

    var nome2:String = "Ricardo"
    println("Olá $nome2")
    println("$nome2 possui ${nome2.length} caracteres")
    nome2 = "Picard"
    println("Olá $nome2")
    println("$nome2 possui ${nome2.length} caracteres")

    val nome3: String = "Tales"
   // nome3 = "Ricardo"
    println("Olá $nome3")
    println("$nome3 possui ${nome3.length}")

}