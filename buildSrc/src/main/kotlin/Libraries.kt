object Libraries {
    object Compose {
        private const val version = "1.3.1"
        const val ui = "androidx.compose.ui:ui:$version"
        const val tooling = "androidx.compose.ui:ui-tooling-preview:$version"
        const val material = "androidx.compose.material:material:$version"
    }

    object ExoPlayer {
        private const val version = "1.0.0-beta03"
        const val core = "androidx.media3:media3-exoplayer:$version"
        const val ui = "androidx.media3:media3-ui:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val core = "com.squareup.retrofit2:retrofit:$version"
        const val converter = "com.squareup.retrofit2:converter-gson:$version"
    }

    object Koin {
        private const val version = "3.2.2"
        const val core = "io.insert-koin:koin-core:$version"
        const val android = "io.insert-koin:koin-android:$version"
    }

    object Coil {
        private const val version = "2.2.2"
        const val core = "io.coil-kt:coil:$version"
        const val compose = "io.coil-kt:coil-compose:$version"
    }

    object KViewModel {
        private const val version = "0.11"
        const val core = "com.adeo:kviewmodel:$version"
        const val compose = "com.adeo:kviewmodel-compose:$version"
    }

    object Core {
        const val ktx = "androidx.core:core-ktx:1.9.0"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
        const val composeActivity = "androidx.activity:activity-compose:1.6.1"
    }
}