package com.example.segundaprova

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room

class CadastraFragment : Fragment() {
    lateinit var viewmodel: CadastraFragViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewmodel = ViewModelProvider(this).get(CadastraFragViewModel::class.java)
        return inflater.inflate(R.layout.fragment_cadastra, container, false)
    }
}