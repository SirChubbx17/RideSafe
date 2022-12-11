package com.example.ridesafe.adventure

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.ridesafe.R
import com.example.ridesafe.databinding.RsFragAdventureBinding
import com.example.ridesafe.databinding.RsFragLoginBinding

class AdventureScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val binding = DataBindingUtil.inflate<RsFragAdventureBinding>(
            inflater,
            R.layout.rs_frag_adventure,
            container,
            false
        )
        return inflater.inflate(R.layout.rs_frag_adventure, container, false)

        binding.btnGo.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_adventureFragment)
        }


    }



}