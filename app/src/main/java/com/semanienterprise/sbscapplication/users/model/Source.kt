package com.semanienterprise.sbscapplication.users.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Source(
    var id: String?,
    var name: String?
) : Parcelable