package okunev.projects.vicue_soft_okunev_test_app.feature.data.remote

import okunev.projects.vicue_soft_okunev_test_app.feature.data.mapper.VideoModelMapper
import okunev.projects.vicue_soft_okunev_test_app.feature.domain.VideoRepository
import okunev.projects.vicue_soft_okunev_test_app.feature.domain.model.VideoModel

class VideoRepositoryImpl(
    private val api: VideoApi,
    private val mapper: VideoModelMapper
) : VideoRepository {
    override suspend fun fetchAllVideos(): List<VideoModel> {
        val videos = api.fetchVideos(
            group = GROUP_NAME_TEST,
            categoryID = CATEGORY_ID_TEST
        )
        return mapper.map(videos)
    }

    private companion object {
        const val GROUP_NAME_TEST = "video"
        const val CATEGORY_ID_TEST = "1"
    }
}