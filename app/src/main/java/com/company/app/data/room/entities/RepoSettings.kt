package com.company.app.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * User local settings for a GitHub repo
 */
@Entity(tableName = "repo_settings")
data class RepoSettings(

    @PrimaryKey(autoGenerate = true)
    var settingsId: Int,

    @ColumnInfo(name = "repo_id")
    val repoId: Int,

    @ColumnInfo(name = "is_Hidden", defaultValue = "false")
    val isHidden: Boolean

)