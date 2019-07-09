package com.example.flaskapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Buku (

    @SerializedName("id")
    @Expose
    open val id: Int,

    @SerializedName("judul")
    @Expose
    //open var judul: String? = null
    //open val judul: String? = null
    open val judul: String

)

