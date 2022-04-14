package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment1:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // frag1.xml과 연결 (main 에서의 setContentView 과 같은 역할)
        val view = inflater.inflate(R.layout.frag1, container, false)

        return view
    }
}