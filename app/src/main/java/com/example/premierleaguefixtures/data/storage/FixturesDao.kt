package com.example.premierleaguefixtures.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.premierleaguefixtures.data.model.ApiFixtures
import kotlinx.coroutines.flow.Flow

@Dao
interface FixturesDao {
    @Query("SELECT * from fixtures_table")
    fun getAllFixtures(): Flow<List<ApiFixtures>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFixtures(fixtures: List<ApiFixtures>)

    @Query("DELETE FROM fixtures_table")
    suspend fun deleteAllFixtures()
}