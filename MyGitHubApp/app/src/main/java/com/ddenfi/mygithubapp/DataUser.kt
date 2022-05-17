package com.ddenfi.mygithubapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataUser(
    var username: String?,
    var user: String?,
    var photo: Int,
    var location: String?,
    var repository: String?,
    var company: String?,
    var followers: String?,
    var following: String?,
): Parcelable
