/*
 *
 * Created by doaafouad on 1/16/22 11:45 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 11:45 AM
 *
 *
 */

package com.doaa.weatherradar.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.ContentLoadingProgressBar
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<I : ViewIntent, S : ViewState, E : ViewEffect, V : ViewBinding> :
    AppCompatActivity() {

    abstract val viewModel: BaseViewModel<I, S, E>

    protected var binding: V? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = getViewBinding()
        setContentView(binding?.root)
        observeViewState()
        init()
        setListeners()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    abstract fun observeViewState()
    abstract fun getViewBinding(): V

    open fun init() {}
    open fun setListeners() {}


    fun navigateToActivity(destination: Class<*>?, bundle: Bundle? = null) {
        val intent = Intent(this, destination)
        bundle?.let { intent.putExtras(bundle) }
        startActivity(intent)
    }

    fun showLongToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    protected fun showProgress(progressBar: ContentLoadingProgressBar?) {
        progressBar?.visibility = View.VISIBLE
        progressBar?.show()
    }

    protected fun hideProgress(progressBar: ContentLoadingProgressBar?) {
        progressBar?.hide()
    }

    protected fun hideKeyboard(){
        val view = this.currentFocus
        if (view != null) {
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}