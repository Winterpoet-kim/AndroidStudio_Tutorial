package com.example.shared

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shared.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding:ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO : 저장된 데이터를 로드
        loadData()
    }

    private fun saveData() {
        val pref = getSharedPreferences("pref",0)
        val edit = pref.edit() // 수정 모드
        edit.putString("name", binding.etHello.text.toString())  // 1번째 인자는 키, 2번째 인자는 실제 담아둘 값
        edit.apply() // 저장완료
    }

    private fun loadData() {
        val pref = getSharedPreferences("pref",0)
        binding.etHello.setText(pref.getString("name","")) // 1번째 인자는 키, 2번째 인자는 데이터가 존재하지 않을경우의 값
    }

    //TODO : 해당 액티비티가 종료되는 시점이 다가올때 호출
    override fun onDestroy() {
        super.onDestroy()

        //TODO : 저장된 데이터를 저장
        saveData()
    }



}