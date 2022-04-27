package com.example.starshandbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.starshandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), StarAdapter.Listener {
    lateinit var binding: ActivityMainBinding
    private val adapter = StarAdapter(this)
    private val adjsList = listOf("brightest", "distant",  "beautiful",  "bewitching")
    private var indx = 0
    private var indxAdjs = (0..3).random()
    private var editLauncher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                adapter.addStar(it.data?.getSerializableExtra("star") as Star)
            }
        }
    }
    private fun init(){
        binding.apply {
            recyclerViewStars.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recyclerViewStars.adapter = adapter
            buttonViewStar.setOnClickListener {
            /*    if (indx > 7) indx = 0
                val star = Star(imgIdList[indx], "Star $indx", "The ${adjsList[indxAdjs]} star in the universe")
                adapter.addStar(star)
                indx++*/
                editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))
            }
        }
    }

    override fun onClick(star: Star) {
        Toast.makeText(this, "You push on the ${star.title}", Toast.LENGTH_LONG).show()
    }
}