package br.com.levimendesestudos.spidermagazine.mvp.presenter;

import br.com.levimendesestudos.spidermagazine.mvp.contracts.CapaMVP;

/**
 * Created by 809778 on 22/08/2017.
 */

public class CapaPresenter extends CapaMVP.Presenter {

    CapaMVP.View mView;

    public CapaPresenter(CapaMVP.View view) {
        mView = view;
    }

    @Override
    public void init() {
        mView.carregarCapa();
    }
}
