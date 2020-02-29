package br.edu.ifsp.scl.programacaoconcorrenteui

import android.os.Bundle
import br.edu.ifsp.scl.programacaoconcorrenteui.ProgramacaoConcorrenteActivity.Constantes.CARREGA_IMAGENS_DELAY
import kotlinx.android.synthetic.main.activity_programacao_concorrente.*
import java.lang.Thread.sleep

class RunOnUiThreadActivity : ProgramacaoConcorrenteActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "RunOnUiThread"
    }

    /* Corpo da thread que será disparada pela thread mãe para tentar carregar as imagens.
    No entanto, a thread filha, disparada pela mãe, chama o handler da thread mãe para solicitar
    o carregamento. */
    override fun run() {
        runOnUiThread {
            /* O corpo da thread filha chama um método da Activity que acessa um handler IMPLÍCITO
            da classe mãe. Dessa forma, o carregamento pode ser feito diretamente sem acessar
            o handler instanciado. */
            sleep(CARREGA_IMAGENS_DELAY)

            altaIv.setImageResource(R.drawable.android_preto)
            baixaIv.setImageResource(R.drawable.android_verde)
        }
    }
}
