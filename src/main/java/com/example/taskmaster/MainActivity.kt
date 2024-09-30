package com.example.taskmaster

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskmaster.databinding.ActivityMainBinding
import com.example.taskmaster.Task

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var taskAdapter: TaskAdapter
    private var taskList: MutableList<Task> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize RecyclerView with LinearLayoutManager and Adapter
        setupRecyclerView()

        // Handle Create Task Button click event
        binding.createTaskButton.setOnClickListener {
            val intent = Intent(this, CreateTaskActivity::class.java)
            startActivityForResult(intent, CREATE_TASK_REQUEST_CODE)
        }

        // Example: Set up language change buttons
        binding.btnEnglish.setOnClickListener {
            changeLanguage("en") // English
        }

        binding.btnAfrikaans.setOnClickListener {
            changeLanguage("af") // Afrikaans
        }
    }

    // Function to set up the RecyclerView
    private fun setupRecyclerView() {
        taskAdapter = TaskAdapter(taskList)
        binding.taskRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.taskRecyclerView.adapter = taskAdapter
    }

    // Handle the result from CreateTaskActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CREATE_TASK_REQUEST_CODE && resultCode == RESULT_OK) {
            val newTask = data?.getParcelableExtra<Task>("newTask")
            if (newTask != null) {
                taskList.add(newTask)
                taskAdapter.notifyDataSetChanged()
            }
        }
    }

    companion object {
        const val CREATE_TASK_REQUEST_CODE = 1
    }

    private fun changeLanguage(languageCode: String) {
        // Save the selected language to shared preferences
        val sharedPreferences = getSharedPreferences("Settings", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("Language", languageCode)
        editor.apply()

        // Update the locale and restart the activity
        LocaleHelper.setLocale(this, languageCode)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun attachBaseContext(newBase: Context?) {
        val sharedPreferences = newBase?.getSharedPreferences("Settings", MODE_PRIVATE)
        val language = sharedPreferences?.getString("Language", "en") // Default to English
        super.attachBaseContext(language?.let { LocaleHelper.setLocale(newBase, it) })
    }

}
