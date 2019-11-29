package br.edu.ifsp.controlefinanceiro.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class TipoTransacaoDAO(context: Context) {
    internal var database: SQLiteDatabase? = null
    private var db: SQLiteDB? = null
    val tipoTransacao = TipoTransacao()

    init {
        this.db = SQLiteDB(context)
    }

    /*fun incluirTipoTransacao(tt: TipoTransacao): Long {

        database = db!!.getWritableDatabase()

        val values = ContentValues()
        values.put(SQLiteDB.KEY_CT_DESCRICAO, tt.descricao)

        val id = database!!.insert(SQLiteDB.TABLE_TP_TRANSACAO, null, values)

        database!!.close()
        return id

    }

    fun excluirTipoTransacao(tt: TipoTransacao) {
        database = db!!.getWritableDatabase()

        database!!.delete(SQLiteDB.TABLE_TP_TRANSACAO,
            SQLiteDB.KEY_CT_ID + "=" + tt.idTipoTransacao, null)

        database!!.close()

    }*/

    fun listaTipoTransacaos(): List<TipoTransacao> {
        database = db!!.getReadableDatabase()

        val tipoTransacoes = mutableListOf(tipoTransacao)

        val cursor: Cursor

        cursor = database!!.query(SQLiteDB.TABLE_TP_TRANSACAO, null, null,
            null, null, null,
            SQLiteDB.KEY_TPT_DESCRICAO)

        while (cursor.moveToNext()) {
            val tt = TipoTransacao()
            tt.idTipoTransacao = cursor.getLong(0)
            tt.descricao = cursor.getString(1)

            tipoTransacoes.add(tt)
        }

        cursor.close()
        database!!.close()

        return tipoTransacoes
    }

}