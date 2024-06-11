package com.example.fetchcodingexercise.name

import androidx.lifecycle.ViewModel
import com.example.fetchcodingexercise.repo.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NameViewModel @Inject constructor(
    private val repo: Repo
): ViewModel() {
}