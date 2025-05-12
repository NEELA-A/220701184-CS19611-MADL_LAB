package com.example.medicationremainderapp


import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ViewMedicineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_medicine)

        val listView = findViewById<ListView>(R.id.medicine_list)
        val dbHelper = MedicineDatabaseHelper(this)
        val medicineList = dbHelper.getAllMedicines()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, medicineList)
        listView.adapter = adapter
    }
}
