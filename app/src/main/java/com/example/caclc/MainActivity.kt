package com.example.caclc

import android.os.Bundle
import android.service.autofill.UserData
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

fun operatorCount(operationType: String, totalCount: Float, mainCount: String): Float {
    val count = mainCount.toFloatOrNull() ?: 0.0f
    return when (operationType) {
        "+" -> totalCount + count
        "-" -> totalCount - count
        "*" -> totalCount * count
        "/" -> if (count != 0.0f) totalCount / count else totalCount
        else -> totalCount
    }
}
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        var totalCount = 0.0f
        var mainCount = ""
        var operation_type = ""
        val label = findViewById<TextView>(R.id.mainlbl)
        val userData: EditText = findViewById(R.id.edit_text)
        val button: Button = findViewById(R.id.button)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val button0: Button = findViewById(R.id.button0)
        val buttonEuq: Button = findViewById(R.id.button_euq)
        val buttonDev: Button = findViewById(R.id.divide)
        val buttonPlus: Button = findViewById(R.id.plus)
        val buttonMinus: Button = findViewById(R.id.minus)
        val buttonMultiply: Button = findViewById(R.id.multi)
        val buttonClear: Button = findViewById(R.id.del)
        super.onCreate(savedInstanceState)
        button.setOnClickListener{
            mainCount += "1"
            userData.setText(mainCount)
        }
        button2.setOnClickListener{
            mainCount += "2"
            userData.setText(mainCount)
        }
        button3.setOnClickListener{
            mainCount += "3"
            userData.setText(mainCount)
        }
        button4.setOnClickListener{
            mainCount += "4"
            userData.setText(mainCount)
        }
        button5.setOnClickListener{
            mainCount += "5"
            userData.setText(mainCount)
        }
        button6.setOnClickListener{
            mainCount += "6"
            userData.setText(mainCount)
        }
        button7.setOnClickListener{
            mainCount += "7"
            userData.setText(mainCount)
        }
        button8.setOnClickListener{
            mainCount += "8"
            userData.setText(mainCount)
        }
        button9.setOnClickListener{
            mainCount += "9"
            userData.setText(mainCount)
        }
        button0.setOnClickListener{
            mainCount += "0"
            userData.setText(mainCount)
        }
        buttonClear.setOnClickListener{
            totalCount = 0.0f
            userData.setText(mainCount)
        }
        buttonDev.setOnClickListener {
            operation_type = "/"
            if (mainCount != ""){
                if (totalCount != 0.0f) {
                    totalCount /= mainCount.toFloat()
                    mainCount = ""
                }
                mainCount = ""
            }
        }
        buttonMinus.setOnClickListener{
            operation_type = "-"
            if (mainCount != "") {
                totalCount -= mainCount.toFloat()
                mainCount = ""
            }
        }
        buttonPlus.setOnClickListener{
            operation_type = "+"
            if (mainCount != "") {
                totalCount += mainCount.toFloat()
                mainCount = ""
            }
        }
        buttonMultiply.setOnClickListener{
            if (mainCount != ""){
            operation_type = "*"
            totalCount *= mainCount.toFloat()
            mainCount = ""
                }
        }
        buttonEuq.setOnClickListener {
            if (userData.text.toString().isNotEmpty()) {
                var numNow = userData.text.toString()
                totalCount = operatorCount(operation_type , totalCount , numNow)
                userData.setText(totalCount.toString())
                mainCount = ""
            }
            else {
                userData.setText(totalCount.toString())
                mainCount = ""
            }
        }

    }
}