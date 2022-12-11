package com.example.ridesafe

data class FAQData (
    val question: String,
    val content: String,
    var isExpandable: Boolean = false

)