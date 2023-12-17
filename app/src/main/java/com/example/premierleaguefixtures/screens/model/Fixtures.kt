package com.example.premierleaguefixtures.screens.model

data class Fixtures(
    val id: Int,
    val awayTeam: String,
    val awayTeamScore: Int,
    val dateUtc: String,
    val homeTeam: String,
    val homeTeamScore: Int,
    val location: String,
    val matchNumber: String,
    val roundNumber: String
)
