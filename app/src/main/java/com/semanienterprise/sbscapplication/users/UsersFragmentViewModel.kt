package com.semanienterprise.sbscapplication.users

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.semanienterprise.sbscapplication.network.retrofit.NewsApi
import com.semanienterprise.sbscapplication.users.model.Article
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class UsersFragmentViewModel : ViewModel() {
    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>>
        get() = _articles

    private val _article = MutableLiveData<Article>()
    val article: LiveData<Article>
        get() = _article

    fun articleDisplayed(){
        _article.value = null
    }

    val apiKey = "6ff36c8b65e84d5794a72f5f3f859400"
    val sources = "techcrunch"

    //set up variables for coroutines
    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    init {
        loadAllNews()
    }

    private fun loadAllNews() {
        coroutineScope.launch {
            val getDeferredNews = NewsApi.retrofitService.getNewsAsync(apiKey, sources)

            try {
                val retrievedNews = getDeferredNews.await()

                if (retrievedNews.status.equals("ok")) {
                    _articles.value = retrievedNews.articles as List<Article>?
                }
            } catch (e: Exception) {
                Log.d("UsersFragmentViewModel", e.localizedMessage)
            }
        }
    }

    fun showFullArticle(article: Article) {
        _article.value = article
    }
}