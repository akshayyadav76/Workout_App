package com.ak.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_finish_activity.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.log

class finish_activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_activity)


        setSupportActionBar(toolBar_finish)
        val actionBar = supportActionBar
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        toolBar_finish.setNavigationOnClickListener {
            onBackPressed()
        }


        btnFinish.setOnClickListener {
            finish()
        }

       addDateToDatebase()

    }

    private  fun addDateToDatebase(){
        val Calender = Calendar.getInstance()
        val dateTime = Calender.time
        Log.e("date","$dateTime")

        val sdf = SimpleDateFormat("dd MMM yyyy HH:mm:ss",Locale.getDefault())
        val date = sdf.format(dateTime)

        val dbHendler = sqliteOpenHelper(this,null)
        dbHendler.addDate(date)
        Log.e("date","added")
    }




}