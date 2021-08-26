package com.example.tagger.domain.interactors

import com.example.tagger.domain.repository.ImagesRepository

class EditTaggedImageUseCaseImpl(private val imagesRepository: ImagesRepository) :
    EditTaggedImageUseCase {
//    override suspend fun invoke(taggedImage: TaggedImage) {
//        imagesRepository.edit(taggedImage)
//    }
}