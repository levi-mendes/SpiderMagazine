package br.com.levimendesestudos.spidermagazine.api;

import java.util.Map;

import br.com.levimendesestudos.spidermagazine.model.Hero;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by 809778 on 21/12/2016.
 */

public interface SpiderApi {

    String URL = "http://gateway.marvel.com:80/v1/public/characters/1009610/";
    String CT_APP_JSON = "Content-Type: application/json";

    @Headers(CT_APP_JSON)
    @GET("comics")
    Observable<Hero> comics(@QueryMap Map<String, String> params);
}