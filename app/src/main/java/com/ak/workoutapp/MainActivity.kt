package com.ak.workoutapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llStart.setOnClickListener {
            Toast.makeText(this, "this working fine ", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }

        llBMI.setOnClickListener {
        val intent = Intent(this, BMIActivity::class.java)
        startActivity(intent)
       }

        llhistory.setOnClickListener {
            val intent = Intent(this,history::class.java)
            startActivity(intent)
        }

    }
}