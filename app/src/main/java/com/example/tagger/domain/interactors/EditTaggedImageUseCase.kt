package com.example.tagger.domain.interactors

import com.example.tagger.domain.models.TaggedImage

interface EditTaggedImageUseCase {
    suspend operator fun invoke(taggedImage: TaggedImage)
}