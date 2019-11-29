package br.edu.ifsp.controlefinanceiro.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.annotation.Nullable

class SQLiteDB(@Nullable context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE_CONTA)
        db?.execSQL(CREATE_TABLE_TP_TRANSACAO)
        db?.execSQL(tipo1)
        db?.execSQL(tipo2)
        db?.execSQL(tipo3)
        db?.execSQL(tipo4)
        db?.execSQL(tipo5)
        db?.execSQL(tipo6)
        db?.execSQL(tipo7)
        db?.execSQL(tipo8)
        db?.execSQL(tipo9)
        db?.execSQL(tipo10)
        db?.execSQL(CREATE_TABLE_NAT_TRANSACAO)
        db?.execSQL(INSERT_CREDITO)
        db?.execSQL(INSERT_DEBITO)
        db?.execSQL(CREATE_TABLE_PER_TRANSACAO)
        db?.execSQL(INSERT_UNICA)
        db?.execSQL(INSERT_DIARIA)
        db?.execSQL(INSERT_SEMANAL)
        db?.execSQL(INSERT_MENSAL)
        db?.execSQL(CREATE_TABLE_TRANSACAO)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        private val DATABASE_NAME = "ControleFinanceiro.db"
        private val DATABASE_VERSION = 1

        //tabela conta e atributos
        val TABLE_CONTA = "conta"
        val KEY_CT_ID = "id_conta"
        val KEY_CT_DESCRICAO = "desc_conta"
        val KEY_CT_SALDO = "saldo_conta"

        private val CREATE_TABLE_CONTA = ("CREATE TABLE IF NOT EXISTS " + TABLE_CONTA + " ("
                                          + KEY_CT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                          + KEY_CT_DESCRICAO + " TEXT, "
                                          + KEY_CT_SALDO + " REAL);")

        //tabela tipo transacao e atributos
        val TABLE_TP_TRANSACAO = "tipo_trasacao"
        val KEY_TPT_ID = "id_tp_transacao"
        val KEY_TPT_DESCRICAO = "desc_tp_transacao"

        private val CREATE_TABLE_TP_TRANSACAO = ("CREATE TABLE IF NOT EXISTS " + TABLE_TP_TRANSACAO + " ("
                                                 + KEY_TPT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                 + KEY_TPT_DESCRICAO + " TEXT);")

        val tipo1 = ("INSERT INTO "+ TABLE_TP_TRANSACAO+ "("+ KEY_TPT_DESCRICAO+") VALUES ('ALIMENTAÇÃO');")
        val tipo2 = ("INSERT INTO "+ TABLE_TP_TRANSACAO+ "("+ KEY_TPT_DESCRICAO+") VALUES ('SAÚDE');")
        val tipo3 = ("INSERT INTO "+ TABLE_TP_TRANSACAO+ "("+ KEY_TPT_DESCRICAO+") VALUES ('TRANSPORTE');")
        val tipo4 = ("INSERT INTO "+ TABLE_TP_TRANSACAO+ "("+ KEY_TPT_DESCRICAO+") VALUES ('MORADIA');")
        val tipo5 = ("INSERT INTO "+ TABLE_TP_TRANSACAO+ "("+ KEY_TPT_DESCRICAO+") VALUES ('EDUCAÇÃO');")
        val tipo6 = ("INSERT INTO "+ TABLE_TP_TRANSACAO+ "("+ KEY_TPT_DESCRICAO+") VALUES ('LAZER');")
        val tipo7 = ("INSERT INTO "+ TABLE_TP_TRANSACAO+ "("+ KEY_TPT_DESCRICAO+") VALUES ('TARIFAS BANCÁRIAS');")
        val tipo8 = ("INSERT INTO "+ TABLE_TP_TRANSACAO+ "("+ KEY_TPT_DESCRICAO+") VALUES ('LUZ');")
        val tipo9 = ("INSERT INTO "+ TABLE_TP_TRANSACAO+ "("+ KEY_TPT_DESCRICAO+") VALUES ('ÁGUA');")
        val tipo10 = ("INSERT INTO "+ TABLE_TP_TRANSACAO+ "("+ KEY_TPT_DESCRICAO+") VALUES ('TELEFONE');")

        //tabela natureza transacao e atributos
        val TABLE_NAT_TRANSACAO = "natureza_transacao"
        val KEY_NT_ID = "id_nt_transacao"
        val KEY_NT_DESCRICAO = "desc_nt_transacao"

        private val CREATE_TABLE_NAT_TRANSACAO = ("CREATE TABLE IF NOT EXISTS " + TABLE_NAT_TRANSACAO + " ("
                                                  + KEY_NT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                  + KEY_NT_DESCRICAO + " TEXT);")

        val INSERT_CREDITO = ("INSERT INTO "+TABLE_NAT_TRANSACAO+ "("+ KEY_NT_DESCRICAO+") VALUES ('CREDITO');")
        val INSERT_DEBITO = ("INSERT INTO "+TABLE_NAT_TRANSACAO+ "("+ KEY_NT_DESCRICAO+") VALUES ('DEBITO');")

        //tabela periodicidade transacao e atributos
        val TABLE_PER_TRANSACAO = "periodicidade_transacao"
        val KEY_PT_ID = "id_pt_transacao"
        val KEY_PT_DESCRICAO = "desc_pt_transacao"
        val KEY_PT_VALOR = "dias_periodicidade"

        private val CREATE_TABLE_PER_TRANSACAO = ("CREATE TABLE IF NOT EXISTS " + TABLE_PER_TRANSACAO + " ("
                                                  + KEY_PT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                  + KEY_PT_DESCRICAO + " TEXT, "
                                                  + KEY_PT_VALOR + ");")

        val INSERT_UNICA = ("INSERT INTO "+ TABLE_PER_TRANSACAO+ "("+ KEY_PT_DESCRICAO+", "+ KEY_PT_VALOR+" VALUES ('UNICA',0);")
        val INSERT_DIARIA = ("INSERT INTO "+ TABLE_PER_TRANSACAO+ "("+ KEY_PT_DESCRICAO+", "+ KEY_PT_VALOR+" VALUES ('DIARIA',1);")
        val INSERT_SEMANAL = ("INSERT INTO "+ TABLE_PER_TRANSACAO+ "("+ KEY_PT_DESCRICAO+", "+ KEY_PT_VALOR+" VALUES ('SEMANAL',7);")
        val INSERT_MENSAL = ("INSERT INTO "+ TABLE_PER_TRANSACAO+ "("+ KEY_PT_DESCRICAO+", "+ KEY_PT_VALOR+" VALUES ('MENSAL',30);")

        //tabela de transaçoes e atributos
        val TABLE_TRANSACAO = "transacao"
        val KEY_T_ID = "id_transacao"
        val KEY_T_DESCRICAO = "desc_transacao"
        val KEY_T_ID_CONTA = "id_conta"
        val KEY_T_ID_NT_TRANSACAO = "id_nt_transacao"
        val KEY_T_ID_TP_TRANSACAO = "id_tp_transacao"
        val KEY_T_VALOR = "vl_transacao"
        val KEY_T_ID_PERIODICIDADE = "id_pt_periodicidade"
        val KEY_T_DATA_TRANSACAO = "dt_transacao"

        private val CREATE_TABLE_TRANSACAO = ("CREATE TABLE IF NOT EXISTS " + TABLE_TRANSACAO + " ("
                                              + KEY_T_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                              + KEY_T_DESCRICAO + " TEXT, "
                                              + KEY_T_ID_CONTA + " INTEGER, "
                                              + KEY_T_ID_NT_TRANSACAO + " INTEGER, "
                                              + KEY_T_ID_TP_TRANSACAO + " INTEGER, "
                                              + KEY_T_VALOR + " REAL, "
                                              + KEY_T_ID_PERIODICIDADE + " INTEGER, "
                                              + KEY_T_DATA_TRANSACAO + " TEXT, "
                                              + "FOREIGN KEY("+KEY_T_ID_CONTA+") REFERENCES "+TABLE_CONTA+" ("+KEY_CT_ID +"),"
                                              + "FOREIGN KEY("+KEY_T_ID_NT_TRANSACAO+") REFERENCES "+ TABLE_NAT_TRANSACAO+" ("+ KEY_NT_ID +"),"
                                              + "FOREIGN KEY("+KEY_T_ID_TP_TRANSACAO+") REFERENCES "+ TABLE_TP_TRANSACAO+" ("+ KEY_TPT_ID +"),"
                                              + "FOREIGN KEY("+KEY_T_ID_PERIODICIDADE+") REFERENCES "+ TABLE_PER_TRANSACAO+" ("+ KEY_PT_ID+")"
                                              +");")









    }
}