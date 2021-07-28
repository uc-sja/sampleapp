package com.mvvm.quotes.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.mvvm.quotes.R
import com.mvvm.quotes.databinding.FragmentQuotationBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuotationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuotationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentQuotationBinding
    private val args: QuotationFragmentArgs by navArgs()

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quotation, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val quote = args.quote
        binding.background.background = requireContext().resources.getDrawable(R.drawable.motivation1)
        binding.quotationText.text = quote.quote
        binding.quotationAuthor.text = quote.author

        binding.editBtn.setOnClickListener(View.OnClickListener {
            val action = QuotationFragmentDirections.actionQuotationFragmentToCreateQuoteFragment(quote, "Edit Quote")
            it.findNavController().navigate(action)
        })

    }


}