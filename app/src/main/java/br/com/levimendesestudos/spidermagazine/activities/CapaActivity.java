package br.com.levimendesestudos.spidermagazine.activities;

import android.os.Bundle;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import br.com.levimendesestudos.spidermagazine.R;
import br.com.levimendesestudos.spidermagazine.model.Revista;
import br.com.levimendesestudos.spidermagazine.mvp.contracts.CapaMVP;
import br.com.levimendesestudos.spidermagazine.mvp.presenter.CapaPresenter;
import butterknife.BindView;
import butterknife.OnClick;

import static java.lang.String.format;

public class CapaActivity extends BaseActivity implements CapaMVP.View {

    @BindView(R.id.ivRevistaCapa)
    ImageView ivRevistaCapa;

    CapaPresenter mPresenter;

    @Override
    public int layout() {
        return R.layout.activity_capa;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new CapaPresenter(this);
        mPresenter.init();
    }

    @Override
    public void carregarCapa() {
        Revista revista = (Revista)getIntent().getSerializableExtra("revista");

        String url = format("%s/portrait_uncanny.jpg", revista.thumbnailPath);

        Glide.with(this)
                .load(url)
                //.centerCrop()
                //.placeholder(R.drawable.loading)
                //.crossFade()
                .into(ivRevistaCapa);
    }

    @OnClick(R.id.ivFechar)
    public void ivFechar() {
        onBackPressed();
    }
}
