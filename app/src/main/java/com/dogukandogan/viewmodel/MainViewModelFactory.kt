package com.dogukandogan.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dogukandogan.repository.Repository
import com.dogukandogan.repository.TestRepository

class MainViewModelFactory(
    private val repository: TestRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}