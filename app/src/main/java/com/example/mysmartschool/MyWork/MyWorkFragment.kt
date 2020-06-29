package com.example.mysmartschool.MyWork

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mysmartschool.R
import kotlinx.android.synthetic.main.fragment_mywork.*

class MyWorkFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_mywork, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent()
    }

    private fun initComponent() {
        var dataset = arrayOf(
            "Bahasa Inggris | Text Explanation",
            "Bahasa Indonesia | Text Puisi",
            "Bahasa Inggris | Text Observation",
            "Matematika | Vektor",
            "PBO | Monopoli"
        )
        mywork_tugas_list.adapter = TugasAdapter(this.context!!, dataset)
        mywork_nilai_list.adapter = QuickNilaiAdapter(this.context!!)
        mywork_nilai_list.layoutManager = GridLayoutManager(this.context, 5, GridLayoutManager.VERTICAL, false);
//        mywork_tugas_list.addItemDecoration(DividerItemDecoration(this.context,DividerItemDecoration.VERTICAL))
    }
}