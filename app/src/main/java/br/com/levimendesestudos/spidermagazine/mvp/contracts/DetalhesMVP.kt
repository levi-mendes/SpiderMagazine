package br.com.levimendesestudos.spidermagazine.mvp.contracts

/**
 * Created by 809778 on 21/12/2016.
 */

interface DetalhesMVP {

    abstract class Presenter : BasicPresenter()

    interface View : BasicView {

        fun configToolbar()

        fun chamarTelaCapa()

        fun carregarDados()
    }
}
