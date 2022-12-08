package com.example.ridesafe.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.ridesafe.R
import com.example.ridesafe.database.UserDatabase

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = UserDatabase.getInstance(application).userDao

        val viewModelFactory = LoginViewModelFactory(dataSource, application)

        val loginViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(LoginViewModel::class.java)

        binding.btnReg.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_login_to_register3)
        }

        LoginViewModel.navigateToHome.observe(viewLifecycleOwner, Observer {
            this.findNavController().navigate(
                R.id.action_login_to_home2)
            loginViewModel.doneNavigating()
        })

        binding.loginViewModel = loginViewModel

        binding.setLifecycleOwner(this)

        return binding.root
    }
}
