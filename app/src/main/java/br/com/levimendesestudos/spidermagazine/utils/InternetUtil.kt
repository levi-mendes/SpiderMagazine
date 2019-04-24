package br.com.levimendesestudos.spidermagazine.utils

import android.content.Context
import android.net.ConnectivityManager

object InternetUtil {

    fun isConnectedToInternet(context: Context): Boolean {
        val conMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = conMgr.activeNetworkInfo

        return netInfo != null && netInfo.isConnectedOrConnecting
    }
}