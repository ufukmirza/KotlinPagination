package com.example.myapplication.data.model

data class Breed(
    val bred_for: String,
    val breed_group: String,
    val country_code: String,
    val height: Height,
    val id: Int,
    val life_span: String,
    val name: String,
    val reference_image_id: String,
    val temperament: String,
    val weight: Weight
)