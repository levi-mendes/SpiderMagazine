package br.com.levimendesestudos.spidermagazine.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import br.com.levimendesestudos.spidermagazine.R;
import br.com.levimendesestudos.spidermagazine.mvp.contracts.SobreMVP;
import br.com.levimendesestudos.spidermagazine.mvp.presenter.SobrePresenter;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class SobreActivity extends BaseActivity implements SobreMVP.View {
    
    private SpannableStringBuilder spanLinks = new SpannableStringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        SobrePresenter presenter = new SobrePresenter(this);
        presenter.init();
    }

    @Override
    public void configToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.profile);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());
    }

    @Override
    public void carregarFoto() {
        Glide.with(this)
                .load(getString(R.string.link_foto_github))
                .apply(RequestOptions.circleCropTransform())
                .into((ImageView)findViewById(R.id.ivLevi));
    }

    /**
     * Adiciona os links
     */
    @Override
    public void adddLinks() {
        adicionarLinkEmail(getString(R.string.titulo_email), getString(R.string.txt_email_levi));
        adicionarLink(getString(R.string.titulo_linkedin), getString(R.string.txt_link_linkedin));
        adicionarLink(getString(R.string.titulo_github), getString(R.string.txt_link_github));
        adicionarLink(getString(R.string.titulo_bitbucket), getString(R.string.txt_link_bitbucket));
        adicionarLink(getString(R.string.titulo_facebook), getString(R.string.txt_link_facebook));

        ((TextView)findViewById(R.id.tvLinks)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView)findViewById(R.id.tvLinks)).setText(spanLinks, TextView.BufferType.SPANNABLE);
    }

    /**
     * Adiciona link de email
     * @param titulo
     * @param email
     */
    @Override
    public void adicionarLinkEmail(String titulo, String email) {
        spanLinks.append(titulo);
        spanLinks.append(email);
        spanLinks.setSpan(clickEnviarEmail(email), spanLinks.length() - email.length(), spanLinks.length(), 0);
        spanLinks.append("\n\n");
    }

    @Override
    public void adicionarLink(String titulo, String link) {
        spanLinks.append(titulo);
        spanLinks.append(link);
        spanLinks.setSpan(abrirLink(link), spanLinks.length() - link.length(), spanLinks.length(), 0);
        spanLinks.append("\n\n");
    }

    /**
     * Abre link de internet
     * @param link
     * @return
     */
    private ClickableSpan abrirLink(String link) {
        return new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                abrirPagina(link);
            }
        };
    }

    @Override
    public void abrirPagina(String link) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(link));
        startActivity(i);
    }

    private ClickableSpan clickEnviarEmail(String email) {
        return new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                enviarEmail(email);
            }
        };
    }

    @Override
    public void enviarEmail(String email) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email, null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,            getString(R.string.assunto));
        emailIntent.putExtra(Intent.EXTRA_TEXT,               getString(R.string.corpo_email));
        startActivity(Intent.createChooser(emailIntent,       getString(R.string.enviar_email_usando)));
    }
}