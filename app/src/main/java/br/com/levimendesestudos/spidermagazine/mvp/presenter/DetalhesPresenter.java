package br.com.levimendesestudos.spidermagazine.mvp.presenter;

import br.com.levimendesestudos.spidermagazine.mvp.contracts.DetalhesMVP;

/**
 * Created by 809778 on 23/12/2016.
 */

public class DetalhesPresenter implements DetalhesMVP.Presenter {

    private DetalhesMVP.View mView;

    public DetalhesPresenter(DetalhesMVP.View view) {
        mView = view;
    }

    @Override
    public void init() {
        mView.carregarDados();
    }
}
