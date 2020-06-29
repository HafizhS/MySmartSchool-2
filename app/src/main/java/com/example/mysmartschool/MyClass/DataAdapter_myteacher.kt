package com.example.mysmartschooll

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.mysmartschool.MyClass.MyClassFragment
import com.example.mysmartschool.R
import com.example.mysmartschool.TeacherActivity
import kotlinx.android.synthetic.main.recycler_item_myteacher.view.*

class DataAdapter_myteacher(private val context: Context, private val data: ArrayList<Entity_myteacher>) :
    RecyclerView.Adapter<DataAdapter_myteacher.ViewHolder>() {




    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //        private val imageViewMyteacher: TextView = itemView.findViewById(R.id.tv_image_recycler)
        private val nameViewMyteacher: TextView = itemView.findViewById(R.id.tv_name_recycler)



        fun bindItem(data: Entity_myteacher) {
//            imageViewMyteacher.text = data.box
            nameViewMyteacher.text = data.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter_myteacher.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_item_myteacher, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: DataAdapter_myteacher.ViewHolder, position: Int) {

        holder.itemView.tv_name_recycler.text = data[position].name.toString()
        holder.itemView.tv_name_recycler.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, TeacherActivity::class.java)
            intent.putExtra("name",data.get(position).name)
            context.startActivity(intent)
        })

//        holder.bindItem(data[position])
//        holder.itemView.setOnClickListener{
//            context.toast(data[position].name+"Clicked!")
//        }
    }
}