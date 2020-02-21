package com.example.corrotinaskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
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
            val texto1Deferred = async {
                texto1(random.nextLong(3000))
            }
            val texto1 = texto1Deferred.await()
            runOnUiThread{
                texto1Tv.setText(texto1)
            }
        }

        GlobalScope.launch {
            val texto2Deferred = async {
                texto2(random.nextLong(3000))
            }
            val texto2 = texto2Deferred.await()
            runOnUiThread {
                texto2Tv.setText(texto2)
            }
        }


    }
}
