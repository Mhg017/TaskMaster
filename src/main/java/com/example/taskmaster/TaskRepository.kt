package com.example.taskmaster

//Offline Sync: When the device reconnects to the internet,
//implement logic to sync data from the local RoomDB to the remote API.

class TaskRepository(private val taskDao: TaskDao) {
    fun getAllTasks() = taskDao.getAllTasks()
    fun insertTask(task: Task) = taskDao.insertTask(task)
    fun deleteTask(task: Task) = taskDao.deleteTask(task)
}
