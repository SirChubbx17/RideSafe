package com.example.ridesafe.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.ridesafe.R
import com.example.ridesafe.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater,R.layout.fragment_login,container,false)
        binding.btnLogin.setOnClickListener { view : View -> view.findNavController().navigate(R.id.action_loginFragment_to_homeFragment)}
        binding.btnRegister.setOnClickListener { view : View -> view.findNavController().navigate(R.id.action_loginFragment_to_registerFragment) }

        return binding.root
    }

}