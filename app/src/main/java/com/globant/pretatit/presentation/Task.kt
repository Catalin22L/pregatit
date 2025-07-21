package com.globant.pretatit.presentation

import android.os.Parcelable
import com.globant.pretatit.domain.model.TaskPriority // <-- IMPORT has been updated
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(
    val id: Int = 0,
    val title: String,
    val description: String,
    val taskPriority: TaskPriority, // This now correctly refers to the class in the domain layer
    val category: String = "General",
    val isDone: Boolean = false
) : Parcelable

// The old enum class that was here has been DELETED.