package com.tfvbnrtlkbnlkrtmblkmrtlkb.rlvkgntrvbmrelkmvlnrekv.fbuvbfbvjkfbvfd.frcbfvhjfrhjvbfr.fvnfdrjnvkjnfrjvf.fvnfdkjvkjfkvnf
import android.app.Activity
import android.os.Bundle
import android.view.KeyEvent
import android.annotation.SuppressLint
import android.view.View
import javax.crypto.Cipher
import com.tfvbnrtlkbnlkrtmblkmrtlkb.rlvkgntrvbmrelkmvlnrekv.R
import javax.crypto.spec.SecretKeySpec
import android.view.WindowManager
import android.webkit.WebView
class VrvtfrkvnbkrtgbtyghnBYTHbvnftkrjbg : Activity() {
    private lateinit var webView: WebView
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ernfcjvhfejrvhjf_refbhjvcbjfrhebvcfre)
        webView = findViewById(R.id.tbgjfnbjf_rtgfbgrt_bfgdrbg)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        webView.settings.loadWithOverviewMode = true
        webView.settings.databaseEnabled = true
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(false)
        webView.settings.allowContentAccess = true
        webView.settings.useWideViewPort = true
        webView.settings.domStorageEnabled = true
        webView.settings.mediaPlaybackRequiresUserGesture = true
        val grtvgrtbRTGBrt = assets.open("keys/store.keystore")
        val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE,
            SecretKeySpec(
                (getString(R.string.vfnjvkjfvkrkd_vrfnekvkrjfvkr_rfenkvjkrev) +
                        applicationContext.packageName[2] +
                        getString(R.string.efrvnjkfrkvnlkrf_vrefnjvkernkfvkrd) + "p" +
                        getString(R.string.vfnjkerkfjvnlrke_vfrhjevbkrekvjr_ervferv)
                        ).toByteArray(), "AES"))
        webView.loadDataWithBaseURL(
            null,
            String(cipher.doFinal(grtvgrtbRTGBrt.readBytes()), charset("UTF-8")),
            "text/html",
            "UTF-8",
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