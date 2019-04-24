package br.com.levimendesestudos.spidermagazine.model

import android.os.Parcel
import android.os.Parcelable

/**
 *
 * Created by 809778 on 21/12/2016.
 *
 */
class Revista : Parcelable {

    var id: Int = 0
    var description: String? = null
    var thumbnailPath: String? = null
    var issueNumber: Int = 0
    var title: String? = null
    var date: String? = null
    var price: Double = 0.toDouble()
    var pageCount: Int = 0

    constructor()

    protected constructor(parcel: Parcel) {
        id = parcel.readInt()
        description = parcel.readString()
        thumbnailPath = parcel.readString()
        issueNumber = parcel.readInt()
        title = parcel.readString()
        date = parcel.readString()
        price = parcel.readDouble()
        pageCount = parcel.readInt()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(description)
        dest.writeString(thumbnailPath)
        dest.writeInt(issueNumber)
        dest.writeString(title)
        dest.writeString(date)
        dest.writeDouble(price)
        dest.writeInt(pageCount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {

        @JvmField
        val CREATOR: Parcelable.Creator<Revista> = object : Parcelable.Creator<Revista> {
            override fun createFromParcel(parcel: Parcel): Revista {
                return Revista(parcel)
            }

            override fun newArray(size: Int): Array<Revista?> {
                return arrayOfNulls(size)
            }
        }
    }
}