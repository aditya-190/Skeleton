package com.bhardwaj.skeleton

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.IntRange
import androidx.recyclerview.widget.RecyclerView
import io.supercharge.shimmerlayout.ShimmerLayout

/**
 * Created by bhardwaj on 2017/7/29.
 */
class SkeletonAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mItemCount = 0
    private var mLayoutReference = 0
    private var mLayoutArrayReferences: IntArray? = null
    private var mColor = 0
    private var mShimmer = false
    private var mShimmerDuration = 0
    private var mShimmerAngle = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        if (doesArrayOfLayoutsExist()) {
            mLayoutReference = viewType
        }
        return if (mShimmer) {
            ShimmerViewHolder(inflater, parent, mLayoutReference)
        } else object :
            RecyclerView.ViewHolder(inflater.inflate(mLayoutReference, parent, false)) {}
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (mShimmer) {
            val layout = holder.itemView as ShimmerLayout
            layout.setShimmerAnimationDuration(mShimmerDuration)
            layout.setShimmerAngle(mShimmerAngle)
            layout.setShimmerColor(mColor)
            layout.startShimmerAnimation()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (doesArrayOfLayoutsExist()) {
            getCorrectLayoutItem(position)
        } else super.getItemViewType(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItemCount
    }

    fun setLayoutReference(layoutReference: Int) {
        mLayoutReference = layoutReference
    }

    fun setArrayOfLayoutReferences(layoutReferences: IntArray?) {
        mLayoutArrayReferences = layoutReferences
    }

    fun setItemCount(itemCount: Int) {
        mItemCount = itemCount
    }

    fun setShimmerColor(color: Int) {
        mColor = color
    }

    fun shimmer(shimmer: Boolean) {
        mShimmer = shimmer
    }

    fun setShimmerDuration(shimmerDuration: Int) {
        mShimmerDuration = shimmerDuration
    }

    fun setShimmerAngle(@IntRange(from = 0, to = 30) shimmerAngle: Int) {
        mShimmerAngle = shimmerAngle
    }

    private fun getCorrectLayoutItem(position: Int): Int {
        return if (doesArrayOfLayoutsExist()) {
            mLayoutArrayReferences!![position % mLayoutArrayReferences!!.size]
        } else mLayoutReference
    }

    private fun doesArrayOfLayoutsExist(): Boolean {
        return mLayoutArrayReferences != null && mLayoutArrayReferences!!.isNotEmpty()
    }
}