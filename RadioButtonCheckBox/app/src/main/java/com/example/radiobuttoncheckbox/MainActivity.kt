package com.example.radiobuttoncheckbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.radiobuttoncheckbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding:ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // RadioButton
        val radioGp = binding.radioGp
        val radioMan = binding.radioMan
        val radioWoman = binding.radioWoman
        val radioBtn = binding.RadioResult

        // CheckBox
        val checkRed = binding.checkRed
        val checkblue = binding.checkBlue
        val checkGreen = binding.checkGreen
        val getTextBtn = binding.getTextBtn
        val resultText = binding.checkResult


        radioGp.setOnCheckedChangeListener{ radioGroup, i ->
            if(i == radioMan.id){
                Toast.makeText(this, "남자", Toast.LENGTH_SHORT).show()
            }else if(i == radioWoman.id){
                Toast.makeText(this, "여자", Toast.LENGTH_SHORT).show()
            }
        }
        radioBtn.setOnClickListener {
            if(radioMan.isChecked){
                Toast.makeText(this, "남자가 선택되었습니다.", Toast.LENGTH_SHORT).show()
            }else if(radioWoman.isChecked){
                Toast.makeText(this, "여자가 선택되었습니다.", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "남자 또는 여자를 선택하세요", Toast.LENGTH_SHORT).show()
            }
        }

        getTextBtn.setOnClickListener {
            var resultString = ""
            if(checkRed.isChecked){
                resultString += checkRed.text
            }
            if(checkblue.isChecked){
                resultString += checkblue.text
            }
            if(checkGreen.isChecked){
                resultString += checkGreen.text
            }
            resultText.text = resultString
        }
    }
}