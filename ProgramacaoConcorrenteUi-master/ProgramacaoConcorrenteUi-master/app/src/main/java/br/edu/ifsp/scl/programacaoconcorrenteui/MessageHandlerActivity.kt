package br.edu.ifsp.scl.programacaoconcorrenteui

import android.os.Bundle
import android.os.Message
import br.edu.ifsp.scl.programacaoconcorrenteui.ProgramacaoConcorrenteActivity.Constantes.CARREGA_IMAGENS_DELAY
import br.edu.ifsp.scl.programacaoconcorrenteui.ProgramacaoConcorrenteActivity.Constantes.CARREGA_IMAGENS_MSG

class MessageHandlerActivity : ProgramacaoConcorrenteActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Message/Handler"
    }

    /* Corpo da thread que será disparada pela thread mãe para tentar carregar as imagens
    No entanto, a thread filha, disparada pela mãe, chama o handler da thread mãe para
    solicitar o carregamento */
    override fun run() {
        /* Prepara uma Message para enviar ao Handler */
        val carregaImagensMsg = Message()
        carregaImagensMsg.what = CARREGA_IMAGENS_MSG

        /* Envia Message para o Handler que vai tratar depois do delay
        CARREGA_IMAGENS_DELAY (ms) */
        carregaImagensHandler.sendMessageDelayed(carregaImagensMsg, CARREGA_IMAGENS_DELAY)
    }
}
