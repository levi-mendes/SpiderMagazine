package br.com.levimendesestudos.spidermagazine.api;

import rx.Observable;

/**
 * Created by 809778 on 21/12/2016.
 */

public interface SpiderApi {

    String URL = "http://gateway.marvel.com:80/v1/public/characters/1009610/comics?ts=1&apikey=bb4470a46d0659a43c566ac6056ed48d&hash=479474cf0a28eac9998960da4d96f06b";

    Observable comics();
}
