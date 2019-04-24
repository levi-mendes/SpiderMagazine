package br.com.levimendesestudos.spidermagazine.mvp.contracts

/**
 * Created by 809778 on 27/12/2016.
 */

interface SobreMVP {

    interface View : BasicView {

        fun adicionarLinkEmail(titulo: String, email: String)

        fun adicionarLink(titulo: String, link: String)

        fun enviarEmail(email: String)

        fun abrirPagina(link: String)

        fun adddLinks()

        fun configToolbar()

        fun carregarFoto()
    }

    interface Presenter : BasicPresenter
}