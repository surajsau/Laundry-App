package com.halfplatepoha.laundry.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.halfplatepoha.laundry.R

class DailyAdapter: RecyclerView.Adapter<DailyViewHolder>() {

    var dailyClothes: MutableList<DailyModel>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        return DailyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_daily, parent, false))
    }

    override fun getItemCount(): Int {
        return dailyClothes?.size ?: 0
    }

    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
        if(dailyClothes != null)
            holder.bind(dailyClothes!!.get(position))
    }

    fun addCloth(cloth: DailyModel) {
        if(dailyClothes == null)
            dailyClothes = ArrayList()

        dailyClothes!!.add(cloth)
        notifyItemInserted(dailyClothes!!.size - 1)
    }
}