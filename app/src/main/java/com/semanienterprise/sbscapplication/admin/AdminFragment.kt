package com.semanienterprise.sbscapplication.admin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import com.semanienterprise.sbscapplication.R
import com.semanienterprise.sbscapplication.databinding.AdminFragmentBinding
import com.semanienterprise.sbscapplication.databinding.ArticleFragmentBinding

class AdminFragment : Fragment() {

    private lateinit var binding: AdminFragmentBinding
    private lateinit var viewModel: AdminFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = AdminFragmentBinding.inflate(inflater)
        viewModel = ViewModelProviders.of(this).get(AdminFragmentViewModel::class.java)

        return binding.root
    }
}
