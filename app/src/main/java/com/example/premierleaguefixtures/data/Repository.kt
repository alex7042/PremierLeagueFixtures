package com.example.premierleaguefixtures.data

import androidx.room.withTransaction
import com.example.premierleaguefixtures.data.model.Fixtures
import com.example.premierleaguefixtures.data.remote.ApiService
import com.example.premierleaguefixtures.data.storage.FixturesDatabase
import com.example.premierleaguefixtures.utilities.networkBoundResource
import retrofit2.Response

class Repository(
    private val api: ApiService,
    private val database: FixturesDatabase
) {
    private val dao = database.fixturesDao()

    fun getResults() = networkBoundResource(
        query = {
            dao.getAllFixtures()
        },
        fetch = {
            api.getFixtures()
        },
        saveFetchResult = {
            database.withTransaction {
                dao.deleteAllFixtures()
                dao.insertFixtures(mapResponseToList(it))
            }
        }
    )

    private fun mapResponseToList(entity: Response<List<Fixtures>>): List<Fixtures> {
        return entity.body()!!
    }
}