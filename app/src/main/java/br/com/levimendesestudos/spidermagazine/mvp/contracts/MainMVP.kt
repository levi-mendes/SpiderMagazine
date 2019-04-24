package br.com.levimendesestudos.spidermagazine.mvp.contracts

import br.com.levimendesestudos.spidermagazine.model.Revista

/**
 * Created by 809778 on 21/12/2016.
 */

interface MainMVP {

    abstract class Presenter : BasicPresenter() {

        abstract fun navigate(id: Int)

    }

    interface View : BasicView {

        fun configToolbar()

        fun callSobreActivity()

        fun carregarLista(revistas: List<Revista>)

        fun copyRight(s: String)

        fun showPbProcessamento()

        fun hidePbProcessamento()

        fun showSemInternet()

        fun hideSemInternet()

    }

}