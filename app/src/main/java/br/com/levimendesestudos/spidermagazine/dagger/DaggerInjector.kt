package br.com.levimendesestudos.spidermagazine.dagger

import br.com.levimendesestudos.spidermagazine.dagger.components.AppComponent
import br.com.levimendesestudos.spidermagazine.dagger.components.DaggerAppComponent
import br.com.levimendesestudos.spidermagazine.dagger.modules.ApiSpiderModule

object DaggerInjector {

    private val appComponent = DaggerAppComponent.builder().apiSpiderModule(ApiSpiderModule()).build()

    fun get(): AppComponent {
        return appComponent
    }
}