package br.com.levimendesestudos.spidermagazine.mvp.presenter;

import br.com.levimendesestudos.spidermagazine.mvp.contracts.SobreMVP;

/**
 * Created by 809778 on 27/12/2016.
 */

public class SobrePresenter extends SobreMVP.Presenter {

    private SobreMVP.View mView;

    public SobrePresenter(SobreMVP.View view) {
        mView = view;
    }

    @Override
    public void init() {
        mView.configToolbar();
        mView.adddLinks();
        mView.carregarFoto();
    }
}
