package br.com.levimendesestudos.spidermagazine

import android.app.Application
import br.com.levimendesestudos.spidermagazine.koin.spiderModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SpiderApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // start Koin!
        startKoin {
            // Android context
            androidContext(this@SpiderApplication)
            // modules
            modules(spiderModule)
        }
    }
}