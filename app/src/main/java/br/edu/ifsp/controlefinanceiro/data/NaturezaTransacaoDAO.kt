package br.edu.ifsp.controlefinanceiro.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class NaturezaTransacaoDAO(context: Context) {
    internal var database: SQLiteDatabase? = null
    private var db: SQLiteDB? = null
    val naturezaTransacao = NaturezaTransacao()

    init {
        this.db = SQLiteDB(context)
    }

    fun listaTipoTransacaos(): List<NaturezaTransacao> {
        database = db!!.getReadableDatabase()

        val naturezaTransacoes = mutableListOf(naturezaTransacao)

        val cursor: Cursor

        cursor = database!!.query(SQLiteDB.TABLE_NAT_TRANSACAO, null, null,
            null, null, null,
            SQLiteDB.KEY_NT_DESCRICAO)

        while (cursor.moveToNext()) {
            val nt = NaturezaTransacao()
            nt.idNaturezaTransacao = cursor.getLong(0)
            nt.descricao = cursor.getString(1)

            naturezaTransacoes.add(nt)
        }

        cursor.close()
        database!!.close()

        return naturezaTransacoes
    }

}