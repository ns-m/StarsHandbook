package com.example.starshandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.starshandbook.databinding.ActivityContentBinding

class ContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val itemsStar = intent.getSerializableExtra("item") as Star
        binding.apply {
            imageViewGeneral.setImageResource(itemsStar.imageId)
            textViewTitleContent.text = itemsStar.title
            textViewDescContent.text = itemsStar.description
        }
    }
}