package com.winterpoet.todolistapp.Activity

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.winterpoet.todolistapp.adapter.TodoAdapter
import com.winterpoet.todolistapp.database.TodoDatabase
import com.winterpoet.todolistapp.databinding.ActivityListMainBinding
import com.winterpoet.todolistapp.databinding.DialogEditBinding
import com.winterpoet.todolistapp.model.TodoInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class ListMainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityListMainBinding
    private lateinit var todoAdapter:TodoAdapter
    private lateinit var roomDatabase: TodoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Adapter 인스턴스 생성
        todoAdapter = TodoAdapter()

        // 리싸이클러뷰에 어뎁터 Setting
        binding.rvTodo.adapter = todoAdapter

        // 룸 데이터베이스 초기화
        roomDatabase = TodoDatabase.getInstance(applicationContext)!!

        // 전체 데이터 load (비동기적 처리)
        CoroutineScope(Dispatchers.IO).launch {
            val lstTodo = roomDatabase.todoDao().getAllReadData() as ArrayList<TodoInfo>
            for(todoItem in lstTodo){
                todoAdapter.addListItem(todoItem)
            }
            // UI Thread 에서 처리 해야함.
            runOnUiThread {
                todoAdapter.notifyDataSetChanged()
            }
        }

        // 작성하기 버튼 클릭
        binding.btnWrite.setOnClickListener {
            val bindingDialog = DialogEditBinding.inflate(LayoutInflater.from(binding.root.context), binding.root, false)

            AlertDialog.Builder(this)
                .setTitle("To-Do 작성하기")
                .setView(bindingDialog.root)
                .setPositiveButton("작성 완료", DialogInterface.OnClickListener { dialogInterface, i ->
                    val todoItem = TodoInfo()
                    todoItem.todoContent = bindingDialog.etMemo.text.toString()
                    todoItem.todoDate = SimpleDateFormat("yyyy-MM-dd HH:mm").format(Date())
                    todoAdapter.addListItem(todoItem)

                    // Database 에도 todoItem 정보 추가
                    CoroutineScope(Dispatchers.IO).launch {
                        roomDatabase.todoDao().insertTodoData(todoItem)
                        runOnUiThread {
                            todoAdapter.notifyDataSetChanged()  // 리스트 새로고침
                        }
                    }
                })
                .setNegativeButton("취소", DialogInterface.OnClickListener { dialogInterface, i ->

                })
                .show()
        }
    }
}