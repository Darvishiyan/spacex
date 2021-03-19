package com.darvishiyan.spacex.dataaccess.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Launch(
    @SerializedName("launchpad") val launchpad: String?,
    @SerializedName("payloads") val payloads: List<String>?,
    @SerializedName("rocket") val rocket: String?,
    @SerializedName("date_unix") val dateUnix: Int?,
    @SerializedName("cores") val cores: List<CoresItem>?,
    @SerializedName("auto_update") val autoUpdate: Boolean?,
    @SerializedName("date_precision") val datePrecision: String?,
    @SerializedName("links") val links: Links?,
    @SerializedName("details") val details: String?,
    @SerializedName("id") val id: String?,
    @SerializedName("net") val net: Boolean?,
    @SerializedName("capsules") val capsules: List<String>?,
    @SerializedName("static_fire_date_utc") val staticFireDateUtc: String?,
    @SerializedName("date_local") val dateLocal: String?,
    @SerializedName("flight_number") val flightNumber: Int?,
    @SerializedName("tdb") val tdb: Boolean?,
    @SerializedName("date_utc") val dateUtc: String?,
    @SerializedName("static_fire_date_unix") val staticFireDateUnix: Int?,
    @SerializedName("success") val success: Boolean?,
    @SerializedName("name") val name: String?,
    @SerializedName("window") val window: Int?,
    @SerializedName("upcoming") val upcoming: Boolean?
) : Parcelable

@Parcelize
data class CoresItem(
    @SerializedName("core") val core: String?,
    @SerializedName("flight") val flight: Int?,
    @SerializedName("landing_type") val landingType: String?,
    @SerializedName("gridfins") val gridfins: Boolean?,
    @SerializedName("landing_attempt") val landingAttempt: Boolean?,
    @SerializedName("legs") val legs: Boolean?,
    @SerializedName("landpad") val landpad: String?,
    @SerializedName("reused") val reused: Boolean?,
    @SerializedName("landing_success") val landingSuccess: Boolean?
) : Parcelable

@Parcelize
data class Links(
    @SerializedName("patch") val patch: Patch?,
    @SerializedName("webcast") val webcast: String? = "",
    @SerializedName("flickr") val flickr: Flickr?,
    @SerializedName("reddit") val reddit: Reddit?,
    @SerializedName("wikipedia") val wikipedia: String?,
    @SerializedName("youtube_id") val youtubeId: String?,
    @SerializedName("presskit") val presskit: String?,
    @SerializedName("article") val article: String?
) : Parcelable

@Parcelize
data class Patch(
    @SerializedName("small") val small: String?,
    @SerializedName("large") val large: String?
) : Parcelable

@Parcelize
data class Flickr(
    @SerializedName("original") val original: List<String>?
) : Parcelable

@Parcelize
data class Reddit(
    @SerializedName("campaign") val campaign: String?,
    @SerializedName("launch") val launch: String?,
    @SerializedName("media") val media: String?,
) : Parcelable


