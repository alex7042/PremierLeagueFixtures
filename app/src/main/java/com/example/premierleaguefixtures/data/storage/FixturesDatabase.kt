package com.example.premierleaguefixtures.data.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.premierleaguefixtures.data.model.ApiFixtures

@Database(entities = [ApiFixtures::class], version = 1)
abstract class FixturesDatabase : RoomDatabase() {
    abstract fun fixturesDao(): FixturesDao

    companion object {
        fun createDatabase(context: Context): FixturesDatabase {
            return Room.databaseBuilder(context, FixturesDatabase::class.java, "fixtures_db")
                .build()
        }
    }
}