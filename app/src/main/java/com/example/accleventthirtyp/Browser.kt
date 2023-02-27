package com.example.accleventthirtyp

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.example.accleventthirtyp.databinding.ActivityBrowserBinding

class Browser : AppCompatActivity() {
    private lateinit var binding: ActivityBrowserBinding
    @RequiresApi(Build.VERSION_CODES.O)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBrowserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val msg : String = intent.getStringExtra("message").toString()
        webSetup(msg)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    public fun webSetup(link : String){
        binding.web.webViewClient = WebViewClient()
        binding.web.apply {
            loadUrl(link)
            settings.javaScriptEnabled = true
        }

    }

    override fun onBackPressed() {

        if(binding.web.canGoBack())
            binding.web.goBack()
        else
            super.onBackPressed()

    }
}