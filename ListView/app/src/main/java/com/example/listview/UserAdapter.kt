package com.example.listview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.listview.databinding.ListItemUserBinding

class UserAdapter (val context:Context, val UserList:ArrayList<User>):BaseAdapter()
{
    val TAG: String = "로그"
    private var mBinding: ListItemUserBinding? = null
    private val binding get() = mBinding!!

    override fun getView(position: Int, covertView: View?, parent: ViewGroup?): View {
        //val view:View = LayoutInflater.from(context).inflate(R.layout.list_item_user, null)

        mBinding = ListItemUserBinding.inflate(LayoutInflater.from(context))

        val profile = binding.ivProfile
        val name = binding.tvName
        val age = binding.tvAge
        val greet = binding.tvGreet

        val user = UserList[position]

        Log.d(TAG, "UserAdapter - getView() name:${user.name}")

        profile.setImageResource(user.profile)
        name.text = user.name
        age.text = user.age
        greet.text = user.greet

        return mBinding!!.root

    }

    override fun getItem(position: Int): Any {
        Log.d(TAG, "UserAdapter - getItem() called")
        return UserList[position]
    }
    override fun getCount(): Int {
        Log.d(TAG, "UserAdapter - getCount() size:${UserList.size} ")
        return UserList.size
    }
    override fun getItemId(position: Int): Long {
        return 0
    }



}