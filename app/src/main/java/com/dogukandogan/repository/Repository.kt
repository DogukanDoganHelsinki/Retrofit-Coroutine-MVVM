package com.dogukandogan.repository

import com.dogukandogan.api.RetrofitInstance
import com.dogukandogan.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number:Int): Response<Post>{
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun getCustomPosts(userId:Int, sort:String, order:String) : Response<List<Post>>{
        return RetrofitInstance.api.getCustomPosts(userId,sort,order)
    }

    suspend fun getQueryMap(userId:Int, options:Map<String,String>):Response<List<Post>>{
        return RetrofitInstance.api.getQueryMap(userId,options)
    }

}