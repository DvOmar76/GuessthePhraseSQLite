package com.example.guessthephrasesqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper(context: Context):SQLiteOpenHelper(context,"Words",null,1) {

    override fun onCreate(p0: SQLiteDatabase?) {
        if (p0!=null)
        {
            p0.execSQL("create table Phrases(id integer primary key ,word text)")
        }

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {}

    fun addWord(text :String): Long {
        val cv=ContentValues()
        cv.put("word",text)
        return this.writableDatabase.insert("Phrases",null,cv)
    }

    fun getWords():ArrayList<String>{
        val words=ArrayList<String>()
        val cursor:Cursor=this.readableDatabase.query("Phrases",null,null,null,null,null,null)

        if(cursor.moveToFirst()){
            var word=cursor.getString(cursor.getColumnIndex("word"))
            words.add(word)
            while (cursor.moveToNext()){
                Log.d("word2222",word)
                word=cursor.getString(cursor.getColumnIndex("word"))
                words.add(word)
            }
        }

        cursor.close()
        return words

    }
}