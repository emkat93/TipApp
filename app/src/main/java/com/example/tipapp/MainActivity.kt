package com.example.tipapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    val tipForMeal = 1.50
    var numberofMeal: Int = 0
    var totalCalculate: Double = 0.00
    var tipChoice = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val meals: EditText = findViewById(R.id.txtMeal)
        val group: Spinner = findViewById(R.id.spnGroup)
        val calculate: Button = findViewById(R.id.btnCalculate)
        val result: TextView = findViewById(R.id.txtResult)

        calculate.setOnClickListener {
            numberofMeal = meals.text.toString().toInt()
            val currency = DecimalFormat("$###,###.00")
            tipChoice = group.selectedItem.toString()
            totalCalculate = tipForMeal * numberofMeal.toDouble()
            val totalCalculateFormatted = currency.format(totalCalculate)

            result.text = "Cost for meal with a tip of $tipChoice for a meal costing $$numberofMeal is a total $totalCalculateFormatted"
        }
    }
}