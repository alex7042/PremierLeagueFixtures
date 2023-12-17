package com.example.premierleaguefixtures.screens.fixtures_screen

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.premierleaguefixtures.screens.model.Fixtures

class FixturesAdapter : ListAdapter<Fixtures, FixturesViewHolder>(createDifUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixturesViewHolder {
        return FixturesViewHolder(parent)
    }

    override fun onBindViewHolder(holder: FixturesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onBindViewHolder(
        holder: FixturesViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position)
        } else {
            holder.bindScore(getItem(position))
        }
    }
}

fun createDifUtil(): DiffUtil.ItemCallback<Fixtures> {
    return object : DiffUtil.ItemCallback<Fixtures>() {
        override fun areItemsTheSame(oldItem: Fixtures, newItem: Fixtures): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Fixtures, newItem: Fixtures): Boolean {
            return oldItem == newItem
        }

        override fun getChangePayload(oldItem: Fixtures, newItem: Fixtures): Any? {
            return if (oldItem.copy(
                    homeTeamScore = newItem.homeTeamScore,
                    awayTeamScore = newItem.awayTeamScore,
                ) == newItem
            ) 1 else null
        }
    }
}