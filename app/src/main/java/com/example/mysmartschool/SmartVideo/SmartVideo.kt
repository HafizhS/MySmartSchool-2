package com.example.mysmartschool.SmartVideo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mysmartschool.R
import com.example.mysmartschooll.DataAdapter_smartinfo
import com.example.mysmartschooll.Entity_smartinfo
import kotlinx.android.synthetic.main.fragment_smart_info.*
import kotlinx.android.synthetic.main.fragment_smart_video.*

class SmartVideo: Fragment() {

    private lateinit var recyclerView: RecyclerView

    private var listItem_smartvideo: ArrayList<Entity_smartvideo>? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_smart_video, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        signFun()
        getAllUser()
        showRecyleView()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun signFun() {
        recyclerView = rv_video
        listItem_smartvideo = ArrayList()
    }

    private fun getAllUser() {
        listItem_smartvideo?.add(Entity_smartvideo("tutorial recycler view ", "PWPB"))
        listItem_smartvideo?.add(Entity_smartvideo("OOP", "PBO"))
        listItem_smartvideo?.add(Entity_smartvideo("Fungsi Turunan", "MATEMATIKA"))
        listItem_smartvideo?.add(Entity_smartvideo("Aisatsu", "JEPANG"))
        listItem_smartvideo?.add(Entity_smartvideo("LARAVEL", "PWPB"))
        listItem_smartvideo?.add(Entity_smartvideo("Cara Mencari Uang", "PKK"))
    }

    private fun showRecyleView() {
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = DataAdapter_smartvideo(this.context!!, listItem_smartvideo!!)
    }
}