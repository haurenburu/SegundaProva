package com.example.segundaprova

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.segundaprova.databinding.FragmentAlteraBinding

class AlteraFragment : Fragment() {
    val args: AlteraFragmentArgs by navArgs()
    lateinit var viewmodel : AlteraFragmentViewModel
    lateinit var binding: FragmentAlteraBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)
        viewmodel = ViewModelProvider(this).get(AlteraFragmentViewModel::class.java)

        viewmodel.getGame(args.gameid)

        binding.editTextNameAl.setText(viewmodel.name)
        binding.editTextDirectorAl.setText(viewmodel.director)
        binding.editTextPublisherAl.setText(viewmodel.publisher)
        binding.editTextDeveloperAl.setText(viewmodel.developer)
        binding.editTextReleaseYearAl.setText(viewmodel.releaseYear)
        binding.editTextRatingAl.setText(viewmodel.rating)

        return binding.root
    }

}