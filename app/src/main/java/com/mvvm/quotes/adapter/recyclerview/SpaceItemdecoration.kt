package com.mvvm.quotes.adapter.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView




class SpaceItemdecoration(val spanCount: Int, val space: Int, val includeEdge: Boolean, val headerNum: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position: Int = parent.getChildAdapterPosition(view) - headerNum // item position
        if(position >= 0){
            val column: Int = position%spanCount
            if (includeEdge) {
                outRect.left = space - column * space / spanCount; // space - column * ((1f / spanCount) * space)
                outRect.right = (column + 1) * space / spanCount; // (column + 1) * ((1f / spanCount) * space)

                if (position < spanCount) { // top edge
                    outRect.top = space;
                }
                outRect.bottom = space; // item bottom
            } else {
                outRect.left = column * space / spanCount; // column * ((1f / spanCount) * space)
                outRect.right = space - (column + 1) * space / spanCount; // space - (column + 1) * ((1f /    spanCount) * space)
                if (position >= spanCount) {
                    outRect.top = space; // item top
                }
            }
        } else {
            outRect.left = 0;
            outRect.right = 0;
            outRect.top = 0;
            outRect.bottom = 0;
        }
        }

        
    }

