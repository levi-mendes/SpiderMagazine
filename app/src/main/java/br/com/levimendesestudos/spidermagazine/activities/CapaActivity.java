package br.com.levimendesestudos.spidermagazine.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import br.com.levimendesestudos.spidermagazine.R;
import br.com.levimendesestudos.spidermagazine.model.Revista;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CapaActivity extends AppCompatActivity {

    @BindView(R.id.ivRevistaCapa)
    ImageView ivRevistaCapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capa);

        ButterKnife.bind(this);

        Revista revista = (Revista)getIntent().getSerializableExtra("revista");

        //revista.thumbnailPath +  "/portrait_medium.jpg"
        //portrait_uncanny

        String url = revista.thumbnailPath + "/portrait_incredible.jpg";

        Glide.with(this)
                .load(url)
                .centerCrop()
                //.placeholder(R.drawable.loading_spinner)
                .crossFade()
                .into(ivRevistaCapa);
    }
}
