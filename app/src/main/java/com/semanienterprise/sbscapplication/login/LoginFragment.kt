package com.semanienterprise.sbscapplication.login


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.semanienterprise.sbscapplication.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {
    private lateinit var binding: LoginFragmentBinding
    private lateinit var viewModel: LoginFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = LoginFragmentBinding.inflate(inflater)
        viewModel = ViewModelProviders.of(this).get(LoginFragmentViewModel::class.java)

        setOnClickListener()

        setObservers()

        return binding.root
    }

    private fun setObservers() {
        //observer to show the admin panel
        viewModel.showAdminPanel.observe(this, Observer { showAdminPanel ->
            showAdminPanel?.let {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToAdminFragment())
                viewModel.adminPanelShown()
            }
        })

        //observer to show the end user fragment
        viewModel.showEndUserFragment.observe(this, Observer { showEndUserPanel ->
            showEndUserPanel?.let {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToUsersFragment())
                viewModel.endUserFragmentShown()
            }
        })

        //observer to display toast message
        viewModel.showToastMessage.observe(this, Observer { toastMessage ->
            toastMessage?.let {
                Toast.makeText(activity, toastMessage, Toast.LENGTH_SHORT).show()
                viewModel.toastMessageShown()
            }
        })
    }

    //method to set on click listener
    private fun setOnClickListener() {
        //method to process to call the viewModel to process the sign-in
        binding.userLogin.setOnClickListener {
            viewModel.processLogin(binding.username.text.toString(), binding.password.text.toString())
        }
    }
}
