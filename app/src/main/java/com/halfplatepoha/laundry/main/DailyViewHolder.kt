package com.halfplatepoha.laundry.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.halfplatepoha.laundry.Utils
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_daily.*

class DailyViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(dailyModel : DailyModel) {
        tvDate.text = Utils.dateString(dailyModel.date!!)
        tvShirt.text = dailyModel.top!!.name
        tvPant.text = dailyModel.bottom!!.name
        tvOcassion.text = dailyModel.ocassion
    }

}