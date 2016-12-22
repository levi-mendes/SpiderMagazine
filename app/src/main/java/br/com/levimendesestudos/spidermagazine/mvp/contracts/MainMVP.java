package br.com.levimendesestudos.spidermagazine.mvp.contracts;

import java.util.List;

import br.com.levimendesestudos.spidermagazine.model.Revista;

/**
 * Created by 809778 on 21/12/2016.
 */

public interface MainMVP {

    interface Presenter {
        void init();
    }

    interface View {
        void carregarLista(List<Revista> revistas);
        void copyRight(String s);
        void showPbProcessamento();
        void hidePbProcessamento();
    }
}
