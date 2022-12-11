package com.example.ridesafe

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.ridesafe.databinding.RsFragHomeBinding

class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<RsFragHomeBinding>(
            inflater,
            R.layout.rs_frag_home,
            container,
            false
        )
        binding.btnStart.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_adventureFragment)
        }

        binding.bottomNav.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.homeId -> {replaceFragment(Home(), it.title.toString())}
                R.id.historyId -> {replaceFragment(History(), it.title.toString())}
                //R.id.help -> { replaceFragment(FAQFragment(), it.title.toString()) }
            }
            true
        }

        setHasOptionsMenu(true)
        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment, title: String){
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }

}