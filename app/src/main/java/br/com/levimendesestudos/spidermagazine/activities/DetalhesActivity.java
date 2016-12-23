package br.com.levimendesestudos.spidermagazine.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import br.com.levimendesestudos.spidermagazine.R;
import br.com.levimendesestudos.spidermagazine.model.Revista;
import br.com.levimendesestudos.spidermagazine.utils.ToastUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

import static java.lang.String.valueOf;

public class DetalhesActivity extends BaseActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        ButterKnife.bind(this);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Revista revista = (Revista)getIntent().getSerializableExtra("revista");

        String url = revista.thumbnailPath + "/portrait_medium.jpg";

        Glide.with(this)
                .load(url)
                .centerCrop()
                //.placeholder(R.drawable.loading_spinner)
                .crossFade()
                .into(ivRevista);

        tvTitle.setText(revista.title);
        tvDescription.setText(revista.description);
        tvDate.append(revista.date);
        tvPrice.append(valueOf(revista.price));
        tvPageCount.append(valueOf(revista.pageCount));

        ivRevista.setOnClickListener(view -> {
                Intent intent = new Intent(DetalhesActivity.this, CapaActivity.class);
                intent.putExtra("revista", revista);
                startActivity(intent);
        });
    }
}