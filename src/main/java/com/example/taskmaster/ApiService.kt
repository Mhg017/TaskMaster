package com.example.taskmaster

import com.example.taskmaster.Task
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("tasks")
    fun createTask(@Body task: Task): Call<Task>
}
