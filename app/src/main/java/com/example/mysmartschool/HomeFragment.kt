package com.example.mysmartschool

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mysmartschool.MyClass.MyClassFragment
import com.example.mysmartschooll.Profile
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false);
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent()
    }

    private fun initComponent() {
        home_recyclerview.adapter = HomeAdapter(this.context!!)
        home_recyclerview.layoutManager = LinearLayoutManager(this.context!!)
        home_recyclerview.addItemDecoration(DividerItemDecoration(this.context!!, DividerItemDecoration.VERTICAL))

        home_btnProfile.setOnClickListener {
            fragmentManager!!.beginTransaction().add(R.id.main_frame, Profile()).addToBackStack("null").commit()
        }

        home_btnMyclass.setOnClickListener {
            fragmentManager!!.beginTransaction().add(R.id.main_frame, MyClassFragment()).addToBackStack("null").commit()
        }
    }
}