package com.example.segundaprova

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class HomeFragViewModel(application: Application) : AndroidViewModel(application) {
    var list: LiveData<List<Game>>

    init {
        val db:AppDatabase by lazy {
            Room.databaseBuilder(application.applicationContext,
            AppDatabase::class.java, "games.sqlite")
                .allowMainThreadQueries()
                .build()
        }
        list = db.gameDao().listAll()
    }
}