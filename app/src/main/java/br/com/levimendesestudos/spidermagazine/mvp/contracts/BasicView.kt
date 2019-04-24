package br.com.levimendesestudos.spidermagazine.mvp.contracts

/**
 * Created by 809778 on 21/08/2017.
 */

interface BasicView {

    fun active(): Boolean

    fun showToast(msg: String)

    fun showToast(msg: Int)

    fun hasInternet(): Boolean

}