package com.hythluynlhkjbkflvf.rpogportbpgoglkbm.fnrjfnrjnflkr.fvnklfvlmrtklbvtr.kfrlvmgtlkrmgbltrg

import android.app.Activity
import android.annotation.SuppressLint
import android.view.View
import android.os.Bundle
import android.view.KeyEvent
import android.view.WindowManager
import android.webkit.*
import com.hythluynlhkjbkflvf.rpogportbpgoglkbm.R

class VrvtfrkvnbkrtgbtyghnBYTHbvnftkrjbg : Activity() {
    private lateinit var webView: WebView
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nfrvekjvgrkjvt_vbtgrnbkvjgtkbj)
        webView = findViewById(R.id.web_view_html)
        val HTrtnfkjbgtYGhnjytnj = "super_secret_token.bin"
        val fgklntfrkjgntrjkgnktjr =
            application.assets.open(HTrtnfkjbgtYGhnjytnj).bufferedReader().use {
                it.readText()
            }
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        webView.settings.javaScriptEnabled = true
        webView.settings.useWideViewPort = true
        webView.settings.domStorageEnabled = true
        webView.settings.databaseEnabled = true
        webView.settings.setSupportZoom(false)
        webView.settings.allowContentAccess = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.settings.mediaPlaybackRequiresUserGesture = true
        webView.loadDataWithBaseURL(null, fgklntfrkjgntrjkgnktjr, "text/html", "utf-8", null);
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            true
        } else true
    }
}
