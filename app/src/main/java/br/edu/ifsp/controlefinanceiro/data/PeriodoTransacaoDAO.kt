package br.edu.ifsp.controlefinanceiro.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class PeriodoTransacaoDAO(context: Context) {
    internal var database: SQLiteDatabase? = null
    private var db: SQLiteDB? = null
    val periodoTransacao = PeriodoTransacao()

    init {
        this.db = SQLiteDB(context)
    }

    fun listaPeriodoTransacao(): List<PeriodoTransacao> {
        database = db!!.getReadableDatabase()

        val periodoTransacoes = mutableListOf(periodoTransacao)

        val cursor: Cursor

        cursor = database!!.query(SQLiteDB.TABLE_PER_TRANSACAO, null, null,
            null, null, null,
            SQLiteDB.KEY_PT_DESCRICAO)

        while (cursor.moveToNext()) {
            val pt = PeriodoTransacao()
            pt.idPeriodoTransacao = cursor.getLong(0)
            pt.descricao = cursor.getString(1)
            pt.diasPeriodoTransacao = cursor.getLong(2)

            periodoTransacoes.add(pt)
        }

        cursor.close()
        database!!.close()

        return periodoTransacoes
    }

}