package br.com.levimendesestudos.spidermagazine.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v4.view.ViewCompat
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView
import com.bumptech.glide.Glide
import br.com.levimendesestudos.spidermagazine.R
import br.com.levimendesestudos.spidermagazine.model.Revista
import br.com.levimendesestudos.spidermagazine.mvp.contracts.DetalhesMVP
import br.com.levimendesestudos.spidermagazine.mvp.presenter.DetalhesPresenter
import com.mikhaellopez.circularimageview.CircularImageView
import java.lang.String.format

class DetalhesActivity : BaseActivity(), DetalhesMVP.View {

    private var mRevista: Revista? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        mRevista = intent.getParcelableExtra(EXTRA_PARAM_REVISTA)

        val presenter = DetalhesPresenter(this)
        presenter.init()
    }

    override fun configToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun carregarDados() {
        val ivRevista = findViewById<CircularImageView>(R.id.ivRevista)

        val url = format("%s/portrait_medium.jpg", mRevista!!.thumbnailPath)

        Glide.with(this)
                .load(url)
                //.centerCrop()
                //.placeholder(R.drawable.loading_spinner)
                //.crossFade()
                .into(ivRevista)

        val collapsingToolbar = findViewById<View>(R.id.collapsing_layout) as CollapsingToolbarLayout
        (findViewById<View>(R.id.app_bar) as AppBarLayout).addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->

            /*
                int min_height = ViewCompat.getMinimumHeight(collapsing_toolbar) * 2;
                float scale = (float) (min_height + verticalOffset) / min_height;
                image.setScaleX(scale >= 0 ? scale : 0);
                image.setScaleY(scale >= 0 ? scale : 0);
             */
            val minHeight = ViewCompat.getMinimumHeight(collapsingToolbar) * 2
            val scale: Float = (minHeight + verticalOffset).toFloat() / minHeight
            val newScale: Float = if (scale >= 0) scale else 0.0f

            ivRevista.scaleX = newScale
            ivRevista.scaleY = newScale
        })

        (findViewById<View>(R.id.tvTitle) as TextView).text = mRevista!!.title
        (findViewById<View>(R.id.tvDescription) as TextView).text = mRevista!!.description
        (findViewById<View>(R.id.tvDate) as TextView).append(mRevista!!.date)
        (findViewById<View>(R.id.tvPrice) as TextView).append(mRevista!!.price.toString())
        (findViewById<View>(R.id.tvPageCount) as TextView).append(mRevista!!.pageCount.toString())

        ivRevista.setOnClickListener { chamarTelaCapa() }
    }

    override fun chamarTelaCapa() {
        val intent = Intent(this@DetalhesActivity, CapaActivity::class.java)
        intent.putExtra(EXTRA_PARAM_REVISTA, mRevista)
        startActivity(intent)
    }

    companion object {
        private const val EXTRA_PARAM_REVISTA = "revista"
    }
}