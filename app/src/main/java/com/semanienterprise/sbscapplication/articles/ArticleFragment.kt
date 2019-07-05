package com.semanienterprise.sbscapplication.articles


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import com.semanienterprise.sbscapplication.R
import com.semanienterprise.sbscapplication.ViewModelFactory
import com.semanienterprise.sbscapplication.databinding.ArticleFragmentBinding

class ArticleFragment : Fragment() {
    private lateinit var binding: ArticleFragmentBinding
    private lateinit var viewModel: ArticleFragmentViewModel
    private lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = ArticleFragmentBinding.inflate(inflater)

        //get the article sent using safeargs and initialize the viewModel using the article
        val article = ArticleFragmentArgs.fromBundle(arguments!!).article
        viewModelFactory = ViewModelFactory(article)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ArticleFragmentViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}
