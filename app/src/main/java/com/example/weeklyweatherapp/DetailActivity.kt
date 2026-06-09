package com.example.weeklyweatherapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        val txtDetails = findViewById<TextView>(R.id.txtDetails)

        var displayText = ""

        // Loop through all weather data
        for (i in WeatherData.days.indices) {

            displayText +=
                "Day: ${WeatherData.days[i]}\n" +
                        "Min Temp: ${WeatherData.minTemps[i]}°C\n" +
                        "Max Temp: ${WeatherData.maxTemps[i]}°C\n" +
                        "Condition: ${WeatherData.conditions[i]}\n\n"
        }
        txtDetails.text = displayText
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}