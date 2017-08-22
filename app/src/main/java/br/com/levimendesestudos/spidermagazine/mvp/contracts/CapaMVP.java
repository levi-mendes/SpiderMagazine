package br.com.levimendesestudos.spidermagazine.mvp.contracts;

/**
 * Created by 809778 on 22/08/2017.
 */

public interface CapaMVP {

    interface View extends BasicView {

        void carregarCapa();

    }

    abstract class Presenter extends BasicPresenter {

    }
}