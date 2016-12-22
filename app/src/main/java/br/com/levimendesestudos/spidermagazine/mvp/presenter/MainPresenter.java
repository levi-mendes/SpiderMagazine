package br.com.levimendesestudos.spidermagazine.mvp.presenter;

import android.util.Log;
import java.util.List;
import javax.inject.Inject;
import br.com.levimendesestudos.spidermagazine.api.SpiderApi;
import br.com.levimendesestudos.spidermagazine.dagger.DaggerInjector;
import br.com.levimendesestudos.spidermagazine.model.Hero;
import br.com.levimendesestudos.spidermagazine.model.Revista;
import br.com.levimendesestudos.spidermagazine.mvp.contracts.MainMVP;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 809778 on 21/12/2016.
 */

public class MainPresenter implements MainMVP.Presenter {

    private MainMVP.View mView;
    @Inject
    SpiderApi mSpiderApi;

    public MainPresenter(MainMVP.View view) {
        this.mView = view;

        DaggerInjector.get().inject(this);
    }

    @Override
    public void buscarRevistas() {
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
                    mView.carregarLista(hero.revistas);
                    mView.copyRight(hero.copyright);
                }
            });
    }
}
