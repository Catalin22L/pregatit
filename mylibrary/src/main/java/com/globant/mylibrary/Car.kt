package com.globant.mylibrary

import android.util.Log

class Car(val brand : String, val model : CarModel) {

    var year : String = ""
        get() = "Year: $year"
        set(value) {
            Log.d("MyTag", "year is $value")
            field = value
        }

    fun driveCar() {
        Log.d("MyTag", "Brand: $brand & car model: ${model.name} & car plate number: ${model.plateNo}")
    }
}

enum class CarModel(val plateNo : String) {
    DACIA("CJ 30 ABC"), TESLA("BR 4 TCX"), MINICOOPER("CJ 56 OAK")
}