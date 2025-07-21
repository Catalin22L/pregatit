package com.globant.pretatit.data.datasource.mapper

import com.globant.pretatit.data.TaskEntity
import com.globant.pretatit.data.database.TaskEntity
import com.globant.pretatit.presentation.Task

// Transformă un obiect din Baza de Date (Entity) într-un obiect de UI (Task)
fun TaskEntity.toDomain(): Task {
    return Task(
        id = this.id,
        title = this.title,
        description = this.description,
        taskPriority = this.taskPriority,
        category = this.category,
        isDone = this.isDone
    )
}

// Transformă un obiect de UI (Task) într-un obiect pentru Baza de Date (Entity)
fun Task.toEntity(): TaskEntity {
    return TaskEntity(
        id = this.id,
        title = this.title,
        description = this.description,
        taskPriority = this.taskPriority,
        category = this.category,
        isDone = this.isDone
    )
}