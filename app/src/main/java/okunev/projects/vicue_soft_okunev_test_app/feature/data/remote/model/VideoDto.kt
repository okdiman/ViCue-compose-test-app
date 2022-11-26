package okunev.projects.vicue_soft_okunev_test_app.feature.data.remote.model

import com.google.gson.annotations.SerializedName

data class VideoDto(
    @SerializedName("file_url")
    val videoUrl: String,
    @SerializedName("poster_url")
    val posterUrl: String
)