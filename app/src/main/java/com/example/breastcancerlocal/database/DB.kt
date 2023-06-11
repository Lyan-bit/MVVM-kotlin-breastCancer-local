package com.example.breastcancerlocal.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.breastcancerlocal.model.BreastCancerVO

class DB (context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASENAME, factory, DATABASEVERSION) {

    companion object{
        lateinit var database: SQLiteDatabase

        private val DATABASENAME = "breastcancerApp.db"
        private val DATABASEVERSION = 1

        const val BreastCancerTABLENAME = "BreastCancer"
        const val BreastCancerCOLIdTable = 0
        const val BreastCancerCOLID = 1
        const val BreastCancerCOLAGE = 2
        const val BreastCancerCOLBMI = 3
        const val BreastCancerCOLGLUCOSE = 4
        const val BreastCancerCOLINSULIN = 5
        const val BreastCancerCOLHOMA = 6
        const val BreastCancerCOLLEPTIN = 7
        const val BreastCancerCOLADIPONECTIN = 8
        const val BreastCancerCOLRESISTIN = 9
        const val BreastCancerCOLMCP = 10
        const val BreastCancerCOLOUTCOME = 11

        val BreastCancerCOLS: Array<String> = arrayOf<String>("idTable", "id", "age", "bmi", "glucose", "insulin", "homa", "leptin", "adiponectin", "resistin", "mcp", "outcome")
        const val BreastCancerNUMBERCOLS = 11
    
   }
private val BreastCancerCREATESCHEMA =
    "create table BreastCancer (idTable integer primary key autoincrement" +
        ", id VARCHAR(50) not null"+
        ", age integer not null"+
        ", bmi float not null"+
        ", glucose float not null"+
        ", insulin float not null"+
        ", homa float not null"+
        ", leptin float not null"+
        ", adiponectin float not null"+
        ", resistin float not null"+
        ", mcp float not null"+
        ", outcome VARCHAR(50) not null"+
    ")"

