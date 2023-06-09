package com.bhardwaj.skeleton

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by bhardwaj on 2023/03/11.
 */
class ShimmerViewHolder(inflater: LayoutInflater, parent: ViewGroup?, innerViewResId: Int) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.layout_shimmer, parent, false)) {
    init {
        val layout = itemView as ViewGroup
        val view = inflater.inflate(innerViewResId, layout, false)
        val lp = view.layoutParams
        if (lp != null) {
            layout.layoutParams = lp
        }
        layout.addView(view)
    }
}