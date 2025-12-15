package com.example.todolist

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.models.Task
import com.example.todolist.utils.TaskManager

class TaskDetailActivity : AppCompatActivity() {

    private lateinit var taskManager: TaskManager
    private lateinit var tvTaskName: TextView
    private lateinit var tvTaskDescription: TextView
    private lateinit var tvTaskType: TextView
    private lateinit var tvTaskStatus: TextView
    private lateinit var btnMarkCompleted: Button
    private lateinit var btnDeleteTask: Button

    private var currentTask: Task? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.task_detail_title)

        taskManager = TaskManager.getInstance(this)

        initViews()
        loadTaskDetails()
        setupListeners()
    }

    private fun initViews() {
        tvTaskName = findViewById(R.id.tvTaskName)
        tvTaskDescription = findViewById(R.id.tvTaskDescription)
        tvTaskType = findViewById(R.id.tvTaskType)
        tvTaskStatus = findViewById(R.id.tvTaskStatus)
        btnMarkCompleted = findViewById(R.id.btnMarkCompleted)
        btnDeleteTask = findViewById(R.id.btnDeleteTask)
    }

    private fun loadTaskDetails() {
        val taskId = intent.getStringExtra("TASK_ID")
        if (taskId == null) {
            finish()
            return
        }

        currentTask = taskManager.getTaskById(taskId)
        if (currentTask == null) {
            Toast.makeText(this, "Tarea no encontrada", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        displayTaskDetails(currentTask!!)
    }

    private fun displayTaskDetails(task: Task) {
        tvTaskName.text = task.name
        tvTaskDescription.text = task.description
        tvTaskType.text = task.type.displayName

        if (task.isCompleted) {
            tvTaskStatus.text = getString(R.string.status_completed)
            tvTaskStatus.setTextColor(getColor(R.color.green))
            btnMarkCompleted.visibility = View.GONE
        } else {
            tvTaskStatus.text = getString(R.string.status_pending)
            tvTaskStatus.setTextColor(getColor(R.color.orange))
            btnMarkCompleted.visibility = View.VISIBLE
        }
    }

    private fun setupListeners() {
        btnMarkCompleted.setOnClickListener {
            currentTask?.let { task ->
                taskManager.markTaskAsCompleted(task.id)
                Toast.makeText(this, R.string.task_completed, Toast.LENGTH_SHORT).show()
                loadTaskDetails()
            }
        }

        btnDeleteTask.setOnClickListener {
            showDeleteConfirmation()
        }
    }

    private fun showDeleteConfirmation() {
        AlertDialog.Builder(this)
            .setTitle(R.string.delete_task)
            .setMessage("¿Estás seguro de que quieres eliminar esta tarea?")
            .setPositiveButton("Eliminar") { _, _ ->
                deleteTask()
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun deleteTask() {
        currentTask?.let { task ->
            taskManager.deleteTask(task.id)
            Toast.makeText(this, R.string.task_deleted, Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
