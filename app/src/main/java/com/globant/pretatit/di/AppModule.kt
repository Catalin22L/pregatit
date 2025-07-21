package com.globant.pretatit.di

import android.content.Context
import androidx.room.Room
import com.globant.pretatit.data.database.TaskDao
import com.globant.pretatit.data.datasource.local.db.PregatitDatabase
import com.globant.pretatit.data.repository.TaskRepositoryImpl
import com.globant.pretatit.domain.repos.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): PregatitDatabase {
        return Room.databaseBuilder(
            context,
            PregatitDatabase::class.java,
            "tasks.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTaskDao(database: PregatitDatabase): TaskDao {
        return database.getTaskDAO()
    }

    @Provides
    @Singleton
    fun provideTaskRepository(taskDao: TaskDao): TaskRepository {
        return TaskRepositoryImpl(taskDao as PregatitDatabase)
    }
}