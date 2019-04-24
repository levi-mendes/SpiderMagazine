package br.com.levimendesestudos.spidermagazine.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import br.com.levimendesestudos.spidermagazine.R
import br.com.levimendesestudos.spidermagazine.mvp.contracts.SobreMVP
import br.com.levimendesestudos.spidermagazine.mvp.presenter.SobrePresenter
import android.support.v7.widget.Toolbar
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class SobreActivity : BaseActivity(), SobreMVP.View {

    private val spanLinks = SpannableStringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre)

        val presenter = SobrePresenter(this)
        presenter.init()
    }

    override fun configToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setTitle(R.string.profile)
        toolbar.setNavigationOnClickListener { view -> onBackPressed() }
    }

    override fun carregarFoto() {
        Glide.with(this)
                .load(getString(R.string.link_foto_github))
                .apply(RequestOptions.circleCropTransform())
                .into(findViewById<View>(R.id.ivLevi) as ImageView)
    }

    /**
     * Adiciona os links
     */
    override fun adddLinks() {
        adicionarLinkEmail(getString(R.string.titulo_email), getString(R.string.txt_email_levi))
        adicionarLink(getString(R.string.titulo_linkedin), getString(R.string.txt_link_linkedin))
        adicionarLink(getString(R.string.titulo_github), getString(R.string.txt_link_github))
        adicionarLink(getString(R.string.titulo_bitbucket), getString(R.string.txt_link_bitbucket))
        adicionarLink(getString(R.string.titulo_facebook), getString(R.string.txt_link_facebook))

        (findViewById<View>(R.id.tvLinks) as TextView).movementMethod = LinkMovementMethod.getInstance()
        (findViewById<View>(R.id.tvLinks) as TextView).setText(spanLinks, TextView.BufferType.SPANNABLE)
    }

    /**
     * Adiciona link de email
     * @param titulo
     * @param email
     */
    override fun adicionarLinkEmail(titulo: String, email: String) {
        spanLinks.append(titulo)
        spanLinks.append(email)
        spanLinks.setSpan(clickEnviarEmail(email), spanLinks.length - email.length, spanLinks.length, 0)
        spanLinks.append("\n\n")
    }

    override fun adicionarLink(titulo: String, link: String) {
        spanLinks.append(titulo)
        spanLinks.append(link)
        spanLinks.setSpan(abrirLink(link), spanLinks.length - link.length, spanLinks.length, 0)
        spanLinks.append("\n\n")
    }

    /**
     * Abre link de internet
     * @param link
     * @return
     */
    private fun abrirLink(link: String): ClickableSpan {
        return object : ClickableSpan() {
            override fun onClick(widget: View) {
                abrirPagina(link)
            }
        }
    }

    override fun abrirPagina(link: String) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(link)
        startActivity(i)
    }

    private fun clickEnviarEmail(email: String): ClickableSpan {
        return object : ClickableSpan() {
            override fun onClick(widget: View) {
                enviarEmail(email)
            }
        }
    }

    override fun enviarEmail(email: String) {
        val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email, null))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.assunto))
        emailIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.corpo_email))
        startActivity(Intent.createChooser(emailIntent, getString(R.string.enviar_email_usando)))
    }
}