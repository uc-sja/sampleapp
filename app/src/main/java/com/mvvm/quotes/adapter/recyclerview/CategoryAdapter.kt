package com.mvvm.quotes.adapter.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.mvvm.quotes.R
import com.mvvm.quotes.model.Category
import com.mvvm.quotes.view.fragment.CategoryFragmentDirections

class CategoryAdapter(private val dataSet: ArrayList<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val bg_image: ShapeableImageView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.category_name)
            bg_image = view.findViewById(R.id.bg_image)

            val spacing = itemView.resources.getDimension(R.dimen._20sdp)
            bg_image.shapeAppearanceModel = bg_image.shapeAppearanceModel.toBuilder().setAllCornerSizes(spacing).build()
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.category_cell, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val category: Category = dataSet[position]
        viewHolder.textView.text = category.name
        viewHolder.itemView.setOnClickListener(View.OnClickListener { openCategory(category, it) })
    }

        private fun openCategory(category: Category, view: View) {
        }

        // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    fun updateItems(newCategories: ArrayList<Category>){
        this.dataSet.clear()
        notifyDataSetChanged()
        this.dataSet.addAll(newCategories)
        notifyDataSetChanged()
    }

}
