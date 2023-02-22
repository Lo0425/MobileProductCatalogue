package com.example.productcatalogue.data.model

data class ProductsResponse(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)