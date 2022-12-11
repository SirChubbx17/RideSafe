package com.example.ridesafe.register

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ridesafe.R
import com.example.ridesafe.database.UserDatabase
import com.example.ridesafe.databinding.RsFragRegisterBinding


class RegisterFragment : Fragment() {
    @SuppressLint("FragmentLiveDataObserve")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<RsFragRegisterBinding>(
            inflater,
            R.layout.rs_frag_register,
            container,
            false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = UserDatabase.getInstance(application).userDao

        val viewModelFactory = RegisterViewModelFactory(dataSource, application)

        val registerViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(RegisterViewModel::class.java)

        registerViewModel.navigateToLogin.observe(this, Observer {
            this.findNavController().navigate(
                R.id.action_registerFragment_to_loginFragment
            )
            registerViewModel.doneNavigating()
        })

        binding.registerViewModel = registerViewModel

        binding.setLifecycleOwner(this)

        return binding.root
    }
}