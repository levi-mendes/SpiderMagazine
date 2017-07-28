package br.com.levimendesestudos.spidermagazine.dagger.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import br.com.levimendesestudos.spidermagazine.api.SpiderApi;
import br.com.levimendesestudos.spidermagazine.deserializers.RevistaDeserializer;
import br.com.levimendesestudos.spidermagazine.model.Hero;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 809778 on 21/12/2016.
 */

@Module
public class ApiSpiderModule {

    @Provides
    public SpiderApi providesSpiderApi(Retrofit retrofit) {
        return retrofit.create(SpiderApi.class);
    }

    @Provides
    public Retrofit providesRetrofit(GsonConverterFactory converter, OkHttpClient okHttpClient, String endPoint, RxJavaCallAdapterFactory factory) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endPoint)
                .client(okHttpClient)
                .addConverterFactory(converter)
                .addCallAdapterFactory(factory)
                .build();

        return retrofit;
    }

    @Provides
    public RxJavaCallAdapterFactory providesFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    public String providesEndPoint() {
        return SpiderApi.URL;
    }

    @Provides
    public GsonConverterFactory providesConverter(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    public Gson providesGson(GsonBuilder builder) {
        return builder.create();
    }

    @Provides
    public GsonBuilder providesGsonBuilder(RevistaDeserializer deserializer) {
        return new GsonBuilder().registerTypeAdapter(Hero.class, deserializer);
    }

    @Provides
    public RevistaDeserializer providesDeserializer() {
        return new RevistaDeserializer();
    }

    @Provides
    @Singleton
    public OkHttpClient providesOkHttpClient() {
        //altera timeout para 30 segundos
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(30,    TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();

        return okHttpClient;
    }
}