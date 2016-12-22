package br.com.levimendesestudos.spidermagazine.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import br.com.levimendesestudos.spidermagazine.R;
import br.com.levimendesestudos.spidermagazine.model.Revista;
import butterknife.BindView;
import butterknife.ButterKnife;

import static java.lang.String.valueOf;

public class DetalhesActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        Revista revista = (Revista)getIntent().getSerializableExtra("revista");

        Picasso.with(this)
                .load(revista.thumbnailPath)
                .into(ivRevista);

        tvTitle.setText(revista.title);
        tvDescription.setText(revista.description);
        tvDate.append(revista.date);
        tvPrice.append(valueOf(revista.price));
        tvPageCount.append(valueOf(revista.pageCount));
    }
}
