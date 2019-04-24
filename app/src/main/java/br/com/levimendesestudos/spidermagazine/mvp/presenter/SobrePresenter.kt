package br.com.levimendesestudos.spidermagazine.mvp.presenter

import br.com.levimendesestudos.spidermagazine.mvp.contracts.SobreMVP

/**
 * Created by 809778 on 27/12/2016.
 */

class SobrePresenter(private val mView: SobreMVP.View) : SobreMVP.Presenter() {

    override fun init() {
        mView.configToolbar()
        mView.adddLinks()
        mView.carregarFoto()
    }
}