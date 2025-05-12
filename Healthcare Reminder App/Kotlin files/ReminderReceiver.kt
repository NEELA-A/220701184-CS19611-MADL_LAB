package com.example.medicationremainderapp


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ReminderReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val medicineName = intent.getStringExtra("medicineName")
        val dosage = intent.getStringExtra("dosage")

        Toast.makeText(context, "Time to take $medicineName ($dosage)", Toast.LENGTH_LONG).show()

        // Later you can add notification instead of Toast
    }
}

