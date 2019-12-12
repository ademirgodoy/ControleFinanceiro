package br.edu.ifsp.controlefinanceiro.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.ifsp.controlefinanceiro.R
import br.edu.ifsp.controlefinanceiro.adapter.TransacaoAdapter
import br.edu.ifsp.controlefinanceiro.data.Transacao
import br.edu.ifsp.controlefinanceiro.data.TransacaoController
import kotlinx.android.synthetic.main.activity_transacao.*

class ListaTransacaoActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transacao)

        transacaoController = TransacaoController(this)

        val recyclerView = listaTransacaoRecyclerView //RecyclerView

        val adapter: TransacaoAdapter
        adapter = TransacaoAdapter(transacoes(),this)

        recyclerView.adapter = adapter

        val layout = LinearLayoutManager(this)
        recyclerView.layoutManager = layout

        //adapter.notifyDataSetChanged()

        //cadTransacaoBT.setOnClickListener {
        //    startActivity(Intent(this,CadastroContaActivity::class.java))

        //}

    }

    lateinit var transacaoController: TransacaoController
    private fun transacoes():List<Transacao>{
        return transacaoController.listagemTransacao()
    }


}