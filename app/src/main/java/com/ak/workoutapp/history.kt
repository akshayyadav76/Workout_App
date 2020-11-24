package com.ak.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_b_m_i.*
import kotlinx.android.synthetic.main.activity_history.*

class history : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        setSupportActionBar(toolbar_history_acivity)
        val actionBar = supportActionBar
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = "History"

        }

        toolbar_history_acivity.setNavigationOnClickListener {
            onBackPressed()
        }

         getAllDates()

    }

    private  fun getAllDates(){
        val dbHandler = sqliteOpenHelper(this,null)
       val AllData=  dbHandler.getAllCompletedList()

        for(i in AllData){
            Log.e("dates",i)
        }
    }
}