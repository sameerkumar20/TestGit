package com.sameer.firstdayintern.model

data class OrderDetail(
    val id : Int ,
    val paid_type : String,
    val name : String,
    val min : Int,
    val pay_type : String,
    val price : Int,

)
