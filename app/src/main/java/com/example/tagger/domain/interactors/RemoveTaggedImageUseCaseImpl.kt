package com.example.tagger.domain.interactors

import com.example.tagger.domain.repository.ImagesRepository

class RemoveTaggedImageUseCaseImpl(private val imagesRepository: ImagesRepository) :
    RemoveTaggedImageUseCase {
}