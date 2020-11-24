package com.ak.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
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

        if(AllData.size >0){

            tvHistory.visibility = View.VISIBLE
            rvHistory.visibility = View.VISIBLE

            tvNoDataAvailable.visibility = View.GONE

            rvHistory.layoutManager = LinearLayoutManager(this)
            val historyAdaptor = HistoryAdptor(this,AllData)
            rvHistory.adapter = historyAdaptor

        }else{
            tvHistory.visibility = View.GONE
            rvHistory.visibility = View.GONE

            tvNoDataAvailable.visibility = View.VISIBLE
        }
    }
}