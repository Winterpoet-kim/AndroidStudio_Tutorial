package com.example.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.viewpager.databinding.FragTuesdayBinding
import com.example.viewpager.databinding.FragWednesdayBinding

class FragWednesday : Fragment() {
    private  lateinit var binding : FragWednesdayBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragWednesdayBinding.inflate(inflater, container, false)
        return binding.root
    }
}

