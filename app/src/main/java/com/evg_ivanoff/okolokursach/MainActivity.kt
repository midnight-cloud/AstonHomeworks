package com.evg_ivanoff.okolokursach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.evg_ivanoff.okolokursach.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = ContactListFragment().apply {
            arguments = Bundle().apply {
                putBoolean("ORI", landscapeMode())
            }
        }
        if (!landscapeMode()) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.contactListFrag, fragment)
                .commit()
        } else {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.contactListFrag, fragment)
                .replace(R.id.contactInfoFrag, ContactInfoFragment())
                .commit()
        }
    }

    fun landscapeMode(): Boolean{
        val info_fragment = binding.contactInfoFrag
        return info_fragment != null
    }

}