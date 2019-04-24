package br.com.levimendesestudos.spidermagazine.activities

import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import br.com.levimendesestudos.spidermagazine.mvp.contracts.BasicView
import br.com.levimendesestudos.spidermagazine.utils.ToastUtil
import br.com.levimendesestudos.spidermagazine.utils.InternetUtil.isConnectedToInternet

/**
 * Created by 809778 on 23/12/2016.
 */
abstract class BaseActivity : AppCompatActivity(), BasicView {

    override fun hasInternet(): Boolean {
        return isConnectedToInternet(this)
    }

    override fun showToast(msg: String) {
        ToastUtil.showToast(this, msg)
    }

    override fun showToast(@StringRes msg: Int) {
        ToastUtil.showToast(this, getString(msg))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            // Respond to the action bar's Up/Home button
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun isActive(): Boolean {
        return !isDestroyed
    }
}