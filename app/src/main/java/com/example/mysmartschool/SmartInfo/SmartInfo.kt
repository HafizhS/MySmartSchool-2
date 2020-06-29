package com.example.mysmartschooll

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mysmartschool.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_smart_info.*

class SmartInfo : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private var listItem_smartinfo: ArrayList<Entity_smartinfo>? = null

    internal lateinit var databaseReference: DatabaseReference


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_smart_info, container, false)


        val fab: FloatingActionButton = view.findViewById(R.id.fab)

        databaseReference = FirebaseDatabase.getInstance().getReference("Info")


        fab.setOnClickListener {
            showDialogAdd()
        }





        return view


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        signFun()
//        getAllUser()
//        showRecyleView()
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onStart() {
        super.onStart()

        recyclerView = rv_info
        listItem_smartinfo = ArrayList()


        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listItem_smartinfo?.clear()

                for (InfoSnapShot in dataSnapshot.children) {
                    val info = InfoSnapShot.getValue(Entity_smartinfo::class.java)
                    if (info != null) {
                        listItem_smartinfo?.add(info)

                    }
                }

//                val Adapter = listItem_smartinfo?.let {
//                    DataAdapter_smartinfo(activity!!.applicationContext,
//                        it
//                    )
//                }
                recyclerView.layoutManager = LinearLayoutManager(activity!!.applicationContext)
                recyclerView.adapter =
                    DataAdapter_smartinfo(activity!!.applicationContext, listItem_smartinfo!!)


            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })

    }

//    private fun signFun() {
//        recyclerView = rv_info
//        listItem_smartinfo = ArrayList()
//    }

//    private fun getAllUser() {
//        listItem_smartinfo?.add(Entity_smartinfo("sad", "20-02-2019", "WeB", "web tutor"))
//        listItem_smartinfo?.add(Entity_smartinfo("das", "20-08-2020", "apk", "apk tutor"))
//        listItem_smartinfo?.add(Entity_smartinfo("asd", "21-08-109", "android", "android tutor"))
//        listItem_smartinfo?.add(Entity_smartinfo("qwe", "08-90-2019", "ios", "ios tutor"))
//        listItem_smartinfo?.add(Entity_smartinfo("eqwe", "12-10-2019", "netbeans", "netbeans tutor"))
//        listItem_smartinfo?.add(Entity_smartinfo("weq", "01-10-2019", "project", "project tutor"))
//    }

//    private fun showRecyleView() {
//        recyclerView.layoutManager = LinearLayoutManager(this.context)
//        recyclerView.adapter = DataAdapter_smartinfo(this.context!!, listItem_smartinfo!!)
//    }


    fun showDialogAdd() {
        val dialogBuilder = AlertDialog.Builder(this.context!!)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.layout_tambah_info, null)
        dialogBuilder.setView(dialogView)


        val etKirim: EditText = dialogView.findViewById(R.id.et_kirim)
        val etJudul: EditText = dialogView.findViewById(R.id.et_judul)
        val etDate: EditText = dialogView.findViewById(R.id.et_date)
        val etAbout: EditText = dialogView.findViewById(R.id.et_about)
        val tambahInfo: Button = dialogView.findViewById(R.id.tambahInfo)


        dialogBuilder.setTitle("Tambah Info")
        val alertDialog: AlertDialog = dialogBuilder.create()
        alertDialog.show()

        tambahInfo.setOnClickListener {

            val pengirim: String = etKirim.text.toString()
            val penjudul: String = etJudul.text.toString()
            val tanggal: String = etDate.text.toString()
            val perinci: String = etAbout.text.toString()

            val idDude: String? = databaseReference.push().key


            val Entity_smartinfo = Entity_smartinfo(idDude, pengirim, penjudul, tanggal, perinci)
            if (idDude != null) {
                databaseReference.child(idDude).setValue(Entity_smartinfo)

                Toast.makeText(context, "Data Berhasil Ditambahkan", Toast.LENGTH_LONG).show()

                alertDialog.dismiss()
//            }


            }


        }


    }
}


