package com.example.starshandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.starshandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = StarAdapter()
    private val imgIdList = listOf(R.drawable.d6dffaf3_t1, R.drawable.elgordo_665, R.drawable.k6i28r,
        R.drawable.r4wmn2, R.drawable.st5npf0l, R.drawable.star500n,
        R.drawable.stars_whiteline, R.drawable.yellow_stars)
    private val adjsList = listOf("brightest", "distant",  "beautiful",  "bewitching")
    private var indx = 0
    private var indxAdjs = (0..3).random()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init(){
        binding.apply {
            recyclerViewStars.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recyclerViewStars.adapter = adapter
            buttonViewStar.setOnClickListener {
                if (indx > 7) indx = 0
                val star = Star(imgIdList[indx], "Star $indx", "The ${adjsList[indxAdjs]} star in the universe")
                adapter.addStar(star)
                indx++
            }
        }
    }
}