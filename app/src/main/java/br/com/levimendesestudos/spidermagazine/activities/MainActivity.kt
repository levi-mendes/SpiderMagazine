package br.com.levimendesestudos.spidermagazine.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.GridView
import android.widget.TextView
import br.com.levimendesestudos.spidermagazine.R
import br.com.levimendesestudos.spidermagazine.adapters.RevistasListaAdapter
import br.com.levimendesestudos.spidermagazine.model.Revista
import br.com.levimendesestudos.spidermagazine.mvp.contracts.MainMVP
import br.com.levimendesestudos.spidermagazine.mvp.presenter.MainPresenter

class MainActivity : BaseActivity(), MainMVP.View {

    lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = MainPresenter(this)
        mPresenter.init()
    }

    override fun configToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = ""
    }

    override fun showSemInternet() {
        findViewById<View>(R.id.tvSemInternet).visibility = View.VISIBLE
    }

    override fun hideSemInternet() {
        findViewById<View>(R.id.tvSemInternet).visibility = View.GONE
    }

    override fun copyRight(s: String) {
        (findViewById<View>(R.id.tvCopyright) as TextView).text = s
    }

    override fun carregarLista(revistas: List<Revista>) {
        val adapter = RevistasListaAdapter(this, revistas)
        (findViewById<View>(R.id.gvRevistas) as GridView).adapter = adapter
    }

    override fun showPbProcessamento() {
        findViewById<View>(R.id.pbProcessamento).visibility = View.VISIBLE
    }

    override fun hidePbProcessamento() {
        findViewById<View>(R.id.pbProcessamento).visibility = View.GONE
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