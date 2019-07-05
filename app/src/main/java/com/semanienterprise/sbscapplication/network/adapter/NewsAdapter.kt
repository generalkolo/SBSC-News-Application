package com.semanienterprise.sbscapplication.network.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.semanienterprise.sbscapplication.databinding.ItemNewsLayoutBinding
import com.semanienterprise.sbscapplication.users.model.Article

class NewsAdapter(private val news: List<Article>, private val onArticleClicked: OnArticleClicked) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    override fun getItemCount(): Int {
        return news.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(ItemNewsLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = news[position]
        holder.bind(article)
        holder.itemView.setOnClickListener {
            onArticleClicked.onClick(article)
        }
    }

    class NewsViewHolder(private var binding: ItemNewsLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.article = article
            binding.executePendingBindings()
        }
    }
}

class OnArticleClicked(val onClickListener: (article: Article) -> Unit) {
    fun onClick(article: Article) = onClickListener(article)
}