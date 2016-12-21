package br.com.levimendesestudos.spidermagazine.mvp.presenter;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.inject.Inject;

import br.com.levimendesestudos.spidermagazine.api.SpiderApi;
import br.com.levimendesestudos.spidermagazine.dagger.DaggerInjector;
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

        /*
        AsyncTask<Void, Void, String> at = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                String s = null;

                try {
                    URL url = new URL("http://gateway.marvel.com:80/v1/public/characters/1009610/comics?ts=1&apikey=bb4470a46d0659a43c566ac6056ed48d&hash=479474cf0a28eac9998960da4d96f06b");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    s = getStringFromInputStream(in);
                    urlConnection.disconnect();

                } catch (Exception e) {

                } finally {

                }

                return s;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                Log.e("onPost", result);
            }
        };
        at.execute();
        */


        mSpiderApi.comics().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<List<Revista>>() {
            @Override
            public void onCompleted() {
                unsubscribe();
            }

            @Override
            public void onError(Throwable e) {
                Log.e("onError", e.getMessage(), e);
            }

            @Override
            public void onNext(List<Revista> revistas) {
                mView.carregarLista(revistas);
            }
        });
    }

    // convert InputStream to String
    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }
}
