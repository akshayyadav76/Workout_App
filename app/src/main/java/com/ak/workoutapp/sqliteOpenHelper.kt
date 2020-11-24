package com.ak.workoutapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class sqliteOpenHelper(context:Context,factory:SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME,factory, DATABASE_VERSION) {

    companion object{
        private  val DATABASE_VERSION =1
        private  val DATABASE_NAME ="WorkoutApp.db" //name of database
        private  val TABLE_HISTORY ="history"  //table name
        private  val COLUMN_ID = "_id"   //column id
        private  val COLUMN_COMPETED_DATE = "Completed_date"

    }



    override fun onCreate(db: SQLiteDatabase?) {
       val crete_exercise_table = ("CREATE TABLE "+ TABLE_HISTORY + " ("+ COLUMN_ID + " INTEGER PRIMARY KEY, "+ COLUMN_COMPETED_DATE +" TEXT)")
        db?.execSQL(crete_exercise_table)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
      db?.execSQL("DROP TABLE IF EXISTS" + TABLE_HISTORY)
      onCreate(db)
    }


    fun addDate(date:String){
        val values = ContentValues()
        values.put(COLUMN_COMPETED_DATE,date)
        val db = this.writableDatabase
        db.insert(TABLE_HISTORY,null,values)
        db.close()
    }

    fun getAllCompletedList():ArrayList<String>{
        val list = ArrayList<String>()
        val db =this.readableDatabase

        val cursor = db.rawQuery("SELECT * FROM $TABLE_HISTORY", null)
        while (cursor.moveToNext()){
            val dateValue = (cursor.getString(cursor.getColumnIndex(COLUMN_COMPETED_DATE)))
            list.add(dateValue)
        }
        cursor.close()
        return  list
    }

}