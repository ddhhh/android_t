package com.dhh.audition.multprocess_messenger

import android.os.Parcel
import android.os.Parcelable

data class MultiBean(val str: String) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(str)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MultiBean> = object : Parcelable.Creator<MultiBean> {
            override fun createFromParcel(source: Parcel): MultiBean = MultiBean(source)
            override fun newArray(size: Int): Array<MultiBean?> = arrayOfNulls(size)
        }
    }
}