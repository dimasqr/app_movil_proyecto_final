package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.adapters.TaskAdapter
import com.example.todolist.models.Task
import com.example.todolist.utils.TaskManager

class TaskListActivity : AppCompatActivity() {

    private lateinit var taskManager: TaskManager
    private lateinit var rvTasks: RecyclerView
    private lateinit var tvNoTasks: TextView
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.task_list_title)

        taskManager = TaskManager.getInstance(this)

        initViews()
        setupRecyclerView()
        loadTasks()
    }

    private fun initViews() {
        rvTasks = findViewById(R.id.rvTasks)
        tvNoTasks = findViewById(R.id.tvNoTasks)
    }

    private fun setupRecyclerView() {
        taskAdapter = TaskAdapter(
            tasks = emptyList(),
            onTaskClick = { task ->
                openTaskDetail(task)
            },
            onCompleteClick = { task ->
                markTaskAsCompleted(task)
            },
            onDeleteClick = { task ->
                showDeleteConfirmation(task)
            }
        )

        rvTasks.apply {
            layoutManager = LinearLayoutManager(this@TaskListActivity)
            adapter = taskAdapter
        }
    }

    private fun loadTasks() {
        val tasks = taskManager.getAllTasks()
        if (tasks.isEmpty()) {
            rvTasks.visibility = View.GONE
            tvNoTasks.visibility = View.VISIBLE
        } else {
            rvTasks.visibility = View.VISIBLE
            tvNoTasks.visibility = View.GONE
            taskAdapter.updateTasks(tasks)
        }
    }

    private fun openTaskDetail(task: Task) {
        val intent = Intent(this, TaskDetailActivity::class.java)
        intent.putExtra("TASK_ID", task.id)
        startActivity(intent)
    }

    private fun markTaskAsCompleted(task: Task) {
        taskManager.markTaskAsCompleted(task.id)
        Toast.makeText(this, R.string.task_completed, Toast.LENGTH_SHORT).show()
        loadTasks()
    }

    private fun showDeleteConfirmation(task: Task) {
        AlertDialog.Builder(this)
            .setTitle(R.string.delete_task)
            .setMessage("¿Estás seguro de que quieres eliminar esta tarea?")
            .setPositiveButton("Eliminar") { _, _ ->
                deleteTask(task)
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun deleteTask(task: Task) {
        taskManager.deleteTask(task.id)
        Toast.makeText(this, R.string.task_deleted, Toast.LENGTH_SHORT).show()
        loadTasks()
    }

    override fun onResume() {
        super.onResume()
        loadTasks()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
