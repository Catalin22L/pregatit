package com.globant.pretatit.data.database.converters // Verifică dacă pachetul este corect

import androidx.room.TypeConverter
import com.globant.pretatit.domain.model.TaskPriority // <-- IMPORT NOU

class TaskPriorityConverter {
    @TypeConverter
    fun fromTaskPriority(priority: TaskPriority): String {
        return priority.name
    }

    @TypeConverter
    fun toTaskPriority(priority: String): TaskPriority {
        // Folosește funcția companion object din enum pentru a asigura consistența
        return TaskPriority.getValueByName(priority)
    }
}