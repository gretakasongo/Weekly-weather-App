package com.example.weeklyweatherapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // Parallel arrays
    private val days = arrayOf(
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday"
    )
    private val minTemps = IntArray(7)
    private val maxTemps = IntArray(7)
    private val conditions = Array(7) {""}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Inputs
        val edtDayIndex = findViewById<EditText>(R.id.edtDayIndex)
        val edtMin = findViewById<EditText>(R.id.edtMin)
        val edtMax = findViewById<EditText>(R.id.edtMax)
        val edtCondition = findViewById<EditText>(R.id.edtCondition)
        // Buttons
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnAverage = findViewById<Button>(R.id.btnAverage)
        val btnDetails = findViewById<Button>(R.id.btnDetails)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnExit = findViewById<Button>(R.id.btnExit)
        // Output
        val txtAverage = findViewById<TextView>(R.id.txtAverage)
        // Save weather data
        btnSave.setOnClickListener {

            try {
                val index = edtDayIndex.text.toString().toInt()

                if (index < 0 || index > 6) {
                    Toast.makeText(this,
                        "Enter a number between 0 and 6",
                        Toast.LENGTH_LONG).show()

                    return@setOnClickListener
                }
                val min = edtMin.text.toString().toInt()
                val max = edtMax.text.toString().toInt()
                val condition = edtCondition.text.toString()
                minTemps[index] = min
                maxTemps[index] = max
                conditions[index] = condition

                Toast.makeText(this,
                    "Data saved for ${days[index]}",
                    Toast.LENGTH_LONG).show()

                Log.d("WEATHER_APP",
                    "Saved data for ${days[index]}")

            } catch (e: Exception) {
                Toast.makeText(this,
                    "Please enter valid data",
                    Toast.LENGTH_LONG).show()

                Log.e("WEATHER_APP",
                    "Input error")}
        }
        // Calculate average
        btnAverage.setOnClickListener {
            var total = 0

            // Loop through arrays
            for (i in maxTemps.indices) {
                total += (minTemps[i] + maxTemps[i]) / 2
            }
            val average = total /7
            txtAverage.text=
                "Average weekly temperature: $$average°C"

            Log.d("WEATHER_APP",
                "Average calculated")
        }
        // Open detail screen
        btnDetails.setOnClickListener{
            WeatherData.days = days
            WeatherData.minTemps = minTemps
            WeatherData.maxTemps = maxTemps
            WeatherData.conditions = conditions

            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
        // Clear arrays
        btnClear.setOnClickListener {

            for (i in days.indices) {
                minTemps[i] = 0
                maxTemps[i] = 0
                conditions[i] = ""
            }

            edtDayIndex.text.clear()
            edtMin.text.clear()
            edtMax.text.clear()
            edtCondition.text.clear()

            txtAverage.text = ""

            Toast.makeText(this,
                "All data cleared",
                Toast.LENGTH_LONG).show()
        }
        // Exit app
        btnExit.setOnClickListener {
            finishAffinity()
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}