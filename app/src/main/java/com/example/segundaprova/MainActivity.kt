package com.example.segundaprova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room

class MainActivity : AppCompatActivity() {

    private val db: AppDatabase by lazy {
        Room.databaseBuilder(this, AppDatabase::class.java, "games.sqlite")
            .allowMainThreadQueries()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val game1 = Game("nome1", "diretor1", "desenvolvedor1", "editora1", 2020, 2)
//        val game2 = Game("nome2", "diretor2", "desenvolvedor2", "editora2", 2020, 3)
//        val game3 = Game("nome3", "diretor3", "desenvolvedor3", "editora3", 2020, 4)
//        val game4 = Game("nome4", "diretor4", "desenvolvedor4", "editora4", 2020, 5)
//
//        with(db.gameDao()){
//            insert(game1)
//            insert(game2)
//            insert(game3)
//            insert(game4)
//        }

        val gl:MutableList<Game> = db.gameDao().listAll();
        val adapter = GameAdapter()
        adapter.games = gl
    }
}
