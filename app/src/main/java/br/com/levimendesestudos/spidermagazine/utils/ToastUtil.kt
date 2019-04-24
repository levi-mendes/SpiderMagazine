package br.com.levimendesestudos.spidermagazine.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by 809778 on 22/12/2016.
 */

object ToastUtil {

    fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    fun showToast(context: Context, idMsg: Int) {
        Toast.makeText(context, idMsg, Toast.LENGTH_LONG).show()
    }
}
