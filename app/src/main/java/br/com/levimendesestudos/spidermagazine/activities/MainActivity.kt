package br.com.levimendesestudos.spidermagazine.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import br.com.levimendesestudos.spidermagazine.R
import br.com.levimendesestudos.spidermagazine.adapters.RevistasListaAdapter
import br.com.levimendesestudos.spidermagazine.koin.ApiSpiderModule
import br.com.levimendesestudos.spidermagazine.model.Revista
import br.com.levimendesestudos.spidermagazine.mvp.contracts.MainMVP
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.HashMap

class MainActivity : BaseActivity(), MainMVP.View {

    val mApi: ApiSpiderModule by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mApi.providesSpiderApi().comics(params())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ hero ->

                if (active()) {
                    carregarLista(hero.revistas)
                    copyRight(hero.copyright)
                    hidePbProcessamento()
                }

            }, {error ->
                Log.e("onError", error.message, error)
                showToast(error.message!!)
            })
    }

    private fun params(): Map<String, String> {
        val params = HashMap<String, String>()

        params["ts"] = "1"
        params["apikey"] = "bb4470a46d0659a43c566ac6056ed48d"
        params["hash"] = "479474cf0a28eac9998960da4d96f06b"

        return params
    }

    override fun configToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
    }

    override fun showSemInternet() {
        tvSemInternet.visibility = View.VISIBLE
    }

    override fun hideSemInternet() {
        tvSemInternet.visibility = View.GONE
    }

    override fun copyRight(s: String) {
        tvCopyright.text = s
    }

    override fun carregarLista(revistas: List<Revista>) {
        val adapter = RevistasListaAdapter(this, revistas)
        gvRevistas.adapter = adapter
    }

    override fun showPbProcessamento() {
        pbProcessamento.visibility = View.VISIBLE
    }

    override fun hidePbProcessamento() {
        pbProcessamento.visibility = View.GONE
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_profile -> callSobreActivity()
        }

        return true
    }

    override fun callSobreActivity() {
        val intent = Intent(this, SobreActivity::class.java)
        startActivity(intent)
    }
}