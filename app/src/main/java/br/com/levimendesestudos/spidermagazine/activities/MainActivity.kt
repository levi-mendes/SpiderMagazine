package br.com.levimendesestudos.spidermagazine.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import br.com.levimendesestudos.spidermagazine.R
import br.com.levimendesestudos.spidermagazine.adapters.RevistasListaAdapter
import br.com.levimendesestudos.spidermagazine.model.Revista
import br.com.levimendesestudos.spidermagazine.mvp.contracts.MainMVP
import br.com.levimendesestudos.spidermagazine.mvp.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainMVP.View {

    lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = MainPresenter(this)
        mPresenter.init()
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
        mPresenter.navigate(item.itemId)

        return true
    }

    override fun callSobreActivity() {
        val intent = Intent(this, SobreActivity::class.java)
        startActivity(intent)
    }
}