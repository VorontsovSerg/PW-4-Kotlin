package com.example.pw4kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Адаптер для отображения списка дат фотографий
class MyAdapter(private var data: List<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    // ViewHolder описывает структуру каждого элемента списка
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.itemTextView)
    }

    // Этот метод создает новые элементы View (вызывается LayoutManager-ом)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Создаем новый View, используя макет элемента списка (list_item.xml)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    // Этот метод связывает данные с View (вызывается LayoutManager-ом)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Получаем элемент данных по его позиции и присваиваем текст элементу
        val item = data[position]
        holder.textView.text = item
    }

    // Возвращает количество элементов в списке
    override fun getItemCount(): Int {
        return data.size
    }

    // Метод для обновления данных в адаптере
    fun updateData(newData: List<String>) {
        data = newData
        // Сообщаем RecyclerView, что данные изменились, и нужно обновить представление
        notifyDataSetChanged()
    }
}
