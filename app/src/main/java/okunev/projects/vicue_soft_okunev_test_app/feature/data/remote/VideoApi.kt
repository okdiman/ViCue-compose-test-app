package okunev.projects.vicue_soft_okunev_test_app.feature.data.remote

import okunev.projects.vicue_soft_okunev_test_app.feature.data.remote.model.VideoDto
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoApi {
    @GET("api/backgrounds")
    suspend fun fetchVideos(
        @Query("group") group: String,
        @Query("category_id") categoryID: String
    ): List<VideoDto>
}