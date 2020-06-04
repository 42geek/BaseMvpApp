package com.company.app.data.room

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.company.app.data.room.entities.RepoSettings
import io.reactivex.Observable

@Dao
interface RepoSettingsDao {

    @Query("SELECT * FROM repo_settings")
    fun getAllRepoSettings(): Observable<List<RepoSettings>>

    @Insert
    fun insertRepoSettings(repoSettings: RepoSettings)

    @Update(onConflict = REPLACE)
    fun updateRepoSettings(repoSettings: RepoSettings)

    @Delete
    fun deleteRepoSettings(repoSettings: RepoSettings)

}