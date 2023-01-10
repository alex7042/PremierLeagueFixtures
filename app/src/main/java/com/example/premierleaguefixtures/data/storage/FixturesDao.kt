package com.example.premierleaguefixtures.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.premierleaguefixtures.data.model.Fixtures
import kotlinx.coroutines.flow.Flow

@Dao
interface FixturesDao {
    @Query("SELECT * from fixtures_table")
    fun getAllFixtures(): Flow<List<Fixtures>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFixtures(fixtures: List<Fixtures>)

    @Query("DELETE FROM fixtures_table")
    suspend fun deleteAllFixtures()
}