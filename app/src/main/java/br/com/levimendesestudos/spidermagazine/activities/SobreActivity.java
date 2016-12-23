package br.com.levimendesestudos.spidermagazine.activities;

import android.graphics.Color;
import android.os.Bundle;
import br.com.levimendesestudos.spidermagazine.R;
import br.com.levimendesestudos.spidermagazine.utils.ToastUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import static br.com.levimendesestudos.spidermagazine.utils.ToastUtil.showToast;

public class SobreActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tvLinks)
    TextView tvLinks;

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

    private void links() {
        String email     = "levi.silva.mendes@gmail.com";
        String linkedin  = "https://br.linkedin.com/in/levi-mendes-56567035";
        String github    = "https://github.com/levi-mendes";
        String bitbucket = "https://bitbucket.org/levi-mendes/";
        String facebook  = "https://m.facebook.com/profile.php?id=100010499918526";

        SpannableStringBuilder spanTxt = new SpannableStringBuilder();

        spanTxt.append("Email:   ");
        spanTxt.append(email);
        spanTxt.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                showToast(getApplicationContext(), email + " Clicked");
            }

        }, spanTxt.length() - email.length(), spanTxt.length(), 0);
        spanTxt.append("\n\n");

        spanTxt.append("Linkedin:   ");
        spanTxt.append(linkedin);
        spanTxt.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                showToast(getApplicationContext(), linkedin + " Clicked");
            }

        }, spanTxt.length() - linkedin.length(), spanTxt.length(), 0);
        spanTxt.append("\n\n");

        //spanTxt.setSpan(new ForegroundColorSpan(Color.BLACK), 32, spanTxt.length(), 0);
        spanTxt.append("Github:   ");
        spanTxt.append(github);
        spanTxt.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                showToast(getApplicationContext(), github + " Clicked");
            }
        }, spanTxt.length() - github.length(), spanTxt.length(), 0);
        spanTxt.append("\n\n");

        //spanTxt.setSpan(new ForegroundColorSpan(Color.BLACK), 32, spanTxt.length(), 0);
        spanTxt.append("Bitbucket:   ");
        spanTxt.append(bitbucket);
        spanTxt.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                showToast(getApplicationContext(), bitbucket + " Clicked");
            }
        }, spanTxt.length() - bitbucket.length(), spanTxt.length(), 0);
        spanTxt.append("\n\n");

        //spanTxt.setSpan(new ForegroundColorSpan(Color.BLACK), 32, spanTxt.length(), 0);
        spanTxt.append("Facebook:   ");
        spanTxt.append(facebook);
        spanTxt.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                showToast(getApplicationContext(), facebook + " Clicked");
            }
        }, spanTxt.length() - facebook.length(), spanTxt.length(), 0);
        spanTxt.append("\n\n");

        tvLinks.setMovementMethod(LinkMovementMethod.getInstance());
        tvLinks.setText(spanTxt, TextView.BufferType.SPANNABLE);
    }

    private void adicionarLink() {

    }
}
