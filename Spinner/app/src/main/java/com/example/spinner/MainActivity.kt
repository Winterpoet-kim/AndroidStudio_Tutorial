package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    
    private var mBinding : ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val testList = resources.getStringArray(R.array.testList)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, testList)
        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    binding.tvResult.text = parent.getItemAtPosition(position).toString()
                }
                override fun onNothingSelected(parent: AdapterView<*>) {

                }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}

