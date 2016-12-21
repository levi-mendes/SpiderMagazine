package br.com.levimendesestudos.spidermagazine.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * Created by 809778 on 21/12/2016.
 *
 */
public class Revista {

    @SerializedName("id")
    public int id;
    @SerializedName("description")
    public String description;
    @SerializedName("thumbnail")
    public Thumbnail thumbnail;

    class Thumbnail {

        @SerializedName("path")
        public String path;
        @SerializedName("extension")
        public String extension;
    }
}