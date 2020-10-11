package com.hythluynlhkjbkflvf.rpogportbpgoglkbm.fnrjfnrjnflkr.fvnklfvlmrtklbvtr.kfrlvmgtlkrmgbltrg

import android.app.Activity
import android.os.Bundle
import android.view.KeyEvent
import android.annotation.SuppressLint
import android.view.View
import com.hythluynlhkjbkflvf.rpogportbpgoglkbm.R
import android.view.WindowManager
import android.webkit.WebView
import java.io.InputStream
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

class VrvtfrkvnbkrtgbtyghnBYTHbvnftkrjbg : Activity() {
    private lateinit var webView: WebView
    private val rtvggrbjgtbRTGbrtb = "MrW"
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nfrvekjvgrkjvt_vbtgrnbkvjgtkbj)
        webView = findViewById(R.id.web_view_html)
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
        webView.settings.mediaPlaybackRequiresUserGesture = true
        val TgtrbGRTBTgrybtgybBTRGbgrtb =
            getString(R.string.tgrbgtb_bgtybtgyb_bgtbgbgb_nytynyuny_nytgntyn) +
                    rtvggrbjgtbRTGbrtb +
                    getString(R.string.tgnvrtjnbvgtjrnbjgt_bgtbngtjnbgtb_bgthibngt) +
                    "a"
        val grtvgrtbRTGBrt: InputStream = assets.open("token.key")
        val cipher: Cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(TgtrbGRTBTgrybtgybBTRGbgrtb.toByteArray(), "AES"))
        webView.loadDataWithBaseURL(
            null,
            String(cipher.doFinal(grtvgrtbRTGBrt.readBytes()), charset("UTF-8")),
            "text/html",
            "utf-8",
            null
        )
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            true
        } else true
    }
}