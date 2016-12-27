package br.com.levimendesestudos.spidermagazine.mvp.contracts;

/**
 * Created by 809778 on 27/12/2016.
 */

public interface SobreMVP {

    interface View {
        void adicionarLinkEmail(String titulo, String email);
        void adicionarLink(String titulo, String link);
        void enviarEmail(String email);
        void abrirPagina(String link);
        void adddLinks();
    }

    interface Presenter {
        void init();
    }
}
