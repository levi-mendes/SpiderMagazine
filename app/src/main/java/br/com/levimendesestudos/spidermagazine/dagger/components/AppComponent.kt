package br.com.levimendesestudos.spidermagazine.dagger.components

import javax.inject.Singleton

import br.com.levimendesestudos.spidermagazine.dagger.modules.ApiSpiderModule
import br.com.levimendesestudos.spidermagazine.mvp.presenter.MainPresenter
import dagger.Component

/**
 * Created by 809778 on 21/12/2016.
 */

@Component(modules = [ApiSpiderModule::class])
@Singleton
interface AppComponent {

    fun inject(viewModel: MainPresenter)
}
