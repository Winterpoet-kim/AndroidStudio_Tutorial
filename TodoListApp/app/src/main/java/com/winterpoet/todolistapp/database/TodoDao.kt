package com.winterpoet.todolistapp.database

import androidx.room.*
import com.winterpoet.todolistapp.model.TodoInfo

@Dao
interface TodoDao {

    // Database table 에 삽입(추가)
    @Insert
    fun insertTodoData(todoInfo: TodoInfo)

    // Database table 에 기존에 존재하는 데이터를 수정
    @Update
    fun updateTodoData(todoInfo: TodoInfo)

    // Database table 에 기존에 존재하는 데이터를 삭제
    @Delete
    fun deleteTodoData(todoInfo: TodoInfo)

    // Database table 에 전체 데이터를 가지고 옴. (조회)
    @Query("SELECT * FROM TodoInfo ORDER BY todoDate")
    fun getAllReadData():List<TodoInfo>


}