package br.edu.ifsp.scl.programacaoconcorrenteui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val opcoes: List<String> = listOf(
            "Acesso direto",
            "Message/Handler",
            "Runnable/Handler",
            "RunOnUiThread",
            "Coroutines"
        )
        
        principalLv.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            opcoes
        )

        principalLv.onItemClickListener = AdapterView.OnItemClickListener() { _, _, posicao, _ ->
            when (posicao) {
                0 -> startActivity(Intent(this, AcessoDiretoActivity::class.java))
                1 -> startActivity(Intent(this, MessageHandlerActivity::class.java))
                2 -> startActivity(Intent(this, RunnableHandlerActivity::class.java))
                3 -> startActivity(Intent(this, RunOnUiThreadActivity::class.java))
                4-> startActivity(Intent(this, CoroutinesActivity::class.java)) // Tarefa
            }
        }
    }
}
