package com.mvvm.quotes.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvm.quotes.R
import com.mvvm.quotes.adapter.recyclerview.QuotesAdapter
import com.mvvm.quotes.databinding.QuoteListFragmentBinding
import com.mvvm.quotes.model.pojo.Quote
import com.mvvm.quotes.viewmodel.QuoteListViewModel


class QuoteListFragment : Fragment() {
    lateinit var binding:QuoteListFragmentBinding
    lateinit var linearLayoutManager: LinearLayoutManager
    companion object {
        fun newInstance() = QuoteListFragment()
    }

    val args: QuoteListFragmentArgs by navArgs()

    private lateinit var viewModel: QuoteListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.quote_list_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(QuoteListViewModel::class.java)
        linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.quotelistView.layoutManager = linearLayoutManager

        val quoteList = ArrayList<Quote>()
        val quote = Quote("You cannot always be motivated. That is why you need discipline to stay motivated","Shikhar Jaiswal")
        val quote2 = Quote("Theres always a sacrifice, whether its FOR the things you want OR the things you want","Shikhar Jaiswal")
        quoteList.add(quote)
        quoteList.add(quote2)




        val adapter = QuotesAdapter(quoteList)
        binding.quotelistView.adapter = adapter




    }

}