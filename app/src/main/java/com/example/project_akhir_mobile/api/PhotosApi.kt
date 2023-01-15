package com.example.project_akhir_mobile.api

import com.example.project_akhir_mobile.model.Photo
import io.reactivex.Single
import retrofit2.http.GET

interface PhotosApi {
    @GET("data")
    fun getPhotos(): Single<List<Photo>>
}

