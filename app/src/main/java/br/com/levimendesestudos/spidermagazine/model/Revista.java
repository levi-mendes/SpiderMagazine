package br.com.levimendesestudos.spidermagazine.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 * Created by 809778 on 21/12/2016.
 *
 */
public class Revista implements Parcelable {

    public int id;
    public String description;
    public String thumbnailPath;
    public int issueNumber;
    public String title;
    public String date;
    public double price;
    public int pageCount;

    public Revista() {}

    protected Revista(Parcel in) {
        id = in.readInt();
        description = in.readString();
        thumbnailPath = in.readString();
        issueNumber = in.readInt();
        title = in.readString();
        date = in.readString();
        price = in.readDouble();
        pageCount = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(description);
        dest.writeString(thumbnailPath);
        dest.writeInt(issueNumber);
        dest.writeString(title);
        dest.writeString(date);
        dest.writeDouble(price);
        dest.writeInt(pageCount);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Revista> CREATOR = new Creator<Revista>() {
        @Override
        public Revista createFromParcel(Parcel in) {
            return new Revista(in);
        }

        @Override
        public Revista[] newArray(int size) {
            return new Revista[size];
        }
    };
}