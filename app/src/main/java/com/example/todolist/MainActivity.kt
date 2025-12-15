package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.utils.TaskManager
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var taskManager: TaskManager
    private lateinit var tvPendingCount: TextView
    private lateinit var tvCompletedCount: TextView
    private lateinit var btnViewAllTasks: Button
    private lateinit var fabAddTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskManager = TaskManager.getInstance(this)

        initViews()
        setupListeners()
    }

    override fun onResume() {
        super.onResume()
        updateTaskCounts()
    }

    private fun initViews() {
        tvPendingCount = findViewById(R.id.tvPendingCount)
        tvCompletedCount = findViewById(R.id.tvCompletedCount)
        btnViewAllTasks = findViewById(R.id.btnViewAllTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun setupListeners() {
        fabAddTask.setOnClickListener {
            startActivity(Intent(this, AddTaskActivity::class.java))
        }

        btnViewAllTasks.setOnClickListener {
            startActivity(Intent(this, TaskListActivity::class.java))
        }
    }

    private fun updateTaskCounts() {
        val pendingCount = taskManager.getPendingTasks().size
        val completedCount = taskManager.getCompletedTasks().size

        tvPendingCount.text = pendingCount.toString()
        tvCompletedCount.text = completedCount.toString()
    }
}
