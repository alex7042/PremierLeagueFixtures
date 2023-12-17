package com.example.premierleaguefixtures.data

import androidx.room.withTransaction
import com.example.premierleaguefixtures.data.mappers.FixturesMapper
import com.example.premierleaguefixtures.data.model.ApiFixtures
import com.example.premierleaguefixtures.data.remote.ApiService
import com.example.premierleaguefixtures.data.storage.FixturesDatabase
import com.example.premierleaguefixtures.utilities.networkBoundResource
import kotlinx.coroutines.flow.map
import retrofit2.Response

class Repository(
    private val api: ApiService,
    private val database: FixturesDatabase,
    private val mapper: FixturesMapper,
) {
    private val dao = database.fixturesDao()

    fun getResults() = networkBoundResource(
        query = {
            dao.getAllFixtures().map { flow -> flow.map { mapper.fromApiToDomain(it) } }
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

    private fun mapResponseToList(entity: Response<List<ApiFixtures>>): List<ApiFixtures> {
        return entity.body()!!
    }
}