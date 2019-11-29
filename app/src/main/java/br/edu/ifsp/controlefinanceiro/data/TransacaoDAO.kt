package br.edu.ifsp.controlefinanceiro.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class TransacaoDAO(context: Context) {
    internal var database: SQLiteDatabase? = null
    private var db: SQLiteDB? = null
    val transacao = Transacao()

    init {
        this.db = SQLiteDB(context)
    }

    fun incluirTransacao(t: Transacao): Long {

        database = db!!.getWritableDatabase()

        val values = ContentValues()
        values.put(SQLiteDB.KEY_T_DESCRICAO, t.descTransacao)
        values.put(SQLiteDB.KEY_T_ID_CONTA, t.idConta)
        values.put(SQLiteDB.KEY_T_ID_NT_TRANSACAO, t.idNtransacao)
        values.put(SQLiteDB.KEY_T_ID_PERIODICIDADE, t.idPeriodicidade)
        values.put(SQLiteDB.KEY_T_ID_TP_TRANSACAO, t.idTpTransacao)
        values.put(SQLiteDB.KEY_T_VALOR, t.vlTransacao)
        values.put(SQLiteDB.KEY_T_DATA_TRANSACAO, t.dtTransacao)

        val id = database!!.insert(SQLiteDB.TABLE_TRANSACAO, null, values)

        database!!.close()
        return id

    }

    /*fun excluirConta(t: Transacao) {
        database = db!!.getWritableDatabase()

        database!!.delete(SQLiteDB.TABLE_TRANSACAO,
            SQLiteDB.KEY_T_ID + "=" + t.idTransacao, null)

        database!!.close()

    }*/

    /*fun listaTranscacoes(): List<Conta> {
        database = db!!.getReadableDatabase()

        val transacoes = mutableListOf(transacao)

        val cursor: Cursor

        cursor = database!!.query(SQLiteDB.TABLE_TRANSACAO, null, null,
            null, null, null,
            SQLiteDB.KEY_T_DESCRICAO)

        while (cursor.moveToNext()) {
            val t = Transacao()
            t. = cursor.getLong(0)
            c.descricao = cursor.getString(1)
            c.saldo = cursor.getFloat(2)

            contas.add(c)
        }

        cursor.close()
        database!!.close()

        return contas
    }*/

    /*fun SaldoTotalContas(): Float{
        database = db!!.getReadableDatabase()

        val cursor: Cursor

        cursor = database!!.rawQuery("SELECT SUM(saldo) AS Total FROM " + SQLiteDB.TABLE_CONTA + ";", null)

        var saldoTotal = 0

        if (cursor.moveToFirst()) {

            saldoTotal = cursor.getInt(cursor.getColumnIndex("Total"))

        }
        return saldoTotal.toFloat()
    }*/

}