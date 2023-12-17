package com.example.premierleaguefixtures.data.mappers

import com.example.premierleaguefixtures.data.model.ApiFixtures
import com.example.premierleaguefixtures.screens.model.Fixtures

class FixturesMapper {

    fun fromApiToDomain(api: ApiFixtures): Fixtures {
        return Fixtures(
            id = api.id,
            awayTeam = api.awayTeam,
            awayTeamScore = api.awayTeamScore,
            dateUtc = api.dateUtc.substring(0, api.dateUtc.length - 4),
            homeTeam = api.homeTeam,
            homeTeamScore = api.homeTeamScore,
            location = api.location,
            matchNumber = api.matchNumber.toString(),
            roundNumber = api.roundNumber.toString()
        )
    }
}