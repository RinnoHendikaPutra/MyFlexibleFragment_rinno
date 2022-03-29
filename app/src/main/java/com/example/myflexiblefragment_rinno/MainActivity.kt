package com.example.myflexiblefragment_rinno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentSatu = Fragment_Satu()
        val fragment:Fragment? =
        supportFragmentManager.findFragmentByTag(fragmentSatu::class.java.simpleName)

        if (fragment !is Fragment_Satu) {
            supportFragmentManager.beginTransaction().add(R.id.frame_container, fragmentSatu,Fragment_Satu::class.java.simpleName)
                .commit()
        }
    }
}