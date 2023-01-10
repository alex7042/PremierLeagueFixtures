package com.example.premierleaguefixtures.data.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.premierleaguefixtures.data.model.Fixtures

@Database(entities = [Fixtures::class], version = 1)
abstract class FixturesDatabase : RoomDatabase() {
    abstract fun fixturesDao(): FixturesDao

    companion object {
        private var INSTANCE: FixturesDatabase? = null
        fun createDatabase(context: Context): Boolean {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context, FixturesDatabase::class.java, "fixtures_db")
                            .build()
                    return true
                }
            }
            return false
        }

        fun getDatabase(): FixturesDatabase? = INSTANCE
    }
}