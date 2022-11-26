package okunev.projects.vicue_soft_okunev_test_app.feature.data.mapper

import okunev.projects.vicue_soft_okunev_test_app.feature.data.remote.model.VideoDto
import okunev.projects.vicue_soft_okunev_test_app.feature.domain.model.VideoModel

class VideoModelMapper {
    fun map(videos: List<VideoDto>): List<VideoModel> {
        return videos.map { dto ->
            VideoModel(
                dto.videoUrl,
                dto.posterUrl
            )
        }
    }
}