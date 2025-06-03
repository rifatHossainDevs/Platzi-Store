package com.free.expense.manager.platzistore.ui.login

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.free.expense.manager.platzistore.R
import com.free.expense.manager.platzistore.data.login.RequestLogin
import com.free.expense.manager.platzistore.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.core.content.edit

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    private lateinit var sharedPref: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireContext().getSharedPreferences("auth_pref", Context.MODE_PRIVATE)

        viewModel.loginResponse.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = View.GONE
            if (it.isSuccessful) {
                val token = it.body()?.accessToken
                val refreshToken = it.body()?.refreshToken
                if (token!= null ){
                    // Save both tokens
                    sharedPref.edit().apply {
                        putString("access_token", token)
                        putString("refresh_token", refreshToken)
                        apply()
                    }
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                }



            } else {
                Toast.makeText(requireContext(), "Not successful", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            binding.progressBar.visibility = View.VISIBLE
            handleLogin("john@mail.com", "changeme")
        }
    }

    private fun LoginFragment.handleLogin(email: String, password: String) {
        val requestLogin = RequestLogin(email, password)

        viewModel.login(requestLogin)
    }
}


