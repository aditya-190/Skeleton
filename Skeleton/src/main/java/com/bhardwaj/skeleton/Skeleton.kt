package com.bhardwaj.skeleton

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by bhardwaj on 2023/03/11.
 */
object Skeleton {
    fun bind(recyclerView: RecyclerView?): RecyclerViewSkeletonScreen.Builder? {
        return recyclerView?.let { RecyclerViewSkeletonScreen.Builder(it) }
    }

    fun bind(view: View?): ViewSkeletonScreen.Builder {
        return ViewSkeletonScreen.Builder(view!!)
    }
}