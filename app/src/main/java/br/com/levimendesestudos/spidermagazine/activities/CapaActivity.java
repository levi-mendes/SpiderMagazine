package br.com.levimendesestudos.spidermagazine.activities;

import android.os.Bundle;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import br.com.levimendesestudos.spidermagazine.R;
import br.com.levimendesestudos.spidermagazine.model.Revista;
import br.com.levimendesestudos.spidermagazine.mvp.contracts.CapaMVP;
import br.com.levimendesestudos.spidermagazine.mvp.presenter.CapaPresenter;
import static java.lang.String.format;

public class CapaActivity extends BaseActivity implements CapaMVP.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capa);

        CapaPresenter  presenter = new CapaPresenter(this);
        presenter.init();

        findViewById(R.id.ivFechar).setOnClickListener(view -> onBackPressed());
    }

    @Override
    public void carregarCapa() {
        Revista revista = (Revista)getIntent().getSerializableExtra("revista");

        String url = format("%s/portrait_uncanny.jpg", revista.thumbnailPath);

        ImageView ivRevistaCapa = findViewById(R.id.ivRevistaCapa);

        Glide.with(this)
                .load(url)
                //.centerCrop()
                //.placeholder(R.drawable.loading)
                //.crossFade()
                .into(ivRevistaCapa);

    }
}