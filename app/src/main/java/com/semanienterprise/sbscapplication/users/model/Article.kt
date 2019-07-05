package com.semanienterprise.sbscapplication.users.model

import android.os.Parcelable
import com.semanienterprise.sbscapplication.users.model.Source
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    var author: String?,
    var content: String?,
    var description: String?,
    var publishedAt: String?,
    var source: Source?,
    var title: String?,
    var url: String?,
    var urlToImage: String?
) : Parcelable