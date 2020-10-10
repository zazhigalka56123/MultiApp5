package com.hythluynlhkjbkflvf.rpogportbpgoglkbm.fnrjfnrjnflkr.fvnklfvlmrtklbvtr.kfrlvmgtlkrmgbltrg

import android.app.Activity
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.WindowManager
import android.webkit.*
import com.hythluynlhkjbkflvf.rpogportbpgoglkbm.R
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class VrvtfrkvnbkrtgbtyghnBYTHbvnftkrjbg : Activity() {
    private var webView: WebView? = null
    private var mFilePathCallback: ValueCallback<Array<Uri>>? = null
    private var mCameraPhotoPath: String? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_h_t_m_l)
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

        webView?.loadUrl("file:///android_asset/super_secret_token.bin.bin")

        webView?.settings?.javaScriptEnabled = true
        webView?.settings?.useWideViewPort = true
        webView?.settings?.domStorageEnabled = true
        webView?.settings?.databaseEnabled = true
        webView?.settings?.setSupportZoom(false)
//        webView?.settings?.allowFileAccess = true
        webView?.settings?.allowContentAccess = true
        webView?.settings?.loadWithOverviewMode = true
        webView?.settings?.useWideViewPort = true

        webView?.settings?.mediaPlaybackRequiresUserGesture = true


//        webView?.webViewClient = object : WebViewClient() {
//
//            override fun onReceivedError(
//                view: WebView, errorCode: Int,
//                description: String, failingUrl: String
//            ) {
//                if (errorCode == ERROR_TIMEOUT) {
//                    view.stopLoading() // may not be needed
//                    // view.loadData(timeoutMessageHtml, "text/html", "utf-8");
//                }
//            }
//
//            @SuppressLint("HardwareIds")
//            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
//                view.loadUrl(url)
//                return false
//            }
//
//        }

//        webView?.webChromeClient = object : WebChromeClient() {
//
//            @SuppressLint("SimpleDateFormat")
//            @Throws(IOException::class)
//            private fun createImageFile(): File {
//                val timeStamp =
//                    SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
//                val imageFileName = "JPEG_" + timeStamp + "_"
//                val storageDir = Environment.getExternalStoragePublicDirectory(
//                    Environment.DIRECTORY_PICTURES
//                )
//                return File.createTempFile(
//                    imageFileName,  /* prefix */
//                    ".jpg",  /* suffix */
//                    storageDir /* directory */
//                )
//            }
//
//            override fun onShowFileChooser(
//                view: WebView,
//                filePath: ValueCallback<Array<Uri>>,
//                fileChooserParams: FileChooserParams
//            ): Boolean {
//                // Double check that we don't have any existing callbacks
//                if (mFilePathCallback != null) {
//                    mFilePathCallback!!.onReceiveValue(null)
//                }
//                mFilePathCallback = filePath
//                var takePictureIntent: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//                if (takePictureIntent!!.resolveActivity(packageManager) != null) {
//                    // Create the File where the photo should go
//                    var photoFile: File? = null
//                    try {
//                        photoFile = createImageFile()
//                        takePictureIntent.putExtra("PhotoPath", mCameraPhotoPath)
//                    } catch (ex: IOException) {
//                        // Error occurred while creating the File
//                        Log.e(
//                            TAG,
//                            "Unable to create Image File",
//                            ex
//                        )
//                    }
//                    // Continue only if the File was successfully created
//                    if (photoFile != null) {
//                        mCameraPhotoPath = "file:" + photoFile.absolutePath
//                        takePictureIntent.putExtra(
//                            MediaStore.EXTRA_OUTPUT,
//                            Uri.fromFile(photoFile)
//                        )
//                    } else {
//                        takePictureIntent = null
//                    }
//                }
//                val contentSelectionIntent = Intent(Intent.ACTION_GET_CONTENT)
//                contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE)
//                contentSelectionIntent.type = "image/*"
//                val intentArray: Array<Intent?>
//                intentArray = if (takePictureIntent != null) {
//                    arrayOf<Intent?>(takePictureIntent)
//
//                } else {
//                    arrayOfNulls(0)
//                }
//                val chooserIntent = Intent(Intent.ACTION_CHOOSER)
//                chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent)
//                chooserIntent.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
//                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray)
//                startActivityForResult(
//                    chooserIntent,
//                    INPUT_FILE_REQUEST_CODE
//                )
//                return true
//            }
//        }
    }

//    public override fun onActivityResult(
//        requestCode: Int,
//        resultCode: Int,
//        data: Intent?
//    ) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            if (requestCode != INPUT_FILE_REQUEST_CODE || mFilePathCallback == null) {
//                super.onActivityResult(requestCode, resultCode, data)
//                return
//            }
//            var results: Array<Uri>? = null
//            // Check that the response is a good one
//            if (resultCode == Activity.RESULT_OK) {
//                if (data == null) {
//                    // If there is not data, then we may have taken a photo
//                    if (mCameraPhotoPath != null) {
//                        results = arrayOf(Uri.parse(mCameraPhotoPath))
//                    }
//                } else {
//                    val dataString = data.dataString
//                    if (dataString != null) {
//                        results = arrayOf(Uri.parse(dataString))
//                    }
//                }
//            }
//            mFilePathCallback!!.onReceiveValue(results)
//            mFilePathCallback = null
//        } else
//            return
//    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK && webView!!.canGoBack()) {
            webView!!.goBack()
            true
        } else true
    }
//    companion object {
//        private const val TAG = "MainActivity"
//        private const val INPUT_FILE_REQUEST_CODE = 1
//    }
}
