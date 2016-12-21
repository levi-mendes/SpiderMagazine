package br.com.levimendesestudos.spidermagazine.api;

import java.util.List;

import br.com.levimendesestudos.spidermagazine.model.Revista;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by 809778 on 21/12/2016.
 */

public interface SpiderApi {

    String URL = "http://gateway.marvel.com:80/v1/public/characters/1009610/";
    //?ts=1&apikey=
    //int TS = 1;
    //String API_KEY = "bb4470a46d0659a43c566ac6056ed48d&hash=479474cf0a28eac9998960da4d96f06b";

    @GET("comics?ts=1&apikey=bb4470a46d0659a43c566ac6056ed48d&hash=479474cf0a28eac9998960da4d96f06b")
    Observable<List<Revista>> comics();
}
