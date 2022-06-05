package com.dogukandogan.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dogukandogan.model.Post
import com.dogukandogan.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response
import java.net.SocketOptions

class MainViewModel(private val repository: Repository):ViewModel() {

    val myResponse : MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2 : MutableLiveData<Response<Post>> = MutableLiveData()
    val myCustomPosts : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myGetQueryMap : MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response : Response<Post> = repository.getPost()
            myResponse.value = response
        }
    }

    fun getPost2(number:Int){
        viewModelScope.launch {
            val response : Response<Post> = repository.getPost2(number)
            myResponse2.value = response
        }
    }

    fun getCustomPosts(userId:Int,sort:String,order:String){
        viewModelScope.launch {
            val response : Response<List<Post>> = repository.getCustomPosts(userId,sort,order)
            myCustomPosts.value = response
        }
    }

    fun getQueryMap(userId: Int,options: Map<String,String>){
        viewModelScope.launch {
            val response : Response<List<Post>> = repository.getQueryMap(userId,options)
            myGetQueryMap.value = response
        }
    }
}