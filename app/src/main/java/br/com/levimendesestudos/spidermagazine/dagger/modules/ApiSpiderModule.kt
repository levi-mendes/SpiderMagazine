package br.com.levimendesestudos.spidermagazine.dagger.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import br.com.levimendesestudos.spidermagazine.api.SpiderApi
import br.com.levimendesestudos.spidermagazine.deserializers.RevistaDeserializer
import br.com.levimendesestudos.spidermagazine.model.Hero
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by 809778 on 21/12/2016.
 */

@Module
class ApiSpiderModule {

    @Provides
    fun providesSpiderApi(retrofit: Retrofit): SpiderApi {
        return retrofit.create(SpiderApi::class.java)
    }

    @Provides
    fun providesRetrofit(converter: GsonConverterFactory, okHttpClient: OkHttpClient, endPoint: String, factory: RxJavaCallAdapterFactory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(endPoint)
                .client(okHttpClient)
                .addConverterFactory(converter)
                .addCallAdapterFactory(factory)
                .build()
    }

    @Provides
    fun providesFactory(): RxJavaCallAdapterFactory {
        return RxJavaCallAdapterFactory.create()
    }

    @Provides
    fun providesEndPoint(): String {
        return SpiderApi.URL
    }

    @Provides
    fun providesConverter(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    fun providesGson(builder: GsonBuilder): Gson {
        return builder.create()
    }

    @Provides
    fun providesGsonBuilder(deserializer: RevistaDeserializer): GsonBuilder {
        return GsonBuilder().registerTypeAdapter(Hero::class.java, deserializer)
    }

    @Provides
    fun providesDeserializer(): RevistaDeserializer {
        return RevistaDeserializer()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        //altera timeout para 30 segundos

        return OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()
    }
}