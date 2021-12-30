package com.rizwanamjadnov.mongodbatlas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.rizwanamjadnov.mongodbatlas.mongodb.Person


class MainActivity : AppCompatActivity() {
lateinit var create_Button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        create_Button=findViewById(R.id.createButton)
        create_Button.setOnClickListener{
            val cls2 = Person("kashir",16)
            cls2.create("kashir",16)

        }
    }
}