package br.edu.ifsp.scl.programacaoconcorrenteui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import br.edu.ifsp.scl.programacaoconcorrenteui.ProgramacaoConcorrenteActivity.Constantes.CARREGA_IMAGENS_MSG
import kotlinx.android.synthetic.main.activity_programacao_concorrente.*

abstract class ProgramacaoConcorrenteActivity : AppCompatActivity() {
    object Constantes {
        const val CARREGA_IMAGENS_MSG = 0
        const val CARREGA_IMAGENS_DELAY = 1000L
    }

    /* Handler interno que preenche os ImageViews da Thread principal */
    val carregaImagensHandler = CarregaImagensHandler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_programacao_concorrente)

        /* Chamando o método que preenche as imagens com o conteúdo */
        carregaImagens()
    }

    fun carregaImagens() {
        /* Instancia uma thread com o método implementado
        pelas classes filhas */
        val carregaImagensThread = Thread { run() }
        carregaImagensThread.start()
    }

    /* Função abstrata que implementa como as imagens serão carregadas.
    Será implementada pelas classes filhas. */
    abstract fun run()

    /* Handler interno que preenche os ImageViews da Thread principal */
    inner class CarregaImagensHandler: Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.what == CARREGA_IMAGENS_MSG) {
                altaIv.setImageResource(R.drawable.android_preto)
                baixaIv.setImageResource(R.drawable.android_verde)
            }
        }
    }
}
