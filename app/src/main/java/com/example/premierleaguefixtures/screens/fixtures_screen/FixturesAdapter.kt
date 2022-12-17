package com.example.premierleaguefixtures.screens.fixtures_screen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.premierleaguefixtures.R
import com.example.premierleaguefixtures.model.FixturesDataItem
import java.util.*

class FixturesAdapter: RecyclerView.Adapter<FixturesAdapter.FixturesViewHolder>() {

    private var fixturesList = emptyList<FixturesDataItem>()

    inner class FixturesViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val matchNumber: TextView = view.findViewById(R.id.matchNumber)
        val roundNumber: TextView= view.findViewById(R.id.roundNumber)
        val dateUtc: TextView= view.findViewById(R.id.dateUtc)
        val location: TextView= view.findViewById(R.id.location)
        val homeTeam: TextView= view.findViewById(R.id.homeTeam)
        val awayTeam: TextView= view.findViewById(R.id.awayTeam)
//        val group: TextView= view.findViewById(R.id.group) // смысла в нем нет, во всех матчах это значение = null
        val homeTeamScore: TextView= view.findViewById(R.id.homeTeamScore)
        val awayTeamScore: TextView= view.findViewById(R.id.awayTeamScore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixturesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_fixture_item, parent, false)
        return FixturesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FixturesViewHolder, position: Int) {
        holder.matchNumber.text = fixturesList[position].MatchNumber.toString()
        holder.roundNumber.text = fixturesList[position].RoundNumber.toString()
        holder.dateUtc.text = fixturesList[position].DateUtc
        holder.location.text = fixturesList[position].Location
        holder.homeTeam.text = fixturesList[position].HomeTeam
        holder.awayTeam.text = fixturesList[position].AwayTeam
//        holder.group.text = fixturesList[position].Group.toString()
        holder.homeTeamScore.text = fixturesList[position].HomeTeamScore.toString()
        holder.awayTeamScore.text = fixturesList[position].AwayTeamScore.toString()
    }

    override fun getItemCount(): Int = fixturesList.size


    @SuppressLint("NotifyDataSetChanged")
    fun setFixturesList(list: List<FixturesDataItem>){
        fixturesList = list
        notifyDataSetChanged()

    }
}