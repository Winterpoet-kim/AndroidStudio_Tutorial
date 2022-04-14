package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.databinding.ListItemBinding

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val profileList = arrayListOf(
            Profile(R.drawable.profile_m, "겨울시인1", 25, "안드로이드 앱 개발자1"),
            Profile(R.drawable.profile_w, "겨울시인2", 26, "안드로이드 앱 개발자2"),
            Profile(R.drawable.profile_m, "겨울시인3", 27, "안드로이드 앱 개발자3"),
            Profile(R.drawable.profile_m, "겨울시인4", 28, "안드로이드 앱 개발자4"),
            Profile(R.drawable.profile_w, "겨울시인5", 29, "안드로이드 앱 개발자5"),
            Profile(R.drawable.profile_w, "겨울시인6", 30, "안드로이드 앱 개발자6"),
            Profile(R.drawable.profile_m, "겨울시인7", 31, "안드로이드 앱 개발자7"),
            Profile(R.drawable.profile_w, "겨울시인8", 32, "안드로이드 앱 개발자8"),
            Profile(R.drawable.profile_m, "겨울시인9", 33, "안드로이드 앱 개발자9"),
            Profile(R.drawable.profile_w, "겨울시인10", 34, "안드로이드 앱 개발자10")
        )

        binding.rvProfile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvProfile.setHasFixedSize(true)

        binding.rvProfile.adapter = ProfileAdapter(profileList)
    }
}