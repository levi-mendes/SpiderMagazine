package br.com.levimendesestudos.spidermagazine.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import br.com.levimendesestudos.spidermagazine.R;
import br.com.levimendesestudos.spidermagazine.model.Revista;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CapaActivity extends AppCompatActivity {

    @BindView(R.id.ivRevistaCapa)
    ImageView ivRevistaCapa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capa);

        ButterKnife.bind(this);

        Revista revista = (Revista)getIntent().getSerializableExtra("revista");

        String url = revista.thumbnailPath + "/portrait_uncanny.jpg";

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
