package br.edu.ifsp.scl.programacaoconcorrenteui

import android.os.Bundle
import br.edu.ifsp.scl.programacaoconcorrenteui.ProgramacaoConcorrenteActivity.Constantes.CARREGA_IMAGENS_DELAY
import kotlinx.android.synthetic.main.activity_programacao_concorrente.*
import java.lang.Thread.sleep

class AcessoDiretoActivity : ProgramacaoConcorrenteActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Acesso direto"
    }

    /* Corpo da thread que será disparada pela classe principal para tentar carregar as imagens.
    No entanto, a thread filha com esse corpo, mesmo disparada pela principal, não pode acessar
    elementos de UI da thread mãe, causando uma exceção.
    Exceção esperada: android.view.ViewRootImpl$CalledFromWrongThreadException:
    Only the original thread that created a view hierarchy can touch its views.*/
    override fun run() {
        /* Dorme por CARREGA_IMAGENS_DELAY (ms) */
        sleep(CARREGA_IMAGENS_DELAY) // Execute. Comente essa linha e execute novamente.

        altaIv.setImageResource(R.drawable.android_preto)
        baixaIv.setImageResource(R.drawable.android_verde)
    }
}
