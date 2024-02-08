package ru.gb.android.workshop5.products.domain

data class Product (
    val id: String,
    val name: String,
    val image: String,
    val price: Double,
    val hasDiscount: Boolean,
    val discount: Double?,
)
