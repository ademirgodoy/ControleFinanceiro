package br.edu.ifsp.controlefinanceiro.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.controlefinanceiro.R
import br.edu.ifsp.controlefinanceiro.data.Conta
import kotlinx.android.synthetic.main.activity_listaconta.view.*

class ContaAdapter (private val contas: List<Conta>,
                    private val context: Context): RecyclerView.Adapter<ContaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_listaconta,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val conta = contas[position]
        holder.let {
            it.descricao.text = conta.descricao
            it.saldo.text = conta.saldo.toString()

        }
    }

    override fun getItemCount(): Int {
        return contas.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
       val descricao = itemView.visualizaContaTV
       val saldo = itemView.saldoContaTV
    }

}