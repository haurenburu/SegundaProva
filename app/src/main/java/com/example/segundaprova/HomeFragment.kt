package com.example.segundaprova

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
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

        binding.recyclerGameList.addOnItemTouchListener(
            RecyclerViewClickListener(this.requireContext(),
                binding.recyclerGameList,
                object : RecyclerViewClickListener.onItemClickListener {
                    override fun onItemCLick(v: View, position: Int) {
                        Toast.makeText(context, "click", Toast.LENGTH_SHORT).show()
                    }

                    override fun onItemLongClick(v: View, position: Int) {
                        Navigation.findNavController(v).navigate(
                            HomeFragmentDirections.actionHomeFragmentToAlteraFragment().setGameid(viewmodel.list.value!![position].id)
                        )
                    }
                })
        )
        viewmodel.update()
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.home_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, this.findNavController()) || super.onOptionsItemSelected(item)
    }
}
