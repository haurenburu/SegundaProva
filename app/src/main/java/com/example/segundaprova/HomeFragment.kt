package com.example.segundaprova

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.segundaprova.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var viewmodel: HomeFragViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewmodel = ViewModelProvider(this).get(HomeFragViewModel::class.java)

        val adapter = GameAdapter()
        binding.recyclerGameList.adapter = adapter

        viewmodel.list.observe(viewLifecycleOwner, {
            adapter.games = it
            adapter.notifyDataSetChanged()
        })

        setHasOptionsMenu(true)

        val layout = LinearLayoutManager(parentFragment?.requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerGameList.layoutManager = layout

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, this.findNavController()) || super.onOptionsItemSelected(item)
    }
}