package com.ugurrsnr.sudoku.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ugurrsnr.sudoku.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding : ActivityGameBinding
    var number1 : Int? = null
    var number2 : Int? = null
    var number3 : Int? = null
    var number4 : Int? = null
    var number5 : Int? = null
    var number6 : Int? = null
    var number7 : Int? = null
    var number8 : Int? = null
    var number9 : Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.submitButton.setOnClickListener {
            // 1. Inputs
            numberMaker()

            if (number1 == null || number2 == null ||number3 == null ||number4 == null ||number5 == null ||number6 == null
                || number7 == null ||number8 == null ||number9 == null){

                Toast.makeText(this,"Please fill the boxes",Toast.LENGTH_LONG).show()

            } else  {
                checkGameResult()
            }


        }

    }

    private fun numberMaker() {
        number1 = binding.box11.text.toString().toIntOrNull()
        number2 = binding.box12.text.toString().toIntOrNull()
        number3 = binding.box13.text.toString().toIntOrNull()
        number4 = binding.box21.text.toString().toIntOrNull()
        number5 = binding.box22.text.toString().toIntOrNull()
        number6 = binding.box23.text.toString().toIntOrNull()
        number7 = binding.box31.text.toString().toIntOrNull()
        number8 = binding.box32.text.toString().toIntOrNull()
        number9 = binding.box33.text.toString().toIntOrNull()
    } //taking the input numbers

    private fun checkGameResult(){
        val cp1 : Int = number1!! + number2!! + number3!! //first row, cp : checkpoint
        val cp2 : Int = number4!! + number5!! + number6!!
        val cp3 : Int = number7!! + number8!! + number9!!
        val cp4 : Int = number1!! + number4!! + number7!! // first column
        val cp5 : Int = number2!! + number5!! + number8!!
        val cp6 : Int = number3!! + number6!! + number9!!

        if (cp1 == 6 && cp2 == 6 && cp3 == 6&& cp4 == 6 && cp5 == 6 && cp6 == 6){
            Toast.makeText(this,"Congrats",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"Check again!",Toast.LENGTH_LONG).show()
        }
    }

    private fun numberBorderChecker(number : Int){

    }
}