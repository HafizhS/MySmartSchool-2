package com.example.mysmartschooll

import android.app.Activity
import android.app.Dialog
import android.app.PendingIntent
import android.app.assist.AssistContent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.mysmartschool.InfoActivity
import com.example.mysmartschool.R
import com.google.android.gms.common.internal.ConnectionErrorMessages
import com.google.firebase.database.FirebaseDatabase
import java.util.ArrayList
import java.util.zip.Inflater

class DataAdapter_smartinfo(private var contex: Context, private val data: ArrayList<Entity_smartinfo>) :
    RecyclerView.Adapter<DataAdapter_smartinfo.ViewHolder>() {

//    fun DataAdapter_smartinfo(contex: Context, data: List<Entity_smartinfo>) {
//        this.contex = contex
//
//    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameViewPengirimSmartinfo: TextView = itemView.findViewById(R.id.tv_pengirim)
        private val nameViewTanggalSmartinfo: TextView = itemView.findViewById(R.id.tv_tanggal)
        private val nameViewJudulSmartinfo: TextView = itemView.findViewById(R.id.tv_judul)
        private val nameViewAboutSmartinfo: TextView = itemView.findViewById(R.id.tv_about)
        val btnChange: Button = itemView.findViewById(R.id.btn_change)


        fun bindItem(data: Entity_smartinfo) {
//            imageViewMyteacher.text = data.box
            nameViewPengirimSmartinfo.text = data.pengirim
            nameViewTanggalSmartinfo.text = data.date
            nameViewJudulSmartinfo.text = data.judul
            nameViewAboutSmartinfo.text = data.about
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return DataAdapter_smartinfo.ViewHolder(
            LayoutInflater.from(contex).inflate(
                R.layout.recycler_item_smart_info,
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItem(data[position])

        holder.itemView.setOnClickListener(View.OnClickListener {
            val bundle = Bundle()
            bundle.putString("judul",data.get(position).judul)
            bundle.putString("tgl",data.get(position).date)
            bundle.putString("dari",data.get(position).pengirim)
            bundle.putString("rinci",data.get(position).about)

            val intent = Intent(contex,InfoActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            if (intent != null) {
                intent.putExtras(bundle)
            }
            contex.startActivity(intent)


        })

        holder.btnChange.setOnClickListener(){

            val dialogBuilder = AlertDialog.Builder(this.contex)
            val dialogView = LayoutInflater.from(contex).inflate(R.layout.layout_tambah_info, null)
            dialogBuilder.setView(dialogView)

            dialogBuilder.setTitle("Tambah Info")
            val alertDialog: AlertDialog = dialogBuilder.create()
            alertDialog.show()

        }



    }



    override fun getItemCount(): Int {
        return data.size
    }










    private fun deleteKelas(idInfo: String) {
        val dInfo = FirebaseDatabase.getInstance().getReference("info").child(idInfo)
        dInfo.removeValue()

        Toast.makeText(contex, "Berhasil Hapus Data", Toast.LENGTH_SHORT).show()

    }




}

