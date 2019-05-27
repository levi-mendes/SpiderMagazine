package br.com.levimendesestudos.spidermagazine.api

import br.com.levimendesestudos.spidermagazine.model.Hero
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap
import rx.Observable

interface SpiderApiDef {

    @Headers(CT_APP_JSON)
    @GET("comics")
    fun comics(@QueryMap params: Map<String, String>): Observable<Hero>

    companion object {

        const val URL = "http://gateway.marvel.com:80/v1/public/characters/1009610/"
        const val CT_APP_JSON = "Content-Type: application/json"
    }
}