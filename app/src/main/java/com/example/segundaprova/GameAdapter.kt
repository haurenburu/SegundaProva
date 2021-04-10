package com.example.segundaprova

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

class GameAdapter : RecyclerView.Adapter<GameViewHolder>() {
    var games: List<Game> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.game_inflater, parent, false)
        return GameViewHolder(v)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val selectedGame = games[position]
        holder.gameName.text = selectedGame.name
    }

    override fun getItemCount(): Int {
        return games.size
    }
}

class GameViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val gameName = v.findViewById<TextView>(R.id.nameGame)
}