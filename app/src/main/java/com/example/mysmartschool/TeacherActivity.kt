package com.example.mysmartschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TeacherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)

        val nama: TextView = findViewById(R.id.tv_name_recycler)

        val nameTeacher: String = intent.getStringExtra("name")

        nama.setText(nameTeacher)





    }
}
