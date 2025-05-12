package com.example.medicationremainderapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class HomeActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup for Sign Up and Login buttons
        val signupButton: Button = findViewById(R.id.signup_button)
        val loginButton: Button = findViewById(R.id.login_button)



        // Feature Button Click Listeners
        val medicineReminderButton: Button = findViewById(R.id.medicine_reminder_button)

        val addButton:Button=findViewById(R.id.add_button)
        val viewButton :Button = findViewById(R.id.view_medicines_button);

        // Medicine Reminder Feature


        signupButton.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        addButton.setOnClickListener {
            val intent = Intent(this, AddMedicineActivity::class.java)
            startActivity(intent)
        }
        viewButton.setOnClickListener {
            val intent = Intent(this, ViewMedicineActivity::class.java)
            startActivity(intent)
        }
        medicineReminderButton.setOnClickListener {
            val intent = Intent(this, MedicineReminderActivity::class.java)
            startActivity(intent)
        }

        // Set Alarm Feature

    }
}

