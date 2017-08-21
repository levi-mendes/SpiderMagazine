package br.com.levimendesestudos.spidermagazine.model;

import java.io.Serializable;

/**
 *
 * Created by 809778 on 21/12/2016.
 *
 */
public class Revista implements Serializable {

    private static final long serialVersionUID = 691979549617824460L;

    public int id;
    public String description;
    public String thumbnailPath;
    public int issueNumber;

    public String title;
    public String date;
    public double price;
    public int pageCount;
}