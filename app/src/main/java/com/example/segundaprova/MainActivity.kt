package com.example.segundaprova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.room.Room

class MainActivity : AppCompatActivity() {

//    private val db: AppDatabase by lazy {
//        Room.databaseBuilder(this, AppDatabase::class.java, "games.sqlite")
//            .allowMainThreadQueries()
//            .build()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.NavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this, R.id.NavHostFragment)
        return navController.navigateUp()
    }
}
