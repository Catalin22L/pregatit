package com.globant.pretatit.data.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.globant.pretatit.data.TaskEntity
import com.globant.pretatit.data.database.TaskDao


@Database(
    entities = [TaskEntity::class], version = 1
)
@TypeConverters(TaskPriorityConverter::class)
abstract class PregatitDatabase : RoomDatabase() {

    abstract fun getTaskDAO(): TaskDao
    abstract fun deleteTask(toEntity: TaskEntity)
}