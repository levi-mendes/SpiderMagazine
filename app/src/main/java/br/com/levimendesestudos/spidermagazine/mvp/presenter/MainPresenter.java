package br.com.levimendesestudos.spidermagazine.mvp.presenter;

import android.util.Log;
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
        mView.showPbProcessamento();

        mApi.comics()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(hero -> {

                if (!mView.isActive())
                    return;

                mView.carregarLista(hero.revistas);
                mView.copyRight(hero.copyright);
                mView.hidePbProcessamento();

            }, error ->  {

                Log.e("onError", error.getMessage(), error);
                mView.showToast(error.getMessage());
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
