package com.globant.pretatit.data.database // <-- Aceasta este calea critică!

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.globant.pretatit.domain.model.TaskPriority

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val taskPriority: TaskPriority,
    val category: String,
    val isDone: Boolean
)