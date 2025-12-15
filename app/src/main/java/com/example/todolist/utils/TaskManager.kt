package com.example.todolist.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.todolist.models.Task
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TaskManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private val gson = Gson()

    companion object {
        private const val PREFS_NAME = "TodoListPrefs"
        private const val KEY_TASKS = "tasks"

        @Volatile
        private var instance: TaskManager? = null

        fun getInstance(context: Context): TaskManager {
            return instance ?: synchronized(this) {
                instance ?: TaskManager(context.applicationContext).also { instance = it }
            }
        }
    }

    fun getAllTasks(): List<Task> {
        val tasksJson = sharedPreferences.getString(KEY_TASKS, null) ?: return emptyList()
        val type = object : TypeToken<List<Task>>() {}.type
        return gson.fromJson(tasksJson, type)
    }

    fun getPendingTasks(): List<Task> {
        return getAllTasks().filter { !it.isCompleted }
    }

    fun getCompletedTasks(): List<Task> {
        return getAllTasks().filter { it.isCompleted }
    }

    fun addTask(task: Task) {
        val tasks = getAllTasks().toMutableList()
        tasks.add(task)
        saveTasks(tasks)
    }

    fun updateTask(updatedTask: Task) {
        val tasks = getAllTasks().toMutableList()
        val index = tasks.indexOfFirst { it.id == updatedTask.id }
        if (index != -1) {
            tasks[index] = updatedTask
            saveTasks(tasks)
        }
    }

    fun deleteTask(taskId: String) {
        val tasks = getAllTasks().toMutableList()
        tasks.removeAll { it.id == taskId }
        saveTasks(tasks)
    }

    fun getTaskById(taskId: String): Task? {
        return getAllTasks().find { it.id == taskId }
    }

    fun markTaskAsCompleted(taskId: String) {
        val task = getTaskById(taskId)
        task?.let {
            it.isCompleted = true
            updateTask(it)
        }
    }

    private fun saveTasks(tasks: List<Task>) {
        val tasksJson = gson.toJson(tasks)
        sharedPreferences.edit().putString(KEY_TASKS, tasksJson).apply()
    }
}
