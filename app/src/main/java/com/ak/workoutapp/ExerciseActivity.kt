package com.ak.workoutapp

import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View

import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_exercise.*
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class ExerciseActivity : AppCompatActivity() ,TextToSpeech.OnInitListener{

    private var restTimer : CountDownTimer? =null
    private  var restProgress =0

    private var restTimer2 : CountDownTimer? =null
    private  var restProgress2 =0

    private var exerciseList :ArrayList<ExerciseModel>? =null
    private var currentExercisePosition  = -1

    private var tts:TextToSpeech?=null
    private var player:MediaPlayer?=null


    private  var exerciseAdaptor :ExersiceStatusAdaptor? =null





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
        exerciseList = Constants.defaultExerciseList()
        setupRestView()

        tts = TextToSpeech(this,this)
        setUpExerciseRecycler()
    }

    override fun onDestroy() {
        if(restTimer!=null){
            restTimer!!.cancel()
            restProgress =0
        }
        if(restTimer2!=null){
            restTimer2!!.cancel()
            restProgress2 =0
        }

        if(tts !=null){
            tts!!.stop()
            tts!!.shutdown()
        }
        if(player !=null){
            player!!.stop()
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
                currentExercisePosition++
                setupRestView2()

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

                if(currentExercisePosition <8){
                    setupRestView()
                }else{
                    Toast.makeText(this@ExerciseActivity,"workout finish",Toast.LENGTH_SHORT).show()
                }
            }

        }.start()
    }

    private fun setupRestView(){


        try {


            player = MediaPlayer.create(applicationContext, R.raw.fire)
            player!!.isLooping = false
            player!!.start()
        }catch (e:Exception){
            e.printStackTrace()
        }

        llRestView.visibility = View.VISIBLE
        llRestView2.visibility = View.GONE

        if(restTimer !=null){
            restTimer!!.cancel()
            restProgress =0
        }
        exerciseName.text = exerciseList!![currentExercisePosition+1].getName()
        setRestProgressBar()
    }


    private fun setupRestView2(){


        llRestView.visibility = View.GONE
        llRestView2.visibility = View.VISIBLE

        if(restTimer2 !=null){
            restTimer2!!.cancel()
            restProgress2 =0
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            spack(exerciseList!![currentExercisePosition].getName())
        }
        setRestProgressBar2()
        exercise_image.setImageResource(exerciseList!![currentExercisePosition].getImage())
        tvExerciseName.text = exerciseList!![currentExercisePosition].getName()
    }

    override fun onInit(p0: Int) {
        if(p0 ==TextToSpeech.SUCCESS){
                val result = tts!!.setLanguage(Locale.US)
            if(result == TextToSpeech.LANG_MISSING_DATA || result== TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("tts","error")
            }
            }else{
            Log.e("tts","faild")
        }
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun spack(hear :String){
        tts!!.speak(hear,TextToSpeech.QUEUE_FLUSH,null,"")
    }

    private  fun setUpExerciseRecycler(){
        rvExerciseStatus.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        exerciseAdaptor = ExersiceStatusAdaptor(exerciseList!!,this,)
        rvExerciseStatus.adapter = exerciseAdaptor
    }

}