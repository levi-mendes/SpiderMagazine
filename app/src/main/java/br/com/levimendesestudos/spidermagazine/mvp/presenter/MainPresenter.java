package br.com.levimendesestudos.spidermagazine.mvp.presenter;

import android.util.Log;
import javax.inject.Inject;

import br.com.levimendesestudos.spidermagazine.R;
import br.com.levimendesestudos.spidermagazine.api.SpiderApi;
import br.com.levimendesestudos.spidermagazine.dagger.DaggerInjector;
import br.com.levimendesestudos.spidermagazine.model.Hero;
import br.com.levimendesestudos.spidermagazine.mvp.contracts.MainMVP;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 809778 on 21/12/2016.
 */

public class MainPresenter extends MainMVP.Presenter {

    private MainMVP.View mView;
    @Inject
    SpiderApi mSpiderApi;

    public MainPresenter(MainMVP.View view) {
        this.mView = view;

        DaggerInjector.get().inject(this);
    }

    @Override
    public void init() {
        mView.showPbProcessamento();

        mSpiderApi.comics()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<Hero>() {
                @Override
                public void onCompleted() {
                    unsubscribe();
                }

                @Override
                public void onError(Throwable e) {
                    unsubscribe();
                    Log.e("onError", e.getMessage(), e);
                }

                @Override
                public void onNext(Hero hero) {
                    if (!mView.isActive())
                        return;

                    mView.carregarLista(hero.revistas);
                    mView.copyRight(hero.copyright);
                    mView.hidePbProcessamento();
                }
            });
    }

    @Override
    public void navigate(int id) {
        switch (id) {
            case R.id.action_profile:
                mView.callSobreActivity();
        }
    }
}
