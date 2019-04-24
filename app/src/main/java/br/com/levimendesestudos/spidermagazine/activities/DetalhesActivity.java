package br.com.levimendesestudos.spidermagazine.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import br.com.levimendesestudos.spidermagazine.R;
import br.com.levimendesestudos.spidermagazine.model.Revista;
import br.com.levimendesestudos.spidermagazine.mvp.contracts.DetalhesMVP;
import br.com.levimendesestudos.spidermagazine.mvp.presenter.DetalhesPresenter;
import static java.lang.String.format;
import static java.lang.String.valueOf;

public class DetalhesActivity extends BaseActivity implements DetalhesMVP.View {

    private Revista mRevista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        mRevista = (Revista)getIntent().getSerializableExtra("revista");

        DetalhesPresenter presenter = new DetalhesPresenter(this);
        presenter.init();
    }

    @Override
    public void configToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void carregarDados() {
        ImageView ivRevista = findViewById(R.id.ivRevista);

        String url = format("%s/portrait_medium.jpg", mRevista.thumbnailPath);

        Glide.with(this)
                .load(url)
                //.centerCrop()
                //.placeholder(R.drawable.loading_spinner)
                //.crossFade()
                .into(ivRevista);

        ((TextView)findViewById(R.id.tvTitle)).setText(mRevista.title);
        ((TextView)findViewById(R.id.tvDescription)).setText(mRevista.description);
        ((TextView)findViewById(R.id.tvDate)).append(mRevista.date);
        ((TextView)findViewById(R.id.tvPrice)).append(valueOf(mRevista.price));
        ((TextView)findViewById(R.id.tvPageCount)).append(valueOf(mRevista.pageCount));

        ivRevista.setOnClickListener(view -> chamarTelaCapa());
    }

    @Override
    public void chamarTelaCapa() {
        Intent intent = new Intent(DetalhesActivity.this, CapaActivity.class);
        intent.putExtra("revista", mRevista);
        startActivity(intent);
    }
}