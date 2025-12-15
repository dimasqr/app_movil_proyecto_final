package com.example.todolist.models

import java.io.Serializable
import java.util.UUID

data class Task(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val description: String,
    val type: TaskType,
    var isCompleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
) : Serializable

enum class TaskType(val displayName: String) {
    WORK("Trabajo"),
    HOME("Casa"),
    BUSINESS("Negocios");

    companion object {
        fun fromDisplayName(name: String): TaskType {
            return values().find { it.displayName == name } ?: WORK
        }
    }
}
