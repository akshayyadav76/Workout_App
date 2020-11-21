package com.ak.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_finish_activity.*

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


    }

}