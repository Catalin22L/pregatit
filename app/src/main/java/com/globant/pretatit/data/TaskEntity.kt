package com.globant.pretatit.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.globant.pretatit.domain.model.TaskPriority // <-- IMPORT NOU

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val taskPriority: TaskPriority, // Acum folosește modelul din domain
    val category: String,
    val isDone: Boolean
)