package com.example.mysmartschool.SmartVideo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mysmartschool.InfoActivity
import com.example.mysmartschool.R
import com.example.mysmartschool.SmartVideoActivity
import com.example.mysmartschooll.DataAdapter_smartinfo
import kotlinx.android.synthetic.main.activity_info.view.*
import java.security.AccessControlContext

class DataAdapter_smartvideo(
    private val context: Context,
    private val data: ArrayList<Entity_smartvideo>
) : RecyclerView.Adapter<DataAdapter_smartvideo.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameViewJudulSmartVideo: TextView = itemView.findViewById(R.id.tv_judul)
        private val nameViewMapelSmartVideo: TextView = itemView.findViewById(R.id.tv_mapel)

        fun bindItem(data: Entity_smartvideo) {
            nameViewJudulSmartVideo.text = data.judul
            nameViewMapelSmartVideo.text = data.mapel
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataAdapter_smartvideo.ViewHolder {
        return DataAdapter_smartvideo.ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.recycler_item_smartvideo,
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: DataAdapter_smartvideo.ViewHolder, position: Int) {

        holder.bindItem(data[position])

//        holder.itemView.setOnClickListener(View.OnClickListener {
//            val intent: Intent = Intent(context, SmartVideoActivity::class.java)
//            intent.putExtra("juduls", data.get(position).judul)
//            intent.putExtra("mapels", data.get(position).mapel)
//
//            context.startActivity(intent)
//        })
    }

    override fun getItemCount(): Int {
        return data.size
    }
}