package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.calc.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {
lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)


        //setContentView(R.layout.activity_main)
        binding.zero.setOnClickListener { binding.expression.append("0")}
        binding.one.setOnClickListener { binding.expression.append("1")}
        binding.two.setOnClickListener { binding.expression.append("2")}
        binding.three.setOnClickListener { binding.expression.append("3")}
        binding.four.setOnClickListener { binding.expression.append("4")}
        binding.five.setOnClickListener { binding.expression.append("5")}
        binding.six.setOnClickListener { binding.expression.append("6")}
        binding.seven.setOnClickListener { binding.expression.append("7")}
        binding.eight.setOnClickListener { binding.expression.append("8")}
        binding.nine.setOnClickListener { binding.expression.append("9")}
        // arithmetic buttons
        binding.plus.setOnClickListener { binding.expression.append("+")}
        binding.subtract.setOnClickListener { binding.expression.append("-")}
        binding.divide.setOnClickListener { binding.expression.append("/")}
        binding.multiply.setOnClickListener { binding.expression.append("*")}
        binding.rightBracket.setOnClickListener { binding.expression.append("(")}
        binding.leftBracket.setOnClickListener { binding.expression.append(")")}
        binding.signdot.setOnClickListener { binding.expression.append(".")}
        // backspace
        binding.backspace.setOnClickListener {
            var string:String = binding.expression.text.toString()
            if(string.isNotEmpty())
            {
                binding.expression.setText(string.substring(0,string.length-1))
            }
            if (string.isNotEmpty() && string.length==1)
            {
                binding.expression.setTextSize(60F)
            }
        }

        //CLEAR
        binding.clear.setOnClickListener {
            if(binding.expression.text.isNotEmpty())
            {
                binding.expression.setText("")
            }
            if(binding.result.text.isNotEmpty())
            {
                binding.result.setText("")
            }
            binding.expression.setTextSize(60F)
        }

        // Evaluate button
        binding.equal.setOnClickListener {
            var str: String = binding.expression.text.toString()
            if(str.isNotEmpty())
            {
                try {
                    val expression = ExpressionBuilder(str).build()
                    val res = expression.evaluate()
                    binding.result.setText(res.toString())
                    binding.expression.setTextSize(30F)
                }catch (e: Exception){

                }
            }

        }









    }



}