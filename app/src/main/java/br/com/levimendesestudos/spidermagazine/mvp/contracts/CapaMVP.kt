package br.com.levimendesestudos.spidermagazine.mvp.contracts

/**
 * Created by 809778 on 22/08/2017.
 */

interface CapaMVP {

    interface View : BasicView {

        fun carregarCapa()

    }

    interface Presenter : BasicPresenter
}