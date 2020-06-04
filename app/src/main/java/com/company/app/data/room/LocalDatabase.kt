package com.company.app.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.company.app.data.room.entities.RepoSettings

@Database(entities = [RepoSettings::class], version = 1)
abstract class LocalDatabase: RoomDatabase() {

    abstract fun repoSettingsDao(): RepoSettingsDao

}