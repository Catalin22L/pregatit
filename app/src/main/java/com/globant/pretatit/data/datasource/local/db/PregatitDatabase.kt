package com.globant.pretatit.data.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.globant.pretatit.data.database.TaskDao
// Asigură-te că aceste importuri sunt EXACT așa:
import com.globant.pretatit.data.database.TaskEntity
import com.globant.pretatit.data.database.converters.TaskPriorityConverter

@Database(
    entities = [TaskEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TaskPriorityConverter::class)
abstract class PregatitDatabase : RoomDatabase() {
    abstract fun getTaskDAO(): TaskDao
}