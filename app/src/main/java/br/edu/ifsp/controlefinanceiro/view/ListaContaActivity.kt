package br.edu.ifsp.controlefinanceiro.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.controlefinanceiro.R
import br.edu.ifsp.controlefinanceiro.adapter.ContaAdapter
import br.edu.ifsp.controlefinanceiro.data.Conta
import br.edu.ifsp.controlefinanceiro.data.ContaController
import kotlinx.android.synthetic.main.activity_conta.*

class ListaContaActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conta)

        contaController = ContaController(this)

        val recyclerView = listaContaRecyclerView //RecyclerView

        val adapter: ContaAdapter
        adapter = ContaAdapter(contas(),this)

        recyclerView.adapter = adapter

        val layout = LinearLayoutManager(this)
        recyclerView.layoutManager = layout

        //adapter.notifyDataSetChanged()

        cadContaBT.setOnClickListener {
            startActivity(Intent(this,CadastroContaActivity::class.java))

        }


    }


    lateinit var contaController: ContaController
    private fun contas():List<Conta>{
        return contaController.listagemConta()
    }


}