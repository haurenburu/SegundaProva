package com.example.segundaprova

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs

class AlteraFragment : Fragment() {
    val args: AlteraFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("teste", args.gameid.toString())
        return inflater.inflate(R.layout.fragment_altera, container, false)
    }
}