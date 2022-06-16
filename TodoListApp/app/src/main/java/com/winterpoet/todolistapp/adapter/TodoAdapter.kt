package com.winterpoet.todolistapp.adapter

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.winterpoet.todolistapp.database.TodoDatabase
import com.winterpoet.todolistapp.databinding.DialogEditBinding
import com.winterpoet.todolistapp.databinding.ListItemTodoBinding
import com.winterpoet.todolistapp.model.TodoInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class TodoAdapter: RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    private var lstTodo:ArrayList<TodoInfo> = ArrayList()
    private lateinit var roomDatabase: TodoDatabase

    fun addListItem(todoItem: TodoInfo){
        lstTodo.add(0, todoItem)
    }

    // inner : private var lstTodo 변수에 접근하기 위해서 inner class로 선언해야함.
    inner class TodoViewHolder(private val binding: ListItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(todoItem:TodoInfo) {
            // 리스트뷰 데이터를 UI에 연동
            binding.tvContent.setText(todoItem.todoContent)
            binding.tvDate.setText(todoItem.todoDate)

            // 리스트 삭제 버튼 클릭 연동
            binding.btnRemove.setOnClickListener {
                // 쓰레기통 이미지 클릭시 내부 로직 수행
                AlertDialog.Builder(binding.root.context)
                    .setTitle("[Warning!]")
                    .setMessage("삭제되면 데이터는 복구되지 않습니다!\n삭제하시겠습니까?")
                    .setPositiveButton("삭제", DialogInterface.OnClickListener { dialogInterface, i ->

                        CoroutineScope(Dispatchers.IO).launch {
                            val innerLstTodo = roomDatabase.todoDao().getAllReadData()
                            for (item in innerLstTodo) {
                                if (item.todoContent == todoItem.todoContent && item.todoDate == todoItem.todoDate) {
                                    // 데이터베이스 데이터 삭제
                                    roomDatabase.todoDao().deleteTodoData(item)
                                }
                            }

                            // UI 리스트 데이터 삭제
                            lstTodo.remove(todoItem)
                            (binding.root.context as Activity).runOnUiThread{
                                notifyDataSetChanged()  // 리스트 새로고침
                                Toast.makeText(binding.root.context, "삭제되었습니다.", Toast.LENGTH_SHORT).show()
                            }
                        }
                    })
                    .setNegativeButton("취소", DialogInterface.OnClickListener { dialogInterface, i ->

                    })
                    .show()
            }

            // 리스트 수정 클릭 연동
            binding.root.setOnClickListener {
                val bindingDialog = DialogEditBinding.inflate(LayoutInflater.from(binding.root.context), binding.root, false)

                bindingDialog.etMemo.setText(todoItem.todoContent)

                AlertDialog.Builder(binding.root.context)
                    .setTitle("To-Do 수정하기")
                    .setView(bindingDialog.root)
                    .setPositiveButton("수정하기", DialogInterface.OnClickListener { dialogInterface, i ->

                        CoroutineScope(Dispatchers.IO).launch {
                            val innerLstTodo = roomDatabase.todoDao().getAllReadData()
                            for (item in innerLstTodo) {
                                if (item.todoContent == todoItem.todoContent && item.todoDate == todoItem.todoDate) {
                                    // 데이터베이스 데이터 수정
                                    item.todoContent = bindingDialog.etMemo.text.toString()
                                    item.todoDate = SimpleDateFormat("yyyy-MM-dd HH:mm").format(Date())
                                    roomDatabase.todoDao().updateTodoData(item)
                                }
                            }

                            // UI 리스트 데이터 수정
                            todoItem.todoContent = bindingDialog.etMemo.text.toString()
                            todoItem.todoDate = SimpleDateFormat("yyyy-MM-dd HH:mm").format(Date())

                            // array list 수정
                            lstTodo.set(adapterPosition, todoItem)

                            (binding.root.context as Activity).runOnUiThread{
                                notifyDataSetChanged()  // 리스트 새로고침
                            }
                        }
                    })
                    .setNegativeButton("취소", DialogInterface.OnClickListener { dialogInterface, i ->

                    })
                    .show()
            }
        }
   }

    // 뷰홀더 생성 (각 리스트 아이템 1개씩 구성될 때마다 이 메소드가 호출됨)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.TodoViewHolder {

        val binding = ListItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        // 룸 데이터베이스 초기화
        roomDatabase = TodoDatabase.getInstance(binding.root.context)!!

        return TodoViewHolder(binding)
    }

    // 뷰홀더 바인딩 (결합) 이루어질 때 해줘야 될 처리들을 구현.
    override fun onBindViewHolder(holder: TodoAdapter.TodoViewHolder, position: Int) {
        holder.bind(lstTodo[position])
    }

    // 리스트 총 갯수
    override fun getItemCount(): Int {
        return lstTodo.size
    }
}