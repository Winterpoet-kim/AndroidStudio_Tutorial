package com.example.recyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ListItemBinding


class ProfileAdapter(val profileList:ArrayList<Profile>):RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>()
{
    val TAG: String = "로그"
    private var mBindingAdaper : ListItemBinding? = null
    private val bindingAdpter get() = mBindingAdaper!!

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {
        mBindingAdaper = ListItemBinding.inflate(LayoutInflater.from(parent.context))
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        Log.d(TAG, "ProfileAdapter - onCreateViewHolder() called")

        return CustomViewHolder(bindingAdpter.root).apply {
            itemView.setOnClickListener {
                val curPos:Int = this.adapterPosition
                val profile:Profile = profileList[curPos]
                Toast.makeText(parent.context, "이름:${profile.name}, 직업:${profile.job}", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        Log.d(TAG, "ProfileAdapter - onBindViewHolder() called")
        holder.gender.setImageResource(profileList[position].gender)
        holder.name.text = profileList[position].name
        holder.age.text = profileList[position].age.toString()
        holder.job.text = profileList[position].job

    }

    override fun getItemCount(): Int {
        Log.d(TAG, "ProfileAdapter - getItemCount() called")
        return profileList.size
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        private var mBindingAdaper : ListItemBinding? = null
//        private val bindingAdpter get() = mBindingAdaper!!


        val gender = itemView.findViewById<ImageView>(R.id.iv_profile)
        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val age = itemView.findViewById<TextView>(R.id.tv_age)
        val job = itemView.findViewById<TextView>(R.id.tv_job)

//        val gender = bindingAdpter.ivProfile
//        val name = bindingAdpter.tvName
//        val age = bindingAdpter.tvAge
//        val job = bindingAdpter.tvJob

    }
}
