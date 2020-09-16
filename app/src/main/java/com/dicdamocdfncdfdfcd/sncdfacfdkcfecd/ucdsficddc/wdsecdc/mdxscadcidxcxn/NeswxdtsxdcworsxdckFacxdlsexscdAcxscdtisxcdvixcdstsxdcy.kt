package com.dicdamocdfncdfdfcd.sncdfacfdkcfecd.ucdsficddc.wdsecdc.mdxscadcidxcxn

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import com.dicdamocdfncdfdfcd.sncdfacfdkcfecd.R
import com.dicdamocdfncdfdfcd.sncdfacfdkcfecd.ucdsficddc.wdsecdc.bcdxadcxsdsewce.BdescsasdcsdscxsAdccdsxctivsxcdsdcxitsxcdy

class NeswxdtsxdcworsxdckFacxdlsexscdAcxscdtisxcdvixcdstsxdcy : BdescsasdcsdscxsAdccdsxctivsxcdsdcxitsxcdy() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aswdctidxscvitxdcy_netcdwdcork_facdcfdlsxdsce)
        showInfoMessageDialog("Check your internet connection and try again")
    }

    private fun isNetworkAvailable2(): Boolean {
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
            println("page loading started")
            if (!isNetworkAvailable2()) {
                showInfoMessageDialog("Check your internet connection and try again")
            } else {
                val intent =
                    Intent(this, MsxdaisxdcnAsxdcctisxdity::class.java)
                startActivity(intent)
                finish()
            }
            dialog.cancel()
        }
        alertDialog.show()
    }
}
