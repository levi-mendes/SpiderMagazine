package br.com.levimendesestudos.spidermagazine.activities;

import android.os.Bundle;
import br.com.levimendesestudos.spidermagazine.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import android.support.v7.widget.Toolbar;

public class SobreActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.profile);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());
    }
}
