package com.example.newsrecommend

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

data class ArticleResponse(

    val paignation: paignation,
    val data: List<Article>

)

data class paignation(

    val limit: Int,
    val offset: Int,
    val count: Int,
    val total: Int

)

data class Article(

    val id: String?,
    val name: String?,
    val category: String?,
    val country: String?,
    val language: String?,
    val url: String?

)


interface MediaStackAPIService {

    @GET("news")
    suspend fun getArticle(
        @Query("access_key") apiKey: String,
        @Query("query") keywords: String

    ): ArticleResponse

}

object RetroFitInstance {
    private const val BASE_URL = "https://api.mediastack.com/v1/"

    val api: MediaStackAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MediaStackAPIService::class.java)
    }

}