package com.semanienterprise.sbscapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.semanienterprise.sbscapplication.articles.ArticleFragmentViewModel
import com.semanienterprise.sbscapplication.users.model.Article

class ViewModelFactory(private val article: Article) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArticleFragmentViewModel::class.java)) {
            return ArticleFragmentViewModel(article) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}