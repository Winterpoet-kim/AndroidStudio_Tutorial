package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bottomnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavi.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_airplane -> {
                    setFrag(0)
                }
                R.id.action_airport_shuttle -> {
                    setFrag(1)
                }
                R.id.action_bluetooth -> {
                    setFrag(2)
                }
                R.id.action_call -> {
                    setFrag(3)
                }
                R.id.action_run -> {
                    setFrag(4)
                }
                else -> {
                    false
                }
            }
        }
        setFrag(0)
    }

    private fun setFrag(fragNum : Int) : Boolean {
        val ft = supportFragmentManager.beginTransaction()

        when(fragNum){
            0 -> {
                ft.replace(R.id.main_frame, Frag1()).commit()
            }
            1 -> {
                ft.replace(R.id.main_frame, Frag2()).commit()
            }
            2 -> {
                ft.replace(R.id.main_frame, Frag3()).commit()
            }
            3 -> {
                ft.replace(R.id.main_frame, Frag4()).commit()
            }
            4 -> {
                ft.replace(R.id.main_frame, Frag5()).commit()
            }
        }
        return true
    }
}