package com.example.segundaprova

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room

class AlteraFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private var dba: AppDatabase
    private lateinit var game: Game

    init {
        val db:AppDatabase by lazy {
            Room.databaseBuilder(application.applicationContext,
                AppDatabase::class.java, "games.sqlite")
                .build()
        }
        dba = db
    }

    var id: Int = 0
    var name: String = ""
    var director: String = ""
    var developer: String = ""
    var publisher: String = ""
    var releaseYear: Int = 0
    var rating: Int = 0

    fun getGame(id: Int) {
        var game = GetGameAsync(id).execute().get()

        this.id = game.id
        this.name = game.name
        this.director = game.director
        this.developer = game.developer
        this.publisher = game.publisher
        this.releaseYear = game.releaseYear
        this.rating = game.rating
    }

    @SuppressLint("StaticFieldLeak")
    private inner class UpdateGameAsync() : AsyncTask<Unit, Unit, Unit>() {
        override fun doInBackground(vararg params: Unit?) {
            val g = Game(
                name,
                director,
                developer,
                publisher,
                releaseYear,
                rating
            )

            g.id = id

            dba.gameDao().update(g)
        }
    }

    @SuppressLint("StaticFieldLeak")
    private inner class GetGameAsync(var id: Int) : AsyncTask<Unit, Unit, Game>() {
        override fun doInBackground(vararg params: Unit?): Game {
            return dba.gameDao().findById(id)
        }
    }
}