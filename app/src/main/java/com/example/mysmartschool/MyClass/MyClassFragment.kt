package com.example.mysmartschool.MyClass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mysmartschool.R
import com.example.mysmartschooll.DataAdapter_myteacher
import com.example.mysmartschooll.Entity_myteacher
import kotlinx.android.synthetic.main.myclass.*

class MyClassFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.myclass, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initComponent()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initComponent() {
        val data: ArrayList<Entity_myteacher> = ArrayList()
        data.add(Entity_myteacher("Bu Offy"))
        data.add(Entity_myteacher(("Bu Arne")))
        data.add(Entity_myteacher("Bu Dewi"))
        data.add(Entity_myteacher(("Bpk Ikin")))
        data.add(Entity_myteacher(("Bpk Lukman")))
        recycler_container_myteacher_activity_main1.layoutManager = GridLayoutManager(this.context, 2)
        recycler_container_myteacher_activity_main1.adapter = DataAdapter_myteacher(this.context!!, data)
    }
}