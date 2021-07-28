package com.mvvm.quotes.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView.OnEditorActionListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mvvm.quotes.R
import com.mvvm.quotes.databinding.FragmentCreateQuoteBinding
import com.mvvm.quotes.model.pojo.Quote
import com.mvvm.quotes.utils.Common
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreateQuoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateQuoteFragment : Fragment() {
    private val TAG = "CreateQuoteFragment"
    private val args: CreateQuoteFragmentArgs by navArgs()

    private lateinit var binding: FragmentCreateQuoteBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_quote, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.quoteWriter.requestFocus()
        val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.quoteWriter, InputMethodManager.SHOW_IMPLICIT)
        val quote = args.quote
        if (quote == null) {
            binding.quoteDesc.setText("")
            binding.quoteWriter.setText("")
            binding.quoteDesc.hint = ("Note Description")
            binding.quoteWriter.hint = ("Note Title")
            binding.noteCreationDate.visibility = (View.INVISIBLE)
            binding.noteUpdatedDate.visibility = (View.INVISIBLE)
        }
        else{
            binding.noteUpdatedDate.setVisibility(View.INVISIBLE)
            val quote:Quote = quote!!
            binding.quoteDesc.setText(quote.quote)
            binding.quoteWriter.setText(quote.author)
            binding.noteCreationDate.text = (Common.formateDate(quote.addDate))
            binding.noteUpdatedDate.text = (Common.formateDate(quote.updateDate))
        }


        binding.quoteWriter.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                binding.quoteDesc.requestFocus()
                binding.quoteDesc.setSelection(
                    binding.quoteDesc.text.length
                )
                return@OnEditorActionListener true
            }
            false
        })

    }
}