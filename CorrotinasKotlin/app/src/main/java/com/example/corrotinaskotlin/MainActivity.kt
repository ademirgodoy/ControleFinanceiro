package com.example.corrotinaskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    suspend fun  texto1(tempo: Long): String{
        delay(tempo)
        return "Bom dia"
    }

    suspend fun  texto2(tempo: Long): String{
        delay(tempo)
        return "o sol ja nasceu na fazendinha"
    }

    fun dispararClick(v: View){
        val random = Random(System.currentTimeMillis())

        texto1Tv.setText("")
        texto2Tv.setText("")

        GlobalScope.launch {
            val texto1 = texto1(random.nextLong(3000))
            runOnUiThread{
                texto1Tv.setText(texto1)
            }

            val texto2 = texto2(random.nextLong(3000))
            runOnUiThread{
                texto2Tv.setText(texto2)
            }

        }

    }
}
