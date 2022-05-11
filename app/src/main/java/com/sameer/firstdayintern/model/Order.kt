package com.sameer.firstdayintern.model

data class Order(
    val qty : Int,
    val orderDetails: List<OrderDetail>
)
