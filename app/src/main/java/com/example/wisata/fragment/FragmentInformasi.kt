package com.example.wisata.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wisata.R

class FragmentInformasi : Fragment() {

    fun FragmentInformasi() {
        //
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_informasi, container, false)

        activity!!.title = "Informasi"

        return view
    }

}
