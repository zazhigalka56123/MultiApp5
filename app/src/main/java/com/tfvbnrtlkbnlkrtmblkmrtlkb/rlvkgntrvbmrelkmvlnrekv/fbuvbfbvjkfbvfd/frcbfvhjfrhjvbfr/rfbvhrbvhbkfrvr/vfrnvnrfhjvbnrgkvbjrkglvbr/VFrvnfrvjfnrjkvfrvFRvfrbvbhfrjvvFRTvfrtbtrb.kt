package com.tfvbnrtlkbnlkrtmblkmrtlkb.rlvkgntrvbmrelkmvlnrekv.fbuvbfbvjkfbvfd.frcbfvhjfrhjvbfr.rfbvhrbvhbkfrvr.vfrnvnrfhjvbnrgkvbjrkglvbr

import android.net.ConnectivityManager
import android.app.AlertDialog
import android.app.Activity
import android.os.Bundle
import com.tfvbnrtlkbnlkrtmblkmrtlkb.rlvkgntrvbmrelkmvlnrekv.fbuvbfbvjkfbvfd.frcbfvhjfrhjvbfr.rfbvhrbvhbkfrvr.fvrnvkjnfrkjvnkjrtnvkrft.VGFrvgfrjnvkjfrtvbrTBVrgtbrt
import android.content.Context
import android.content.Intent
import com.tfvbnrtlkbnlkrtmblkmrtlkb.rlvkgntrvbmrelkmvlnrekv.R

class VFrvnfrvjfnrjkvfrvFRvfrbvbhfrjvvFRTvfrtbtrb : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.efbdjhcvfjehvbhjfd_rfvchjefrbvjhcfrejerf)
        showInfoMessageDialog("Check your internet connection and try again")
    }
    private fun isNetworkAvailable(): Boolean {
        println("isNetworkAvailable2 called")
        val info = (applicationContext
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            .activeNetworkInfo
        return !(info == null || !info.isAvailable || !info.isConnected)
    }
    private fun showInfoMessageDialog(message: String) {
        val alertDialog = AlertDialog.Builder(
            this
        ).create()
        alertDialog.setTitle("Connectivity")
        alertDialog.setMessage(message)
        alertDialog.setCancelable(false)
        alertDialog.setButton(
            "Refresh the App"
        ) { dialog, _ ->
            if (!isNetworkAvailable()) {
                showInfoMessageDialog("Check your internet connection and try again!")
            } else {
                val intent =
                    Intent(this, VGFrvgfrjnvkjfrtvbrTBVrgtbrt::class.java)
                startActivity(intent)
                finish()
            }
            dialog.cancel()
        }
        alertDialog.show()
    }
}