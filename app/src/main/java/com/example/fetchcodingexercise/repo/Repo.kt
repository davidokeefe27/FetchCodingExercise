package com.example.fetchcodingexercise.repo

import com.example.fetchcodingexercise.api.Api
import com.example.fetchcodingexercise.api.NetworkResult
import com.example.fetchcodingexercise.models.DataModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Inject

interface Repo {
    suspend fun getData(): NetworkResult<List<DataModel>>
}

class RepoImpl @Inject constructor(): Repo {
    private lateinit var api: Api
    override suspend fun getData(): NetworkResult<List<DataModel>> {
        return try {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            api = retrofit.create()
            NetworkResult.Success(data = api.getData().body() ?: emptyList())
        } catch (e: Exception) {
            NetworkResult.Error(e.message.orEmpty())
        }
    }
}

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {
    @Binds
    abstract fun bindRepo(repoImpl: RepoImpl): Repo
}