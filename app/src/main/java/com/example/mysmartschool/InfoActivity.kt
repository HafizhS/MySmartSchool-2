package com.example.mysmartschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val judul: TextView = findViewById(R.id.tv_judul)
        val pengirim: TextView = findViewById(R.id.tv_pengirim)
        val date: TextView = findViewById(R.id.tv_tanggal)
        val about: TextView = findViewById(R.id.tv_about)


        if (intent.extras != null){
            val bundle = intent.extras

            if (bundle != null) {
                judul.setText(bundle.getString("judul"))
                pengirim.setText(bundle.getString("dari"))
                date.setText(bundle.getString("tgl"))
                about.setText(bundle.getString("rinci"))
            }
        } else {

                judul.setText(intent.getStringExtra("judul"))
                pengirim.setText(intent.getStringExtra("dari"))
                date.setText(intent.getStringExtra("tgl"))
                about.setText(intent.getStringExtra("rinci"))

        }



//        val judulBerita: String = intent.getStringExtra("judul")
//        val pengirimBerita: String = intent.getStringExtra("dari")
//        val dateBerita: String = intent.getStringExtra("tgl")
//        val aboutBerita: String = intent.getStringExtra("rinci")
//
//
//        judul.setText(judulBerita)
//        pengirim.setText(pengirimBerita)
//        date.setText(dateBerita)
//        about.setText(aboutBerita)


    }
}
