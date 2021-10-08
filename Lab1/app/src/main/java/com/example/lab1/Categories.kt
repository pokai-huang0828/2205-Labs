package com.example.lab1

import com.example.lab1.Categories.*

enum class Categories(val value: String, val image: Int){
    HOUSE("HOUSE", image = R.drawable.house),
    OFFICE("OFFICE", image = R.drawable.office),
    MARKET("MARKET", image = R.drawable.market),
    APT("APT.", image = R.drawable.apt)
}

fun getAllCategories(): List<Categories>{
    return listOf(HOUSE, OFFICE, MARKET, APT)
}

fun getCategoryText(value: String): Categories?{
    val map = Categories.values().associateBy(Categories::value)
    return map[value]
}

fun getCategoryImage(image: Int): Categories?{
    val map = Categories.values().associateBy(Categories::image)
    return map[image]
}