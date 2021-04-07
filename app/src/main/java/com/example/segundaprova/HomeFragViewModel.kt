package com.example.segundaprova

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class HomeFragViewModel(application: Application) : AndroidViewModel(application) {
    var list: LiveData<List<Game>>

    init {
        val db:AppDatabase by lazy {
            Room.databaseBuilder(application.applicationContext,
            AppDatabase::class.java, "games.sqlite")
                .build()
        }
        list = FindAllAsync(db).execute().get()
    }

    @SuppressLint("StaticFieldLeak")
    private inner class FindAllAsync(var dba:AppDatabase) : AsyncTask<Unit, Unit, LiveData<List<Game>>>() {
        override fun doInBackground(vararg params: Unit?): LiveData<List<Game>> {
            return dba.gameDao().listAll()
        }
    }
}