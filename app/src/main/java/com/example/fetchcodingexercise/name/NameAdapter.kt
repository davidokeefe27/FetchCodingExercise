package com.example.fetchcodingexercise.name

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchcodingexercise.R

class NameAdapter(
    private val data: List<DataUIModel>
): RecyclerView.Adapter<NameAdapter.ViewHolder>() {
    inner class ViewHolder(dataItem: View): RecyclerView.ViewHolder(dataItem){
        val name: TextView = dataItem.findViewById(R.id.name)
        val listId: TextView = dataItem.findViewById(R.id.list_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.name.text = item.name
        holder.listId.text = holder.itemView.context.resources.getString(R.string.list_id_string, item.listId)
    }


}