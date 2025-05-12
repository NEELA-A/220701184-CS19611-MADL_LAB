package com.example.medicationremainderapp



import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddMedicineActivity : AppCompatActivity() {

    private lateinit var dbHelper: MedicineDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_medicine)

        dbHelper = MedicineDatabaseHelper(this)

        val nameEditText = findViewById<EditText>(R.id.medicine_name)
        val timeEditText = findViewById<EditText>(R.id.medicine_time)
        val saveButton = findViewById<Button>(R.id.save_button)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val time = timeEditText.text.toString().trim()

            if (name.isNotEmpty() && time.isNotEmpty()) {
                dbHelper.insertMedicine(name, time)
                Toast.makeText(this, "Medicine saved", Toast.LENGTH_SHORT).show()
                nameEditText.text.clear()
                timeEditText.text.clear()
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
