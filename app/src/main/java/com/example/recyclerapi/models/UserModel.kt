package com.example.recyclerapi.models

data class UserModel(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: AddressModel,
    val phone : String
)

data class AddressModel(val street: String, val suite: String, val city: String)