package com.semanienterprise.sbscapplication.users.model

import android.os.Parcelable
import com.semanienterprise.sbscapplication.users.model.Article
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
    var status: String?,
    var totalResults: Int?,
    var articles: List<Article?>?
) : Parcelable