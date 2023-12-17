package com.example.premierleaguefixtures.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity (tableName = "fixtures_table")
data class ApiFixtures(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo
    @SerializedName("AwayTeam") val awayTeam: String,
    @SerializedName("AwayTeamScore") val awayTeamScore: Int,
    @SerializedName("DateUtc") val dateUtc: String,
    @SerializedName("HomeTeam") val homeTeam: String,
    @SerializedName("HomeTeamScore") val homeTeamScore: Int,
    @SerializedName("Location") val location: String,
    @SerializedName("MatchNumber") val matchNumber: Int,
    @SerializedName("RoundNumber") val roundNumber: Int
)