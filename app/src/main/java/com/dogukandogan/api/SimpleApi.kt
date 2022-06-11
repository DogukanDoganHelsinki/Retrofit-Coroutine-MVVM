package com.dogukandogan.api

import com.dogukandogan.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost():Response<Post>


    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number:Int
    ): Response<Post>

    //https://jsonplaceholder.typicode.com/posts?userId=3

    @GET("posts")
    suspend fun getCustomPosts(
        @Query("userId") userId:Int,
        @Query("_sort") sort:String,
        @Query("_order") order:String
    ):Response<List<Post>>

    //https://jsonplaceholder.typicode.com/posts?userId=3&_sort=id&_order=desc

    @GET("posts")
    suspend fun getQueryMap(
        @Query("usedId") userId: Int,
        @QueryMap options: Map<String,String>
    ):Response<List<Post>>
}