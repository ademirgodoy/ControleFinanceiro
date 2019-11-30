package br.edu.ifsp.controlefinanceiro.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.controlefinanceiro.R
import br.edu.ifsp.controlefinanceiro.adapter.ContaAdapter
import br.edu.ifsp.controlefinanceiro.data.Conta
import br.edu.ifsp.controlefinanceiro.data.ContaController

class ListaContaActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conta)

        contaController = ContaController(this)

        val recyclerView = RecyclerView(this)
        recyclerView.adapter = ContaAdapter(contas(),this)

        val layout = LinearLayoutManager(this)
        recyclerView.layoutManager = layout


    }

    lateinit var contaController: ContaController
    private fun contas():List<Conta>{
        return contaController.listagemConta()
    }




}