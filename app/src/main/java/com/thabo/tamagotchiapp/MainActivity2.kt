package com.thabo.tamagotchiapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private var petHealth = 100
    private var petHunger = 50
    private var petCleanliness = 50

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        // Set the buttons and text views
        val btnFeed = findViewById<Button>(R.id.btnFeed)
        val btnClean = findViewById<Button>(R.id.btnClean)
        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val txtHunger = findViewById<EditText>(R.id.txtHunger)
        val txtHappy = findViewById<EditText>(R.id.txtHealth)
        val txtClean = findViewById<EditText>(R.id.txtClean)
        val petImage = findViewById<ImageView>(R.id.petImage)

        //Set initial text values
        txtHunger.setText(petHunger.toString())
        txtHappy.setText(petHealth.toString())
        txtClean.setText(petCleanliness.toString())

        //Handle button clicks
        btnFeed.setOnClickListener {
            petHunger += 10
            petHealth += 10
            petCleanliness += 5
            txtHunger.setText(petHunger.toString())
            petImage.setImageResource(R.drawable.dogeating)
        }
        btnClean.setOnClickListener {
            petCleanliness +=10
            petHealth +=10
            txtClean.setText(petCleanliness.toString())
            petImage.setImageResource(R.drawable.dogbathing)
        }
        btnPlay
        petHealth +=10
        petHunger +=5
        petCleanliness -= 5
        txtHappy.setText(petHealth.toString())
        petImage.setImageResource(R.drawable.dogplaying)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}