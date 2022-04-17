package com.example.starshandbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starshandbook.databinding.StarItemBinding

class StarAdapter: RecyclerView.Adapter<StarAdapter.StarHolder>() {
    val starList = ArrayList<Star>()
    class StarHolder(item: View):RecyclerView.ViewHolder(item) {
        val binding = StarItemBinding.bind(item)
        fun bind(star: Star) = with(binding){
            starImgView.setImageResource(star.imageId)
            textViewTitle.text = star.title
            textViewDescription.text = star.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.star_item, parent, false)
        return StarHolder(view)
    }

    override fun onBindViewHolder(holder: StarHolder, position: Int) {
        holder.bind(starList[position])
    }

    override fun getItemCount(): Int {
        return starList.size
    }

    fun addStar(star: Star){
        starList.add(star)
        notifyDataSetChanged()
    }
}