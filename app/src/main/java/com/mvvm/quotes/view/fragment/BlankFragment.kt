package com.mvvm.quotes.view.fragment

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mvvm.quotes.R
import com.mvvm.quotes.databinding.BlankFragmentBinding
import com.mvvm.quotes.viewmodel.BlankViewModel
import com.mvvm.quotes.viewmodel.factory.BlankViewModelFactory


class BlankFragment : Fragment() {

    companion object {
        fun newInstance() = BlankFragment()
    }

    private lateinit var viewModel: BlankViewModel
        lateinit var binding: BlankFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {  
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.blank_fragment, container, false)

        return binding.getRoot();
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this, BlankViewModelFactory(context)).get(BlankViewModel::class.java)
        // TODO: Use the ViewModel

        var quote  =  viewModel.getQuote()

        binding.quote = quote
        binding.quoteContent.movementMethod = ScrollingMovementMethod()
        binding.nextBtn.setOnClickListener(View.OnClickListener { nextQuote() })
        binding.previousBtn.setOnClickListener(View.OnClickListener { previousQuote() })

    }


    fun nextQuote(){
        var quote  =  viewModel.nextQuote()
        binding.quote = quote
    }

    fun previousQuote(){
        var quote  =  viewModel.previousQuote()
        binding.quote = quote
    }

}