    override fun onCreate(db: SQLiteDatabase) {
         db.execSQL(BreastCancerCREATESCHEMA)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + BreastCancerCREATESCHEMA)
        onCreate(db)
    }

    fun onDestroy() {
        database.close()
    }

    fun listBreastCancer(): ArrayList<BreastCancerVO> {
        val res = ArrayList<BreastCancerVO>()
        database = readableDatabase
        val cursor: Cursor =
            database.query(BreastCancerTABLENAME, BreastCancerCOLS, null, null, null, null, null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast()) {
            res.add(setData(cursor))
            cursor.moveToNext()
        }
        cursor.close()
        return res
    }

    fun createBreastCancer(breastcancervo: BreastCancerVO) {
        database = writableDatabase
        database.insert(BreastCancerTABLENAME, BreastCancerCOLS[1], putData(breastcancervo))
    }

    fun searchByBreastCancerid(value: String): ArrayList<BreastCancerVO> {
            val res = ArrayList<BreastCancerVO>()
	        database = readableDatabase
	        val args = arrayOf(value)
	        val cursor: Cursor = database.rawQuery(
	            "select idTable, id, age, bmi, glucose, insulin, homa, leptin, adiponectin, resistin, mcp, outcome from BreastCancer where id = ?",
	            args
	        )
	        cursor.moveToFirst()
	        while (!cursor.isAfterLast()) {
				res.add(setData(cursor))
	            cursor.moveToNext()
	        }
	        cursor.close()
	        return res
	    }
	     
    fun searchByBreastCancerage(value: String): ArrayList<BreastCancerVO> {
            val res = ArrayList<BreastCancerVO>()
	        database = readableDatabase
	        val args = arrayOf(value)
	        val cursor: Cursor = database.rawQuery(
	            "select idTable, id, age, bmi, glucose, insulin, homa, leptin, adiponectin, resistin, mcp, outcome from BreastCancer where age = ?",
	            args
	        )
	        cursor.moveToFirst()
	        while (!cursor.isAfterLast()) {
				res.add(setData(cursor))
	            cursor.moveToNext()
	        }
	        cursor.close()
	        return res
	    }
	     
    fun searchByBreastCancerbmi(value: String): ArrayList<BreastCancerVO> {
            val res = ArrayList<BreastCancerVO>()
	        database = readableDatabase
	        val args = arrayOf(value)
	        val cursor: Cursor = database.rawQuery(
	            "select idTable, id, age, bmi, glucose, insulin, homa, leptin, adiponectin, resistin, mcp, outcome from BreastCancer where bmi = ?",
	            args
	        )
	        cursor.moveToFirst()
	        while (!cursor.isAfterLast()) {
				res.add(setData(cursor))
	            cursor.moveToNext()
	        }
	        cursor.close()
	        return res
	    }
	     
    fun searchByBreastCancerglucose(value: String): ArrayList<BreastCancerVO> {
            val res = ArrayList<BreastCancerVO>()
	        database = readableDatabase
	        val args = arrayOf(value)
	        val cursor: Cursor = database.rawQuery(
	            "select idTable, id, age, bmi, glucose, insulin, homa, leptin, adiponectin, resistin, mcp, outcome from BreastCancer where glucose = ?",
	            args
	        )
	        cursor.moveToFirst()
	        while (!cursor.isAfterLast()) {
				res.add(setData(cursor))
	            cursor.moveToNext()
	        }
	        cursor.close()
	        return res
	    }
	     
    fun searchByBreastCancerinsulin(value: String): ArrayList<BreastCancerVO> {
            val res = ArrayList<BreastCancerVO>()
	        database = readableDatabase
	        val args = arrayOf(value)
	        val cursor: Cursor = database.rawQuery(
	            "select idTable, id, age, bmi, glucose, insulin, homa, leptin, adiponectin, resistin, mcp, outcome from BreastCancer where insulin = ?",
	            args
	        )
	        cursor.moveToFirst()
	        while (!cursor.isAfterLast()) {
				res.add(setData(cursor))
	            cursor.moveToNext()
	        }
	        cursor.close()
	        return res
	    }
	     
    fun searchByBreastCancerhoma(value: String): ArrayList<BreastCancerVO> {
            val res = ArrayList<BreastCancerVO>()
	        database = readableDatabase
	        val args = arrayOf(value)
	        val cursor: Cursor = database.rawQuery(
	            "select idTable, id, age, bmi, glucose, insulin, homa, leptin, adiponectin, resistin, mcp, outcome from BreastCancer where homa = ?",
	            args
	        )
	        cursor.moveToFirst()
	        while (!cursor.isAfterLast()) {
				res.add(setData(cursor))
	            cursor.moveToNext()
	        }
	        cursor.close()
	        return res
	    }
	     
    fun searchByBreastCancerleptin(value: String): ArrayList<BreastCancerVO> {
            val res = ArrayList<BreastCancerVO>()
	        database = readableDatabase
	        val args = arrayOf(value)
	        val cursor: Cursor = database.rawQuery(
	            "select idTable, id, age, bmi, glucose, insulin, homa, leptin, adiponectin, resistin, mcp, outcome from BreastCancer where leptin = ?",
	            args
	        )
	        cursor.moveToFirst()
	        while (!cursor.isAfterLast()) {
				res.add(setData(cursor))
	            cursor.moveToNext()
	        }
	        cursor.close()
	        return res
	    }
	     
    fun searchByBreastCanceradiponectin(value: String): ArrayList<BreastCancerVO> {
            val res = ArrayList<BreastCancerVO>()
	        database = readableDatabase
	        val args = arrayOf(value)
	        val cursor: Cursor = database.rawQuery(
	            "select idTable, id, age, bmi, glucose, insulin, homa, leptin, adiponectin, resistin, mcp, outcome from BreastCancer where adiponectin = ?",
	            args
	        )
	        cursor.moveToFirst()
	        while (!cursor.isAfterLast()) {
				res.add(setData(cursor))
	            cursor.moveToNext()
	        }
	        cursor.close()
	        return res
	    }
	     
    fun searchByBreastCancerresistin(value: String): ArrayList<BreastCancerVO> {
            val res = ArrayList<BreastCancerVO>()
	        database = readableDatabase
	        val args = arrayOf(value)
	        val cursor: Cursor = database.rawQuery(
	            "select idTable, id, age, bmi, glucose, insulin, homa, leptin, adiponectin, resistin, mcp, outcome from BreastCancer where resistin = ?",
	            args
	        )
	        cursor.moveToFirst()
	        while (!cursor.isAfterLast()) {
				res.add(setData(cursor))
	            cursor.moveToNext()
	        }
	        cursor.close()
	        return res
	    }
	     
    fun searchByBreastCancermcp(value: String): ArrayList<BreastCancerVO> {
            val res = ArrayList<BreastCancerVO>()
	        database = readableDatabase
	        val args = arrayOf(value)
	        val cursor: Cursor = database.rawQuery(
	            "select idTable, id, age, bmi, glucose, insulin, homa, leptin, adiponectin, resistin, mcp, outcome from BreastCancer where mcp = ?",
	            args
	        )
	        cursor.moveToFirst()
	        while (!cursor.isAfterLast()) {
				res.add(setData(cursor))
	            cursor.moveToNext()
	        }
	        cursor.close()
	        return res
	    }
	     
    fun searchByBreastCanceroutcome(value: String): ArrayList<BreastCancerVO> {
            val res = ArrayList<BreastCancerVO>()
	        database = readableDatabase
	        val args = arrayOf(value)
	        val cursor: Cursor = database.rawQuery(
	            "select idTable, id, age, bmi, glucose, insulin, homa, leptin, adiponectin, resistin, mcp, outcome from BreastCancer where outcome = ?",
	            args
	        )
	        cursor.moveToFirst()
	        while (!cursor.isAfterLast()) {
				res.add(setData(cursor))
	            cursor.moveToNext()
	        }
	        cursor.close()
	        return res
	    }

    fun editBreastCancer(breastcancervo: BreastCancerVO) {
        database = writableDatabase
        val args = arrayOf(breastcancervo.id)
        database.update(BreastCancerTABLENAME, putData(breastcancervo), "id =?", args)
    }

    fun deleteBreastCancer(value: String) {
        database = writableDatabase
        val args = arrayOf(value)
        database.delete(BreastCancerTABLENAME, "id = ?", args)
    }

	private fun setData(cursor: Cursor): BreastCancerVO {
		val breastcancervo = BreastCancerVO()
		breastcancervo.id = cursor.getString(BreastCancerCOLID)
		breastcancervo.age = cursor.getInt(BreastCancerCOLAGE)
		breastcancervo.bmi = cursor.getFloat(BreastCancerCOLBMI)
		breastcancervo.glucose = cursor.getFloat(BreastCancerCOLGLUCOSE)
		breastcancervo.insulin = cursor.getFloat(BreastCancerCOLINSULIN)
		breastcancervo.homa = cursor.getFloat(BreastCancerCOLHOMA)
		breastcancervo.leptin = cursor.getFloat(BreastCancerCOLLEPTIN)
		breastcancervo.adiponectin = cursor.getFloat(BreastCancerCOLADIPONECTIN)
		breastcancervo.resistin = cursor.getFloat(BreastCancerCOLRESISTIN)
		breastcancervo.mcp = cursor.getFloat(BreastCancerCOLMCP)
		breastcancervo.outcome = cursor.getString(BreastCancerCOLOUTCOME)
		return breastcancervo
	}

	private fun putData(breastcancervo: BreastCancerVO): ContentValues {
		val wr = ContentValues(BreastCancerNUMBERCOLS)
		wr.put(BreastCancerCOLS[BreastCancerCOLID], breastcancervo.id)
		wr.put(BreastCancerCOLS[BreastCancerCOLAGE], breastcancervo.age)
		wr.put(BreastCancerCOLS[BreastCancerCOLBMI], breastcancervo.bmi)
		wr.put(BreastCancerCOLS[BreastCancerCOLGLUCOSE], breastcancervo.glucose)
		wr.put(BreastCancerCOLS[BreastCancerCOLINSULIN], breastcancervo.insulin)
		wr.put(BreastCancerCOLS[BreastCancerCOLHOMA], breastcancervo.homa)
		wr.put(BreastCancerCOLS[BreastCancerCOLLEPTIN], breastcancervo.leptin)
		wr.put(BreastCancerCOLS[BreastCancerCOLADIPONECTIN], breastcancervo.adiponectin)
		wr.put(BreastCancerCOLS[BreastCancerCOLRESISTIN], breastcancervo.resistin)
		wr.put(BreastCancerCOLS[BreastCancerCOLMCP], breastcancervo.mcp)
		wr.put(BreastCancerCOLS[BreastCancerCOLOUTCOME], breastcancervo.outcome)
		return wr
	}

}
