package br.com.levimendesestudos.spidermagazine.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import br.com.levimendesestudos.spidermagazine.R;
import br.com.levimendesestudos.spidermagazine.mvp.contracts.SobreMVP;
import br.com.levimendesestudos.spidermagazine.mvp.presenter.SobrePresenter;
import butterknife.BindView;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

public class SobreActivity extends BaseActivity implements SobreMVP.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tvLinks)
    TextView tvLinks;
    private SpannableStringBuilder spanLinks = new SpannableStringBuilder();
    private SobrePresenter mPresenter;

    @Override
    public int layout() {
        return R.layout.activity_sobre;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new SobrePresenter(this);
        mPresenter.init();
    }

    @Override
    public void configToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.profile);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());
    }

    /**
     * Adiciona os links
     */
    @Override
    public void adddLinks() {
        adicionarLinkEmail("Email: ", "levi.silva.mendes@gmail.com");
        adicionarLink("Linkedin:   ", "https://br.linkedin.com/in/levi-mendes-56567035");
        adicionarLink("Github:     ", "https://github.com/levi-mendes");
        adicionarLink("Bitbucket:  ", "https://bitbucket.org/levi-mendes/");
        adicionarLink("Facebook:   ", "https://m.facebook.com/profile.php?id=100010499918526");

        tvLinks.setMovementMethod(LinkMovementMethod.getInstance());
        tvLinks.setText(spanLinks, TextView.BufferType.SPANNABLE);
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
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                enviarEmail(email);
            }
        };

        return clickableSpan;
    }

    @Override
    public void enviarEmail(String email) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email, null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,            getString(R.string.assunto));
        emailIntent.putExtra(Intent.EXTRA_TEXT,               getString(R.string.corpo_email));
        startActivity(Intent.createChooser(emailIntent,       getString(R.string.enviar_email_usando)));
    }
}