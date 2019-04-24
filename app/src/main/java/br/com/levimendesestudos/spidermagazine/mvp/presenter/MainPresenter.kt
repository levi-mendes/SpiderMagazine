package br.com.levimendesestudos.spidermagazine.mvp.presenter

import android.util.Log

import java.util.HashMap

import javax.inject.Inject
import br.com.levimendesestudos.spidermagazine.R
import br.com.levimendesestudos.spidermagazine.api.SpiderApi
import br.com.levimendesestudos.spidermagazine.dagger.DaggerInjector
import br.com.levimendesestudos.spidermagazine.mvp.contracts.MainMVP
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by 809778 on 21/12/2016.
 */
class MainPresenter(private val mView: MainMVP.View) : MainMVP.Presenter {
    @set:Inject
    internal var mApi: SpiderApi? = null

    init {

        DaggerInjector.get().inject(this)
    }

    override fun init() {
        mView.configToolbar()

        if (!mView.hasInternet()) {
            mView.showSemInternet()
            return
        }

        mView.showPbProcessamento()

        mApi?.let {
            it.comics(params())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ hero ->

                        if (mView.active()) {
                            mView.carregarLista(hero.revistas)
                            mView.copyRight(hero.copyright)
                            mView.hidePbProcessamento()
                        }

                    }, {error ->
                        Log.e("onError", error.message, error)
                        mView.showToast(error.message!!)
                    })
        }

    }

    private fun params(): Map<String, String> {
        val params = HashMap<String, String>()

        params["ts"] = "1"
        params["apikey"] = "bb4470a46d0659a43c566ac6056ed48d"
        params["hash"] = "479474cf0a28eac9998960da4d96f06b"

        return params
    }

    override fun navigate(id: Int) {
        when (id) {
            R.id.action_profile -> mView.callSobreActivity()
        }
    }
}
