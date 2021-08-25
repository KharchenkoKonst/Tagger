package com.example.tagger.domain.interactors

import com.example.tagger.domain.models.TaggedImage
import com.example.tagger.domain.repository.ImagesRepository

class AddTaggedImageUseCaseImpl(private val imagesRepository: ImagesRepository) :
    AddTaggedImageUseCase {
    override suspend fun invoke(taggedImage: TaggedImage) {
        imagesRepository.add(taggedImage)
    }
}