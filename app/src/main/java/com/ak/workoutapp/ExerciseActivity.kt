package com.ak.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_exercise.*
import java.util.*
import kotlin.collections.ArrayList

class ExerciseActivity : AppCompatActivity() {

    private var restTimer : CountDownTimer? =null
    private  var restProgress =0

    private var restTimer2 : CountDownTimer? =null
    private  var restProgress2 =0

    private var exerciseList :ArrayList<ExerciseModel>? =null
    private var currentExercisePosition  = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        setSupportActionBar(toolbar_exercise_activity)
        val actionBar = supportActionBar
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        toolbar_exercise_activity.setNavigationOnClickListener {
            onBackPressed()
        }
        setupRestView()
        exerciseList = Constants.defaultExerciseList()
    }

    override fun onDestroy() {
        if(restTimer!=null){
            restTimer!!.cancel()
            restProgress =0
        }
        super.onDestroy()

    }


    private fun setRestProgressBar(){
        progress_bar.progress = restProgress
        restTimer =  object : CountDownTimer(10000,1000){
            override fun onTick(p0: Long) {
               restProgress++
                Log.e("my progreess bar check","$restProgress")
                progress_bar.progress = 10-restProgress
                tvTimer.text = (10-restProgress).toString()

            }

            override fun onFinish() {
                setupRestView2()
               currentExercisePosition++
            }

        }.start()
    }

    private fun setRestProgressBar2(){
        progress_bar2.progress = restProgress2
        restTimer2 =  object : CountDownTimer(30000,1000){
            override fun onTick(p0: Long) {
                restProgress2++
                Log.e("my progreess bar check","$restProgress2")
                progress_bar2.progress = 30-restProgress2
                tvTimer2.text = (30-restProgress2).toString()

            }

            override fun onFinish() {
                Toast.makeText(this@ExerciseActivity," next exersice",Toast.LENGTH_SHORT).show()
            }

        }.start()
    }

    private fun setupRestView(){
        if(restTimer !=null){
            restTimer!!.cancel()
            restProgress =0
        }
        setRestProgressBar()
    }

    private fun setupRestView2(){

        llRestView.visibility = View.GONE
        llRestView2.visibility = View.VISIBLE

        if(restTimer2 !=null){
            restTimer2!!.cancel()
            restProgress2 =0
        }
        setRestProgressBar2()
    }
}