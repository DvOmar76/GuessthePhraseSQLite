package com.example.guessthephrasesqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_words.*

class AddWords : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_words)
        val dbHelper=DBHelper(applicationContext)
        btnAdd.setOnClickListener {
            val word=edWord.text.toString()
            if (word.isNotEmpty()){
               val status= dbHelper.addWord(word)
                if (status!=-1L){
                    Toast.makeText(applicationContext, "word is add $status", Toast.LENGTH_SHORT).show()
                    edWord.text.clear()
                }
            }
        }
    }
}