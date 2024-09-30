package com.example.taskmaster

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taskmaster.databinding.ActivityCreateTaskBinding
import com.example.taskmaster.Task
import com.example.taskmaster.ApiService
import com.example.taskmaster.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class CreateTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateTaskBinding
    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize view binding
        binding = ActivityCreateTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Retrofit
        apiService = RetrofitClientInstance.retrofitInstance.create(ApiService::class.java)

        // Set up Save button click listener
        binding.saveButton.setOnClickListener {
            // Gather input data
            val title = binding.titleEditText.text.toString()
            val description = binding.descriptionEditText.text.toString()
            val dueDate = binding.dueDateEditText.text.toString()
            val priority = binding.prioritySpinner.selectedItemPosition

            if (title.isNotEmpty() && description.isNotEmpty() && dueDate.isNotEmpty()) {
                val task = Task(
                    id = UUID.randomUUID().toString(),
                    title = title,
                    description = description,
                    dueDate = dueDate,
                    priority = priority,
                    completed = false
                )

                // Send the task to the server
                createTaskOnServer(task)
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun createTaskOnServer(task: Task) {
        val call = apiService.createTask(task)
        call.enqueue(object : Callback<Task> {
            override fun onResponse(call: Call<Task>, response: Response<Task>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@CreateTaskActivity, "Task Created", Toast.LENGTH_SHORT).show()
                    finish()  // Close the activity after successful creation
                } else {
                    Toast.makeText(this@CreateTaskActivity, "Failed to create task", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Task>, t: Throwable) {
                Toast.makeText(this@CreateTaskActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
