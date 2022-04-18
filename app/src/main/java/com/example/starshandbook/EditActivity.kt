package com.example.starshandbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.starshandbook.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private var indxImg = (0..7).random()
    private var imgId = (0..7).random()
    private val imgIdList = listOf(R.drawable.d6dffaf3_t1, R.drawable.elgordo_665, R.drawable.k6i28r,
        R.drawable.r4wmn2, R.drawable.st5npf0l, R.drawable.star500n,
        R.drawable.stars_whiteline, R.drawable.yellow_stars)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    private fun initButtons() = with(binding){
        buttonNext.setOnClickListener {
            imgId = imgIdList[indxImg]
            imageViewEdit.setImageResource(imgId)
        }
        buttonDone.setOnClickListener {
            val star = Star(imgId, editTextTitle.text.toString(), editTextDesc.text.toString())
            val editIntent = Intent().apply {
                putExtra("star", star)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}