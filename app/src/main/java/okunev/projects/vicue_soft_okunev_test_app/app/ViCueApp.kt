package okunev.projects.vicue_soft_okunev_test_app.app

import android.app.Application
import okunev.projects.vicue_soft_okunev_test_app.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ViCueApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ViCueApp)
            modules(mainModule)
        }
    }
}