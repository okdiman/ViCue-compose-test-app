package okunev.projects.vicue_soft_okunev_test_app.feature.domain

import okunev.projects.vicue_soft_okunev_test_app.feature.domain.model.VideoModel

interface VideoRepository {
    suspend fun fetchAllVideos(): List<VideoModel>
}