package com.mvvm.quotes.view.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.mvvm.quotes.R
import com.mvvm.quotes.databinding.HomeActivityBinding
import com.mvvm.quotes.viewmodel.BlankViewModel
import com.mvvm.quotes.viewmodel.factory.BlankViewModelFactory


class HomeActivity : AppCompatActivity() {
    private lateinit var mAnimationSet: AnimatorSet
    private lateinit var viewModel: BlankViewModel
    private lateinit var binding: HomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.home_activity);


        viewModel = ViewModelProvider(this, BlankViewModelFactory(applicationContext)).get(BlankViewModel::class.java)
        // TODO: Use the ViewModel


        binding.quoteContent.movementMethod = ScrollingMovementMethod()
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        binding.exporeBtn.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java )
            startActivity(intent)
        })

//        mAnimationSet.start()
    }

}