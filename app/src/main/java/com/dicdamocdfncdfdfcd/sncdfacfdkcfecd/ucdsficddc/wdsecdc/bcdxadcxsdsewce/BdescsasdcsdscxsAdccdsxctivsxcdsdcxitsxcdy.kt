package com.dicdamocdfncdfdfcd.sncdfacfdkcfecd.ucdsficddc.wdsecdc.bcdxadcxsdsewce

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.view.Window
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.dicdamocdfncdfdfcd.sncdfacfdkcfecd.R


open class BdescsasdcsdscxsAdccdsxctivsxcdsdcxitsxcdy : Activity() {
    private val keyboardLayoutListener = OnGlobalLayoutListener {
        val heightDiff = rootLayout!!.rootView.height - rootLayout!!.height
        val contentViewTop =
            window.findViewById<View>(Window.ID_ANDROID_CONTENT).top
        val broadcastManager =
            LocalBroadcastManager.getInstance(this@BdescsasdcsdscxsAdccdsxctivsxcdsdcxitsxcdy)
        if (heightDiff <= contentViewTop) {
            onHideKeyboard()
            val intent = Intent("KeyboardWillHide")
            broadcastManager.sendBroadcast(intent)
        } else {
            val keyboardHeight = heightDiff - contentViewTop
            onShowKeyboard(keyboardHeight)
            val intent = Intent("KeyboardWillShow")
            intent.putExtra("KeyboardHeight", keyboardHeight)
            broadcastManager.sendBroadcast(intent)
        }
    }
    private var keyboardListenersAttached = false
    private var rootLayout: ViewGroup? = null
    protected open fun onShowKeyboard(keyboardHeight: Int) {}
    protected open fun onHideKeyboard() {}
    protected fun attachKeyboardListeners() {
        if (keyboardListenersAttached) {
            return
        }
        rootLayout = findViewById<View>(R.id.rootLayout) as ViewGroup
        rootLayout!!.viewTreeObserver.addOnGlobalLayoutListener(keyboardLayoutListener)
        keyboardListenersAttached = true
    }

    override fun onDestroy() {
        super.onDestroy()
        if (keyboardListenersAttached) {
            rootLayout!!.viewTreeObserver.removeGlobalOnLayoutListener(keyboardLayoutListener)
        }
    }
}