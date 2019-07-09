package com.example.flaskapi.service

import com.example.flaskapi.model.Buku
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import android.R.style.Widget
import com.google.gson.GsonBuilder


interface BukuService {
    //fun getBuku(@Path("juduls") judul: String): Observable<Buku>
    @GET("buku")
    fun getBuku(): Call<List<Buku>>

    object DataRepository {
        fun create(): BukuService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .baseUrl("https://eecf07f9.ngrok.io/")
                .build()
            return retrofit.create(BukuService::class.java)
        }
    }

}