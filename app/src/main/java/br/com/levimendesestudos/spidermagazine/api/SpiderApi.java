package br.com.levimendesestudos.spidermagazine.api;

import br.com.levimendesestudos.spidermagazine.model.Hero;
import retrofit.http.GET;
import retrofit.http.Headers;
import rx.Observable;

/**
 * Created by 809778 on 21/12/2016.
 */

public interface SpiderApi {

    String URL = "http://gateway.marvel.com:80/v1/public/characters/1009610/";
    String CT_APP_JSON = "Content-Type: application/json";

    @Headers(CT_APP_JSON)
    @GET("comics?ts=1&apikey=bb4470a46d0659a43c566ac6056ed48d&hash=479474cf0a28eac9998960da4d96f06b")
    Observable<Hero> comics();
}