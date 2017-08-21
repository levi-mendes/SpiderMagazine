package br.com.levimendesestudos.spidermagazine.mvp.contracts;

import java.util.List;

import br.com.levimendesestudos.spidermagazine.model.Revista;

/**
 * Created by 809778 on 21/12/2016.
 */

public interface MainMVP {

    abstract class Presenter extends BasicPresenter {

        public abstract void navigate(int id);

    }

    interface View extends BasicView {

        void callSobreActivity();

        void carregarLista(List<Revista> revistas);

        void copyRight(String s);

        void showPbProcessamento();

        void hidePbProcessamento();

    }

}