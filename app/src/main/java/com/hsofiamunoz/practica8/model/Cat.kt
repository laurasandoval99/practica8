package com.hsofiamunoz.practica8.model


import com.google.gson.annotations.SerializedName

data class Cat (
    @SerializedName("results")
    val cats: List<CatItem>?
        )
    //: ArrayList<CatItem>()