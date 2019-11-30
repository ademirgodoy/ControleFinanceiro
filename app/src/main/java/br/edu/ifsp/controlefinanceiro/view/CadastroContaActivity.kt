package br.edu.ifsp.controlefinanceiro.view

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import br.edu.ifsp.controlefinanceiro.R
import br.edu.ifsp.controlefinanceiro.data.Conta
import br.edu.ifsp.controlefinanceiro.data.ContaController
import kotlinx.android.synthetic.main.activity_cadastroconta.*
import java.io.IOException

class CadastroContaActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastroconta)

        contaController = ContaController(this)

        contaSalvarBT.setOnClickListener {
            cadastraConta()
        }

    }

    lateinit var contaController: ContaController

    private fun cadastraConta(){
       val descConta = findViewById<EditText>(R.id.descContaET).text.toString()
       val saldoConta =  findViewById<EditText>(R.id.saldoContaEV).text.toString()

       if (descConta.isNullOrEmpty() || saldoConta.isNullOrEmpty()) {
           Toast.makeText(this,"Obrigatório preenchimento dos campos!", Toast.LENGTH_LONG).show()
       }else {

           if (saldoConta.toFloat() <= 0) {
               Toast.makeText(this,"Obrigatório informar saldo inicial positivo e maior que zero!",Toast.LENGTH_LONG).show()
           }else{
               val conta = Conta(descConta,saldoConta.toFloat())
               contaController.adicionaConta(conta)
               Toast.makeText(this,"Conta adicionada com sucesso!",Toast.LENGTH_LONG).show()
               finish()
           }
       }

    }

}