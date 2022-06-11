package com.dogukandogan.repository

import com.dogukandogan.model.Post
import retrofit2.Response

interface BaseRepository {

    suspend fun getPost(): Response<Post>

    suspend fun getPost2(number:Int): Response<Post>

    suspend fun getCustomPosts(userId:Int, sort:String, order:String) : Response<List<Post>>

    suspend fun getQueryMap(userId:Int, options:Map<String,String>): Response<List<Post>>

}