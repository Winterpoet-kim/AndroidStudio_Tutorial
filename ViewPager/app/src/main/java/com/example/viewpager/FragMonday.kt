package com.example.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.viewpager.databinding.FragMondayBinding

class FragMonday : Fragment() {
    private  lateinit var binding : FragMondayBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragMondayBinding.inflate(inflater, container, false)
        return binding.root
    }
}

