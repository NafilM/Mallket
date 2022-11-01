package com.dxg.mallket

import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var myWebView: WebView? = null
    val URL = "https://www.mallket.in/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myWebView = WebView(this)
        setContentView(myWebView)

        myWebView!!.loadUrl(URL)


        myWebView!!.getSettings().setAppCacheEnabled(true)
        myWebView!!.getSettings().setJavaScriptEnabled(true)

        myWebView!!.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return false
            }
        })
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK && myWebView?.canGoBack() == true) {
            myWebView!!.goBack()
            true
        } else {
            finish()
            true
        }
    }
}