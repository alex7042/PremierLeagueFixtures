package com.example.premierleaguefixtures.screens.fixtures_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.premierleaguefixtures.R
import com.example.premierleaguefixtures.databinding.RvFixtureItemBinding
import com.example.premierleaguefixtures.screens.model.Fixtures

class FixturesViewHolder(
    parent: ViewGroup,
) : RecyclerView.ViewHolder(parent.inflate(R.layout.rv_fixture_item)) {

    private val binding: RvFixtureItemBinding by lazy { RvFixtureItemBinding.bind(itemView) }

    fun bindScore(item: Fixtures) = with(binding) {
        homeTeamScore.text = item.homeTeamScore.toString()
        awayTeamScore.text = item.awayTeamScore.toString()
    }

    fun bind(item: Fixtures) = with(binding) {
        matchNumber.text = item.matchNumber
        roundNumber.text = item.roundNumber
        dateUtc.text = item.dateUtc
        location.text = item.location
        homeTeam.text = item.homeTeam
        awayTeam.text = item.awayTeam

    }
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}