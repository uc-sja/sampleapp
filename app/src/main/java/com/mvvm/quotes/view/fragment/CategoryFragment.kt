package com.mvvm.quotes.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.mvvm.quotes.R
import com.mvvm.quotes.adapter.recyclerview.CategoryAdapter
import com.mvvm.quotes.adapter.recyclerview.SpaceItemdecoration
import com.mvvm.quotes.databinding.CategoryFragmentBinding
import com.mvvm.quotes.model.pojo.Category
import com.mvvm.quotes.viewmodel.BlankViewModel


class CategoryFragment : Fragment() {
    private var spacing: Int = 0
    private lateinit var adapter: CategoryAdapter
    private val TAG = "BlankFragment"

    companion object {
        fun newInstance() = CategoryFragment()
    }

    private lateinit var viewModel: BlankViewModel

        lateinit var binding: CategoryFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {  
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.category_fragment, container, false)
        return binding.getRoot();
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gridLayoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
//        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        spacing = resources.getDimensionPixelSize(R.dimen._10sdp)

        binding.categoryView.layoutManager = gridLayoutManager

        binding.categoryView.addItemDecoration(SpaceItemdecoration(2, spacing, true, 0))


        adapter = CategoryAdapter(ArrayList<Category>())
        adapter.setHasStableIds(true)
        binding.categoryView.adapter = adapter

        val  itemAnimator = binding.categoryView.itemAnimator

        fetchCategories();

    }

    private fun fetchCategories() {
        val inputStream = requireContext().assets.open("categories.json")
        val size = inputStream.available()

        val buffer = ByteArray(size)

        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8)


        val categories = Gson().fromJson(json, Array<Category>::class.java)

        for(q in categories){
            Log.d(TAG, "cats: "+q.name)
        }

        adapter.updateItems(newCategories = categories.toCollection(ArrayList()))



    }

}