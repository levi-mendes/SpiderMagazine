package br.com.levimendesestudos.spidermagazine.activities

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import br.com.levimendesestudos.spidermagazine.R
import br.com.levimendesestudos.spidermagazine.model.Revista
import br.com.levimendesestudos.spidermagazine.mvp.contracts.CapaMVP
import br.com.levimendesestudos.spidermagazine.mvp.presenter.CapaPresenter
import java.lang.String.format

class CapaActivity : BaseActivity(), CapaMVP.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capa)

        val presenter = CapaPresenter(this)
        presenter.init()

        findViewById<View>(R.id.ivFechar).setOnClickListener{ onBackPressed() }
    }

    override fun carregarCapa() {
        val revista = intent.getParcelableExtra(EXTRA_PARAM_REVISTA) as Revista

        val url = format("%s/portrait_uncanny.jpg", revista.thumbnailPath)

        val ivRevistaCapa = findViewById<ImageView>(R.id.ivRevistaCapa)

        Glide.with(this)
                .load(url)
                //.centerCrop()
                //.placeholder(R.drawable.loading)
                //.crossFade()
                .into(ivRevistaCapa)
    }

    companion object {

        private const val EXTRA_PARAM_REVISTA = "revista"
    }
}