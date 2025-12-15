package com.example.todolist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.models.Task

class TaskAdapter(
    private var tasks: List<Task>,
    private val onTaskClick: (Task) -> Unit,
    private val onCompleteClick: (Task) -> Unit,
    private val onDeleteClick: (Task) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTaskName: TextView = itemView.findViewById(R.id.tvTaskName)
        val tvTaskDescription: TextView = itemView.findViewById(R.id.tvTaskDescription)
        val tvTaskType: TextView = itemView.findViewById(R.id.tvTaskType)
        val btnComplete: Button = itemView.findViewById(R.id.btnComplete)
        val btnDelete: Button = itemView.findViewById(R.id.btnDelete)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onTaskClick(tasks[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]

        holder.tvTaskName.text = task.name
        holder.tvTaskDescription.text = task.description
        holder.tvTaskType.text = task.type.displayName

        // Hide complete button if task is already completed
        if (task.isCompleted) {
            holder.btnComplete.visibility = View.GONE
            holder.tvTaskName.alpha = 0.5f
            holder.tvTaskDescription.alpha = 0.5f
        } else {
            holder.btnComplete.visibility = View.VISIBLE
            holder.tvTaskName.alpha = 1.0f
            holder.tvTaskDescription.alpha = 1.0f
        }

        holder.btnComplete.setOnClickListener {
            onCompleteClick(task)
        }

        holder.btnDelete.setOnClickListener {
            onDeleteClick(task)
        }
    }

    override fun getItemCount(): Int = tasks.size

    fun updateTasks(newTasks: List<Task>) {
        tasks = newTasks
        notifyDataSetChanged()
    }
}
