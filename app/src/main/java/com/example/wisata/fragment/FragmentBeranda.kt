package com.example.wisata.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridView
import com.example.wisata.R
import com.example.wisata.activity.ActivityWisataAlam
import com.example.wisata.activity.ActivityWisataKuliner
import com.example.wisata.activity.ActivityWisataPantai
import com.example.wisata.activity.ActivityWisataSejarah

class FragmentBeranda : Fragment() {
    lateinit var gvWisataAlam: GridView
    lateinit var gvWisataPantai: GridView
    lateinit var gvWisataSejarah: GridView
    lateinit var gvWisataKuliner: GridView
//    ?internal var btnPeta: Button
 internal lateinit var view: View

    fun FragmentBeranda() {
        //lkkl
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_beranda, container, false)

        activity!!.title = "Selamat Datang"

        SetupView()

        gvWisataAlam.setOnClickListener {
            val intent = Intent(activity, ActivityWisataAlam::class.java)
            startActivity(intent)
        }
        gvWisataPantai.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, ActivityWisataPantai::class.java)
            startActivity(intent)
        })
        gvWisataSejarah.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, ActivityWisataSejarah::class.java)
            startActivity(intent)
        })
        gvWisataKuliner.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, ActivityWisataKuliner::class.java)
            startActivity(intent)
        })
//        btnPeta.setOnClickListener {
//            val intent = Intent(activity, PetaActivity::class.java)
//            startActivity(intent)
//        }


        return view
    }

    fun SetupView() {
        gvWisataAlam = view.findViewById<View>(R.id.gvWisataAlam) as GridView
        gvWisataPantai = view.findViewById<View>(R.id.gvWisataPantai) as GridView
        gvWisataSejarah = view.findViewById<View>(R.id.gvWisataSejarah) as GridView
        gvWisataKuliner = view.findViewById<View>(R.id.gvWisataKuliner) as GridView
//        btnPeta = view.findViewById<View>(R.id.btnPeta) as Button
    }

}
