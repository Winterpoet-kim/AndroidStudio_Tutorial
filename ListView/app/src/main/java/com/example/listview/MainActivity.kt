package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val TAG: String = "로그"
    private var mBinding:ActivityMainBinding? = null
    private val binding get() = mBinding!!

    var UserList = arrayListOf<User>(
        User(R.drawable.android_basic, "겨울시인1", "40", "안녕하세요"),
        User(R.drawable.android_basic, "겨울시인2", "39", "안녕하세요"),
        User(R.drawable.android_basic, "겨울시인3", "38", "안녕하세요"),
        User(R.drawable.android_basic, "겨울시인4", "37", "안녕하세요"),
        User(R.drawable.android_basic, "겨울시인5", "36", "안녕하세요"),
        User(R.drawable.android_basic, "겨울시인6", "35", "안녕하세요"),
        User(R.drawable.android_basic, "겨울시인7", "34", "안녕하세요")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "MainActivity - onCreate() called (1)")

//        val item = arrayOf("사과","배","딸기","키위","수박")
//        // context : 한 액티비티의 모든 정보를 담고있음.
//        binding.listView.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, item)

        val Adapter = UserAdapter(this, UserList)
        binding.listView.adapter = Adapter

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener {
            parent,
            view,
            position,
            id -> val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()


        }

    }
}