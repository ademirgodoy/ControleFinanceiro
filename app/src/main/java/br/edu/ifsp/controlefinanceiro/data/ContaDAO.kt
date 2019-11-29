package br.edu.ifsp.controlefinanceiro.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class ContaDAO(context: Context) {
    internal var database: SQLiteDatabase? = null
    private var db: SQLiteDB? = null
    val conta = Conta()

    init {
        this.db = SQLiteDB(context)
    }

    fun incluirConta(c: Conta): Long {

        database = db!!.getWritableDatabase()

        val values = ContentValues()
        values.put(SQLiteDB.KEY_CT_DESCRICAO, c.descricao)
        values.put(SQLiteDB.KEY_CT_SALDO, c.saldo)

        val id = database!!.insert(SQLiteDB.TABLE_CONTA, null, values)

        database!!.close()
        return id

    }

    fun excluirConta(c: Conta) {
        database = db!!.getWritableDatabase()

        database!!.delete(SQLiteDB.TABLE_CONTA,
            SQLiteDB.KEY_CT_ID + "=" + c.idConta, null)

        database!!.close()

    }

    fun listaContas(): List<Conta> {
        database = db!!.getReadableDatabase()

        val contas = mutableListOf(conta)

        val cursor: Cursor

        cursor = database!!.query(SQLiteDB.TABLE_CONTA, null, null,
            null, null, null,
            SQLiteDB.KEY_CT_DESCRICAO)

        while (cursor.moveToNext()) {
            val c = Conta()
            c.idConta = cursor.getLong(0)
            c.descricao = cursor.getString(1)
            c.saldo = cursor.getFloat(2)

            contas.add(c)
        }

        cursor.close()
        database!!.close()

        return contas
    }

    fun SaldoTotalContas(): Float{
        database = db!!.getReadableDatabase()

        val cursor: Cursor

        cursor = database!!.rawQuery("SELECT SUM(saldo) AS Total FROM " + SQLiteDB.TABLE_CONTA + ";", null)

        var saldoTotal = 0

        if (cursor.moveToFirst()) {

            saldoTotal = cursor.getInt(cursor.getColumnIndex("Total"))

        }
        return saldoTotal.toFloat()
    }

}