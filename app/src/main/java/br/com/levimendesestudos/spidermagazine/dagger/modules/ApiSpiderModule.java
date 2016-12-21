package br.com.levimendesestudos.spidermagazine.dagger.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import br.com.levimendesestudos.spidermagazine.api.SpiderApi;
import br.com.levimendesestudos.spidermagazine.deserializers.RevistaDeserializer;
import br.com.levimendesestudos.spidermagazine.model.Revista;
import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by 809778 on 21/12/2016.
 */

@Module
public class ApiSpiderModule {

    @Provides
    @Singleton
    SpiderApi providesSpiderApi() {
        Gson gson = new GsonBuilder().registerTypeAdapter(Revista.class, new RevistaDeserializer()).create();

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(SpiderApi.URL)
                .client(providesOkHttoClient())
                //.addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(SpiderApi.class);
    }


    /*
        Gson gson = new GsonBuilder().registerTypeAdapter(Revista.class, new RevistaDeserializer()).create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GoogleApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
     */

    @Provides
    @Singleton
    public OkHttpClient providesOkHttoClient() {
        //altera timeout para 30 segundos
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(30,    TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(30, TimeUnit.SECONDS);
        okHttpClient.networkInterceptors().add(chain -> {
            Request request = chain
                    .request()
                    .newBuilder()
                    .build();
            return chain.proceed(request);
        });

        return okHttpClient;
    }
}