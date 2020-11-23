package com.ak.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_b_m_i.*
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_m_i)

        setSupportActionBar(toolbar_bmi_acivity)
        val actionBar = supportActionBar
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = "calculator bmi"

        }

        toolbar_bmi_acivity.setNavigationOnClickListener {
            onBackPressed()
        }


        btnCalculateUnit.setOnClickListener {
            if(validDateMatricUnit()){
                val heightValue :Float= etMatricUnitHeight.text.toString().toFloat() /100
                val weightValue :Float= etMatricUnitHeight.text.toString().toFloat()

                val bmi = weightValue /(heightValue*heightValue)
                displayBMIResult(bmi)

            }else{
                Toast.makeText(this@BMIActivity,"enter something",Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun validDateMatricUnit():Boolean{
        var isValid = true

        if(etMatricUnitHeight.text.toString().isEmpty()){
            isValid = false
        }else if(etMatricUnitWeight.text.toString().isEmpty()){
            isValid  = false
        }

        return isValid
    }


    private fun displayBMIResult(bmi:Float){

        val bmiLabel :String
        val bmiDescription :String

        if(bmi.compareTo(15f) <=0){
            bmiLabel = "very severely underweight"
            bmiDescription = "oops you really need to take care of your better "
        }else if(bmi.compareTo(15f)>0 && bmi.compareTo(16f)<=0){
            bmiLabel = " severely underweight"
            bmiDescription = "oops you really need to take care of your better "
        }else if(bmi.compareTo(16f)>0 && bmi.compareTo(18.5f)<=0){
            bmiLabel = "  underweight"
            bmiDescription = " take care of your better "
        }else if(bmi.compareTo(18.5f)>0 && bmi.compareTo(25f)<=0){
            bmiLabel = "normal"
            bmiDescription = "cangratulations your are in a good health "
        }else if(bmi.compareTo(25f)>0 && bmi.compareTo(30f)<=0){
            bmiLabel = "overWeight"
            bmiDescription = "oops you really need to take care of your better "
        }else if(bmi.compareTo(30f)>0 && bmi.compareTo(35f)<=0){
            bmiLabel = "Obese class|(Moderately obese)"
            bmiDescription = "oops you really need to take care of your better "
        }else if(bmi.compareTo(35f)>0 && bmi.compareTo(40f)<=0){
            bmiLabel = "Obese class|(serverly obese)"
            bmiDescription = "oops you really need to take care of your better "
        } else{
            bmiLabel = "Obese class|(high obese)"
            bmiDescription = "oops you really need to take care of your better "
        }

        tvYourBMI.visibility = View.VISIBLE
        tvBMIValue.visibility = View.VISIBLE
        tvBMIType.visibility = View.VISIBLE
        tvBMIDescription.visibility = View.VISIBLE

      val bmiValue = BigDecimal(bmi.toDouble()).setScale(2,RoundingMode.HALF_EVEN).toString()
        tvBMIValue.text = bmiValue
        tvBMIType.text = bmiLabel
        tvBMIDescription.text = bmiDescription

    }
}