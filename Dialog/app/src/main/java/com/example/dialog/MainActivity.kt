package com.example.dialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDialog.setOnClickListener {
            val ad = AlertDialog.Builder(this)
            ad.setIcon(R.drawable.ic_launcher_foreground)
            ad.setTitle("제목")
            ad.setMessage("겨울시인은 존잘입니까?")

            // 다이알로그 안에 에딧텍스트를 추가
            var ed : EditText = EditText(this)
            ad.setView(ed)

            ad.setPositiveButton("확인") { dialog, _ ->
                var str:String = ed.text.toString()
                binding.tvResult.text = str
                Toast.makeText(this, "PositiveButton", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            ad.setNegativeButton("취소"){ dialog,_ ->
                Toast.makeText(this, "NegativeButton", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            ad.show()
        }
    }
}