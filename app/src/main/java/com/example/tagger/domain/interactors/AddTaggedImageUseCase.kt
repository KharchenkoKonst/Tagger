package com.example.tagger.domain.interactors

import com.example.tagger.domain.models.TaggedImage

interface AddTaggedImageUseCase {
    suspend operator fun invoke(taggedImage: TaggedImage)
}