package okunev.projects.vicue_soft_okunev_test_app.di

import okhttp3.OkHttpClient
import okunev.projects.vicue_soft_okunev_test_app.core.RetrofitProvider
import okunev.projects.vicue_soft_okunev_test_app.feature.data.mapper.VideoModelMapper
import okunev.projects.vicue_soft_okunev_test_app.feature.data.remote.VideoApi
import okunev.projects.vicue_soft_okunev_test_app.feature.data.remote.VideoRepositoryImpl
import okunev.projects.vicue_soft_okunev_test_app.feature.domain.VideoRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val mainModule = module {
    single { OkHttpClient.Builder().build() }
    single { RetrofitProvider(get()).provide() }
    single<VideoApi> { get<Retrofit>().create() }
    factory<VideoRepository> { VideoRepositoryImpl(get(), get()) }
    factory { VideoModelMapper() }
}