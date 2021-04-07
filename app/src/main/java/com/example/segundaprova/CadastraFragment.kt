package com.example.segundaprova

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.segundaprova.databinding.FragmentCadastraBinding

class CadastraFragment : Fragment() {
    lateinit var viewmodel: CadastraFragViewModel
    lateinit var binding: FragmentCadastraBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastra, container, false)
        viewmodel = ViewModelProvider(this).get(CadastraFragViewModel::class.java)

        binding.editTextName.addTextChangedListener {
            viewmodel.name = binding.editTextName.text.toString()
        }

        binding.editTextDirector.addTextChangedListener {
            viewmodel.director = binding.editTextDirector.text.toString()
        }
        binding.editTextDeveloper.addTextChangedListener {
            viewmodel.developer = binding.editTextDeveloper.text.toString()
        }
        binding.editTextPublisher.addTextChangedListener {
            viewmodel.publisher = binding.editTextPublisher.text.toString()
        }
        binding.editTextReleaseYear.addTextChangedListener {
            viewmodel.releaseYear = binding.editTextReleaseYear.text.toString().toInt()
        }
        binding.editTextRating.addTextChangedListener {
            viewmodel.releaseYear = binding.editTextRating.text.toString().toInt()
        }

        binding.button.setOnClickListener {
            viewmodel.createGame()
//            val g = Game(
//                viewmodel.name,
//                viewmodel.director,
//                viewmodel.developer,
//                viewmodel.publisher,
//                viewmodel.releaseYear,
//                viewmodel.rating
//            )
        }

        return binding.root
    }
}