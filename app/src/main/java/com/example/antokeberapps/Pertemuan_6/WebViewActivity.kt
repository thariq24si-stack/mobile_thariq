package com.example.antokeberapps.Pertemuan_6

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.antokeberapps.R
import com.example.antokeberapps.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_web_view)

        supportActionBar?.title = "Web View"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val webView = findViewById<WebView>(R.id.webView)

        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        webView.loadUrl("https://thariq-sic.alwaysdata.net/login")
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}