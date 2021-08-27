package com.example.tagger.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.tagger.R
import com.example.tagger.data.ImagesRepositoryImpl
import com.example.tagger.domain.models.Image
import com.example.tagger.domain.models.Tag
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repo = ImagesRepositoryImpl(applicationContext)
        this.lifecycleScope.launch{
            repo.add(Tag("newTag"), listOf(Image("newUri")))
        }
    }
}