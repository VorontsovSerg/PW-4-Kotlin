package com.example.pw4kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class ListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Получаем данные из файла и передаем в адаптер
        val file = File(getExternalFilesDir(null), "photos/date.txt")

        // Проверяем, существует ли файл и читаем данные
        val data = if (file.exists()) {
            file.readLines().sortedDescending() // Читаем строки и сортируем по убыванию
        } else {
            listOf("Нет фотографий") // Если файла нет, отображаем сообщение
        }

        // Создаем адаптер и устанавливаем его в RecyclerView
        adapter = MyAdapter(data)
        recyclerView.adapter = adapter
    }
}
