package com.ninjacars.ninjacarsapp.models

import com.ninjacars.ninjacarsapp.database.AllParametrs


data class Task(
 val date:String,
var nameAuto: String,
var params : AllParametrs
){

}
data class Task2(
    val date:String,
    var nameAuto: String,
    var params : Params
){

}
