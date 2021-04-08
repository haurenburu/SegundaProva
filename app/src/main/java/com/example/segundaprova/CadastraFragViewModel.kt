package com.example.segundaprova

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room

class CadastraFragViewModel(application: Application) : AndroidViewModel(application) {
    private var dba: AppDatabase

    init {
        val db:AppDatabase by lazy {
            Room.databaseBuilder(application.applicationContext,
                AppDatabase::class.java, "games.sqlite")
                .build()
        }
        dba = db
    }

    var name: String = ""
    var director: String = ""
    var developer: String = ""
    var publisher: String = ""
    var releaseYear: Int = 0
    var rating: Int = 0

    fun createGame() {
        CreateGameAsync().execute().get()
    }

    @SuppressLint("StaticFieldLeak")
    private inner class CreateGameAsync() : AsyncTask<Unit, Unit, Unit>() {
        override fun doInBackground(vararg params: Unit?) {
            val g = Game(
                name,
                director,
                developer,
                publisher,
                releaseYear,
                rating
            )

            dba.gameDao().insert(g)
        }
    }
}