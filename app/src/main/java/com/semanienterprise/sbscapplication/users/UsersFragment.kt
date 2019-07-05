package com.semanienterprise.sbscapplication.users


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

import com.semanienterprise.sbscapplication.databinding.UsersFragmentBinding
import com.semanienterprise.sbscapplication.network.adapter.NewsAdapter
import com.semanienterprise.sbscapplication.network.adapter.OnArticleClicked

class UsersFragment : Fragment() {
    private lateinit var binding: UsersFragmentBinding
    private lateinit var viewModel: UsersFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = UsersFragmentBinding.inflate(inflater)

        binding.lifecycleOwner = this
        viewModel = ViewModelProviders.of(this).get(UsersFragmentViewModel::class.java)

        setObservers()

        return binding.root
    }

    private fun setObservers() {
        //observer to display for articles
        viewModel.articles.observe(this, Observer { articles ->
            articles?.let {
                val adapter = NewsAdapter(articles, OnArticleClicked {
                    viewModel.showFullArticle(it)
                })
                //set the recycler view adapter to the created one
                binding.contentMainLayout.newsRecView.adapter = adapter
            }
        })

        //observer to send article to the users fragment
        viewModel.article.observe(this, Observer { article ->
            article?.let {
                findNavController().navigate(UsersFragmentDirections.actionUsersFragmentToArticleFragment(article))
                viewModel.articleDisplayed()
            }
        })
    }
}
