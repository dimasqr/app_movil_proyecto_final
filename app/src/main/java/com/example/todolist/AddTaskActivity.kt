package com.example.todolist

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.models.Task
import com.example.todolist.models.TaskType
import com.example.todolist.utils.TaskManager
import com.google.android.material.textfield.TextInputEditText

class AddTaskActivity : AppCompatActivity() {

    private lateinit var taskManager: TaskManager
    private lateinit var etTaskName: TextInputEditText
    private lateinit var etTaskDescription: TextInputEditText
    private lateinit var rgTaskType: RadioGroup
    private lateinit var rbWork: RadioButton
    private lateinit var rbHome: RadioButton
    private lateinit var rbBusiness: RadioButton
    private lateinit var btnSaveTask: Button
    private lateinit var btnCancel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.add_task_title)

        taskManager = TaskManager.getInstance(this)

        initViews()
        setupListeners()
    }

    private fun initViews() {
        etTaskName = findViewById(R.id.etTaskName)
        etTaskDescription = findViewById(R.id.etTaskDescription)
        rgTaskType = findViewById(R.id.rgTaskType)
        rbWork = findViewById(R.id.rbWork)
        rbHome = findViewById(R.id.rbHome)
        rbBusiness = findViewById(R.id.rbBusiness)
        btnSaveTask = findViewById(R.id.btnSaveTask)
        btnCancel = findViewById(R.id.btnCancel)
    }

    private fun setupListeners() {
        btnSaveTask.setOnClickListener {
            saveTask()
        }

        btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun saveTask() {
        val name = etTaskName.text.toString().trim()
        val description = etTaskDescription.text.toString().trim()

        if (name.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, R.string.fill_all_fields, Toast.LENGTH_SHORT).show()
            return
        }

        val taskType = when (rgTaskType.checkedRadioButtonId) {
            R.id.rbWork -> TaskType.WORK
            R.id.rbHome -> TaskType.HOME
            R.id.rbBusiness -> TaskType.BUSINESS
            else -> TaskType.WORK
        }

        val task = Task(
            name = name,
            description = description,
            type = taskType
        )

        taskManager.addTask(task)
        Toast.makeText(this, R.string.task_added, Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
