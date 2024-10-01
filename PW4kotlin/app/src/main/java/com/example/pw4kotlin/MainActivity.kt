package com.example.pw4kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Кнопка для перехода на экран камеры
        val cameraButton = findViewById<Button>(R.id.cameraButton)
        cameraButton.setOnClickListener {
            // Запускаем CameraActivity
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }

        // Кнопка для перехода на экран списка
        val listButton = findViewById<Button>(R.id.listButton)
        listButton.setOnClickListener {
            // Запускаем ListActivity
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }
}
