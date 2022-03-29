package com.example.myflexiblefragment_rinno

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class Fragment_Dua : Fragment() {

    lateinit var tvName : TextView
    lateinit var tvDesc : TextView
    lateinit var btnDua: Button

    var desc: String? = null

    companion object {
        var EXTRA_NAME = "extra_name"
        var EXTRA_DESC = "extra_desc"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__dua, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvName = view.findViewById(R.id.tv_name)
        tvDesc = view.findViewById(R.id.tv_desc)
        btnDua= view.findViewById(R.id.btn_satu)
        val btnDua: Button = view.findViewById(R.id.btn_satu)
        val fragmentSatu =Fragment_Satu()
        btnDua.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_container, fragmentSatu,Fragment_Satu::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()

            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (savedInstanceState != null) {
            val description = savedInstanceState.getString(EXTRA_DESC)
            desc = description
        }
            val name = arguments?.getString(EXTRA_NAME)
            tvName.text = name
            tvDesc.text = desc
        }

    }