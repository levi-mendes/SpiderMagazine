package br.com.levimendesestudos.spidermagazine.koin

import br.com.levimendesestudos.spidermagazine.api.SpiderApiDef
import com.google.gson.GsonBuilder
import java.util.concurrent.TimeUnit
import br.com.levimendesestudos.spidermagazine.deserializers.RevistaDeserializer
import br.com.levimendesestudos.spidermagazine.model.Hero
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by 809778 on 21/12/2016.
 */
class ApiSpiderModule {

    fun providesSpiderApi(): SpiderApiDef {
        return providesRetrofit().create(SpiderApiDef::class.java)
    }

    private fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(SpiderApiDef.URL)
                .client(okHttpClient())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().registerTypeAdapter(Hero::class.java, RevistaDeserializer()).create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }

    private fun okHttpClient(): OkHttpClient {
        //altera timeout para 30 segundos

        return OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()
    }
}