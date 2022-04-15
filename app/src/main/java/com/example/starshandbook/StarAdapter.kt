package com.example.starshandbook

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class StarAdapter: RecyclerView.Adapter<StarAdapter.StarHolder> {
    class StarHolder(item: View):RecyclerView.ViewHolder(item) {
        fun bind(star: Star){

        }
    }
}