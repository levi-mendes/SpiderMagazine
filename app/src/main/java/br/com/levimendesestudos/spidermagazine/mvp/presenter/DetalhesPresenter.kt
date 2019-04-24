package br.com.levimendesestudos.spidermagazine.mvp.presenter

import br.com.levimendesestudos.spidermagazine.mvp.contracts.DetalhesMVP

/**
 * Created by 809778 on 23/12/2016.
 */

class DetalhesPresenter(private val mView: DetalhesMVP.View) : DetalhesMVP.Presenter() {

    override fun init() {
        mView.configToolbar()
        mView.carregarDados()
    }
}