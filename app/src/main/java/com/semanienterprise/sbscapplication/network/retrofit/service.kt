package com.semanienterprise.sbscapplication.network.retrofit

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.semanienterprise.sbscapplication.users.model.News
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit


private const val BASE_URL = "https://newsapi.org/v2/"
private val gson = GsonBuilder()
    .setLenient()
    .create()

internal val okHttpClient = OkHttpClient().newBuilder()
    .connectTimeout(5, TimeUnit.SECONDS)
    .readTimeout(5, TimeUnit.SECONDS)
    .writeTimeout(5, TimeUnit.SECONDS)
    .retryOnConnectionFailure(true)
    .build()

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(okHttpClient)
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()

interface ApiService {
    //Api for getting articles
    @GET("top-headlines")
    fun getNewsAsync(
        @Query("apiKey") apiKey: String,
        @Query("sources") sources: String
    ): Deferred<News>

    //Api for getting articles
    @GET("everything")
    fun getSearchedNews(@Query("q") searchQuery: String): Deferred<News>
}

object NewsApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}