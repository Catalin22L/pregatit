package com.globant.pretatit.data

import com.globant.pretatit.data.database.TaskEntity
import com.globant.pretatit.presentation.Task

// Transformă un obiect de Bază de Date (Entity) într-un obiect de UI (Domain)
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

// Transformă un obiect de UI (Domain) într-un obiect de Bază de Date (Entity)
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