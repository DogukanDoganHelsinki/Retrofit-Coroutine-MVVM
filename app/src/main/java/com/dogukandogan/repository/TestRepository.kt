package com.dogukandogan.repository

import com.dogukandogan.model.Post
import retrofit2.Response

class TestRepository: BaseRepository {
    override suspend fun getPost(): Response<Post> {
        val post = Post(1,1,"deneme","deneme")
        return Response.success(post)
    }

    override suspend fun getPost2(number: Int): Response<Post> {
        val post = Post(1,1,"deneme","deneme")
        return Response.success(post)
    }

    override suspend fun getCustomPosts(
        userId: Int,
        sort: String,
        order: String
    ): Response<List<Post>> {
        val post = Post(1,1,"deneme","deneme")
        return Response.success(listOf(post))
    }

    override suspend fun getQueryMap(
        userId: Int,
        options: Map<String, String>
    ): Response<List<Post>> {
        val post = Post(1,1,"deneme","deneme")
        return Response.success(listOf(post))
    }
}