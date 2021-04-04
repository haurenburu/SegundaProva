package com.example.segundaprova

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.segundaprova.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var viewmodel: HomeFragViewModel


    private val db: AppDatabase by lazy {
        Room.databaseBuilder(parentFragment?.context!!, AppDatabase::class.java, "games.sqlite")
            .allowMainThreadQueries()
            .build()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewmodel = ViewModelProvider(this).get(HomeFragViewModel::class.java)

        val adapter = GameAdapter()
        adapter.games = db.gameDao().listAll()
        val layout = LinearLayoutManager(parentFragment?.context!!, LinearLayoutManager.VERTICAL, false)

        binding.recyclerGameList.adapter = adapter
        binding.recyclerGameList.layoutManager = layout

        return binding.root
    }
}