package br.edu.ifsp.controlefinanceiro.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.edu.ifsp.controlefinanceiro.R
import br.edu.ifsp.controlefinanceiro.data.Transacao
import kotlinx.android.synthetic.main.activity_listatransacao.view.*

class TransacaoAdapter(private val transacoes: List<Transacao>,
                       private val context: Context): Adapter<TransacaoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_listatransacao,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return transacoes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var transacao = transacoes[position]

        holder?.let {
            it.descTransacao.text = transacao.descTransacao
            it.vlrTransacao.text = transacao.vlTransacao.toString()

        }
    }

    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        var descTransacao = itemView.visualizaTransacaoTV
        var vlrTransacao = itemView.valorTransacaoTV
    }


}