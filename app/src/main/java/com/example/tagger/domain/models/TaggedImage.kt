package com.example.tagger.domain.models

data class TaggedImage(
    val tags: MutableList<String>,
    val image: Image
)