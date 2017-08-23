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
import butterknife.BindView;
import static java.lang.String.valueOf;

public class DetalhesActivity extends BaseActivity implements DetalhesMVP.View {

    @BindView(R.id.ivRevista)
    ImageView ivRevista;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @BindView(R.id.tvDescription)
    TextView tvDescription;

    @BindView(R.id.tvDate)
    TextView tvDate;

    @BindView(R.id.tvPrice)
    TextView tvPrice;

    @BindView(R.id.tvPageCount)
    TextView tvPageCount;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private DetalhesPresenter mPresenter;
    private Revista mRevista;

    @Override
    public int layout() {
        return R.layout.activity_detalhes;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRevista = (Revista)getIntent().getSerializableExtra("revista");

        mPresenter = new DetalhesPresenter(this);
        mPresenter.init();
    }

    @Override
    public void configToolbar() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void carregarDados() {
        String url = mRevista.thumbnailPath + "/portrait_medium.jpg";

        Glide.with(this)
                .load(url)
                //.centerCrop()
                //.placeholder(R.drawable.loading_spinner)
                //.crossFade()
                .into(ivRevista);

        tvTitle.setText(mRevista.title);
        tvDescription.setText(mRevista.description);
        tvDate.append(mRevista.date);
        tvPrice.append(valueOf(mRevista.price));
        tvPageCount.append(valueOf(mRevista.pageCount));

        ivRevista.setOnClickListener(view -> chamarTelaCapa());
    }

    @Override
    public void chamarTelaCapa() {
        Intent intent = new Intent(DetalhesActivity.this, CapaActivity.class);
        intent.putExtra("revista", mRevista);
        startActivity(intent);
    }
}