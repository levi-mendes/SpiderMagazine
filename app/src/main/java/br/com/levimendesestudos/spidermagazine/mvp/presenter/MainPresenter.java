package br.com.levimendesestudos.spidermagazine.mvp.presenter;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import br.com.levimendesestudos.spidermagazine.R;
import br.com.levimendesestudos.spidermagazine.api.SpiderApi;
import br.com.levimendesestudos.spidermagazine.dagger.DaggerInjector;
import br.com.levimendesestudos.spidermagazine.mvp.contracts.MainMVP;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 809778 on 21/12/2016.
 */
public class MainPresenter extends MainMVP.Presenter {

    private MainMVP.View mView;
    @Inject
    SpiderApi mApi;

    public MainPresenter(MainMVP.View view) {
        mView = view;

        DaggerInjector.get().inject(this);
    }

    @Override
    public void init() {
        mView.configToolbar();

        if (!mView.hasInternet()) {
            mView.showSemInternet();
            return;
        }

        mView.showPbProcessamento();

        mApi.comics(params())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(hero -> {

                if (!mView.isActive())
                    return;

                mView.carregarLista(hero.getRevistas());
                mView.copyRight(hero.getCopyright());
                mView.hidePbProcessamento();

            }, error ->  {

                Log.e("onError", error.getMessage(), error);
                mView.showToast(error.getMessage());
            });
    }

    private Map<String, String> params() {
        Map<String, String> params = new HashMap<>();

        params.put("ts",     "1");
        params.put("apikey", "bb4470a46d0659a43c566ac6056ed48d");
        params.put("hash",   "479474cf0a28eac9998960da4d96f06b");

        return params;
    }

    @Override
    public void navigate(int id) {
        switch (id) {
            case R.id.action_profile:
                mView.callSobreActivity();
        }
    }
}
