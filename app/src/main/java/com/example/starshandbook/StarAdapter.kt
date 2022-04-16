package com.example.starshandbook

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.starshandbook.databinding.StarItemBinding

class StarAdapter: RecyclerView.Adapter<StarAdapter.StarHolder> {
    class StarHolder(item: View):RecyclerView.ViewHolder(item) {
        val binding = StarItemBinding.bind(item)
        fun bind(star: Star){

        }
    }
}