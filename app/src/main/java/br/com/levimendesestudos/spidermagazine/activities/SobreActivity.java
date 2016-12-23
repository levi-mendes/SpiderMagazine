package br.com.levimendesestudos.spidermagazine.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import br.com.levimendesestudos.spidermagazine.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

public class SobreActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tvLinks)
    TextView tvLinks;
    private SpannableStringBuilder spanLinks = new SpannableStringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.profile);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());

        links();
    }

    /**
     * Adiciona os links
     */
    private void links() {
        adicionarLinkEmail("Email:   ", "levi.silva.mendes@gmail.com");
        adicionarLink("Linkedin:   ",   "https://br.linkedin.com/in/levi-mendes-56567035");
        adicionarLink("Github:   ",     "https://github.com/levi-mendes");
        adicionarLink("Bitbucket:   ",  "https://bitbucket.org/levi-mendes/");
        adicionarLink("Facebook:   ",   "https://m.facebook.com/profile.php?id=100010499918526");

        tvLinks.setMovementMethod(LinkMovementMethod.getInstance());
        tvLinks.setText(spanLinks, TextView.BufferType.SPANNABLE);
    }

    /**
     * Adiciona link de email
     * @param titulo
     * @param email
     */
    private void adicionarLinkEmail(String titulo, String email) {
        spanLinks.append(titulo);
        spanLinks.append(email);
        spanLinks.setSpan(clickEnviarEmail(email), spanLinks.length() - email.length(), spanLinks.length(), 0);
        spanLinks.append("\n\n");

    }

    private void adicionarLink(String titulo, String link) {
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
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(link));
                startActivity(i);
            }
        };

        return clickableSpan;
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

    private void enviarEmail(String email) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email, null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,      "Assunto");
        emailIntent.putExtra(Intent.EXTRA_TEXT,         "Corpo email");
        startActivity(Intent.createChooser(emailIntent, "Enviar email..."));
    }
}
