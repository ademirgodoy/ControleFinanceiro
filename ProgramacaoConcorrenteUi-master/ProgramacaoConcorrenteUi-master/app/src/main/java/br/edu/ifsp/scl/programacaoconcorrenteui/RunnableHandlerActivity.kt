package br.edu.ifsp.scl.programacaoconcorrenteui

import android.os.Bundle
import br.edu.ifsp.scl.programacaoconcorrenteui.ProgramacaoConcorrenteActivity.Constantes.CARREGA_IMAGENS_DELAY
import kotlinx.android.synthetic.main.activity_programacao_concorrente.*

class RunnableHandlerActivity : ProgramacaoConcorrenteActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Runnable/Handler"
    }

    /* Corpo da thread que será disparada pela thread mãe para tentar carregar as imagens
    No entanto, a thread filha, disparada pela mãe, chama o handler da thread mãe para
    solicitar o carregamento passando um Runnable */
    override fun run() {
        /* Envia um corpo para ser processado pelo Handler depois do delay CARREGA_IMAGENS_DELAY (ms).
        Esse corpo substitui o corpo da função handleMessage para esse caso específico. */
        carregaImagensHandler.postDelayed(
            {
                altaIv.setImageResource(R.drawable.android_preto)
                baixaIv.setImageResource(R.drawable.android_verde)
            },
            CARREGA_IMAGENS_DELAY
        )
    }
}
