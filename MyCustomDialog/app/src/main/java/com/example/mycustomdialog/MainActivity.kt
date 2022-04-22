package com.example.mycustomdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.mycustomdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MyCustomDialogInterface {

    private var mBinding : ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dialogButton.setOnClickListener {
            val myCustomDialog = MyCustomDialog(this, this)
            myCustomDialog.show()
        }
    }
    // Subscribe Button Clicked
    override fun onSubscribeBtnClicked() {
        Toast.makeText(this, "구독버튼 클릭", Toast.LENGTH_SHORT).show()
    }

    // Like Button Clicked
    override fun onLikedBtnClicked() {
        Toast.makeText(this, "좋아요버튼 클릭", Toast.LENGTH_SHORT).show()
    }
}
