package com.dogukandogan.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dogukandogan.viewmodel.MainViewModelFactory
import com.dogukandogan.repository.Repository
import com.dogukandogan.retrofitss.R
import com.dogukandogan.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        //HashMap
        val options: HashMap<String,String> = HashMap()
        options["_sort"] = "id"
        options["_order"] = "desc"


        buttonSingleRequest.setOnClickListener {
            val myNumber:String = editTextNumber.text.toString()
            viewModel.getPost2(Integer.parseInt(myNumber))
            viewModel.myResponse2.observe(this, Observer {response->
                if(response.isSuccessful){
                    textView.text = response.body().toString()
                }else{
                    textView.text = response.body().toString()
                }
            })
        }
        buttonQuery.setOnClickListener {
            val myNumber:String = editTextNumber.text.toString()
            viewModel.getQueryMap(Integer.parseInt(myNumber), options)
            viewModel.myGetQueryMap.observe(this, Observer { response->
                if (response.isSuccessful){
                    textView.text=response.body().toString()
                    response.body()?.forEach{
                        Log.d("Response", it.userId.toString())
                        Log.d("Response", it.id.toString())
                        Log.d("Response", it.title.toString())
                        Log.d("Response", it.body.toString())
                        Log.d("Response", "--------------")
                    }
                }else{
                    textView.text =response.body().toString()
                }
            })
        }
    }
}