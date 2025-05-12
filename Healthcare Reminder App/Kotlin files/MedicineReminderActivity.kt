package com.example.medicationremainderapp


import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MedicineReminderActivity : AppCompatActivity() {

    private lateinit var medicineNameInput: EditText
    private lateinit var dosageInput: EditText
    private lateinit var frequencyInput: EditText
    private lateinit var reminderTimePicker: TimePicker
    private lateinit var saveReminderButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicine_reminder)

        medicineNameInput = findViewById(R.id.medicine_name_input)
        dosageInput = findViewById(R.id.dosage_input)
        frequencyInput = findViewById(R.id.frequency_input)
        reminderTimePicker = findViewById(R.id.reminder_time_picker)
        saveReminderButton = findViewById(R.id.save_reminder_button)

        reminderTimePicker.setIs24HourView(true) // Add this!

        saveReminderButton.setOnClickListener {
            saveReminder()
        }
    }

    private fun saveReminder() {
        val medicineName = medicineNameInput.text.toString()
        val dosage = dosageInput.text.toString()
        val frequency = frequencyInput.text.toString()
        val hour = reminderTimePicker.hour
        val minute = reminderTimePicker.minute

        if (medicineName.isEmpty() || dosage.isEmpty() || frequency.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minute)
        calendar.set(Calendar.SECOND, 0)

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, ReminderReceiver::class.java)
        intent.putExtra("medicineName", medicineName)
        intent.putExtra("dosage", dosage)

        val pendingIntent = PendingIntent.getBroadcast(
            this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)

        Toast.makeText(this, "Reminder Set Successfully!", Toast.LENGTH_SHORT).show()
    }
}
