package br.edu.ifsp.controlefinanceiro.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.*
import android.widget.TextView
import br.edu.ifsp.controlefinanceiro.R
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity(), OnItemClickListener {

    lateinit var data:TextView

    val date = getCurrentDateTime()
    val dateInString = date.toString("dd/MM/yyyy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data = findViewById(R.id.dataTV)
        data.setText(dateInString)

        contaBT.setOnClickListener{
            startActivity(Intent(this,ListaContaActivity::class.java))
        }

        transacaoBT.setOnClickListener{
            startActivity(Intent(this,ListaTransacaoActivity::class.java))
        }

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }
}
