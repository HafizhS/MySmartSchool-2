package com.example.mysmartschool.MyWork

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.mysmartschool.R
import kotlinx.android.synthetic.main.mywork_tugas_item.view.*

class TugasAdapter(private val context: Context, private val data: Array<String>) :
    RecyclerView.Adapter<TugasAdapter.ViewHolder>() {

    private val MAX_ITEM = 6

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tugas_view_title.text = data[position]

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.mywork_tugas_item, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
