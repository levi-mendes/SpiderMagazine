package br.com.levimendesestudos.spidermagazine.mvp.contracts;

/**
 * Created by 809778 on 21/12/2016.
 */

public interface DetalhesMVP {

    abstract class Presenter extends BasicPresenter {

    }

    interface View extends BasicView {

        void chamarTelaCapa();

        void carregarDados();
    }
}
