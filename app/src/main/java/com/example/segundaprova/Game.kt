package com.example.segundaprova

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game_table")
data class Game(
    var name: String,
    var director: String,
    var developer: String,
    var publisher: String,
    var releaseYear: Int,
    var rating: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}