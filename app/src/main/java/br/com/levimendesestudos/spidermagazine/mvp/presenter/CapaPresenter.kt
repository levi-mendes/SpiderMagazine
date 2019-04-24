package br.com.levimendesestudos.spidermagazine.mvp.presenter

import br.com.levimendesestudos.spidermagazine.mvp.contracts.CapaMVP

/**
 * Created by 809778 on 22/08/2017.
 */

class CapaPresenter(private val mView: CapaMVP.View) : CapaMVP.Presenter {

    override fun init() {
        mView.carregarCapa()
    }
}