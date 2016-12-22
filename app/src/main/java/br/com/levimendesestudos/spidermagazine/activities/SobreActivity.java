package br.com.levimendesestudos.spidermagazine.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import br.com.levimendesestudos.spidermagazine.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class SobreActivity extends AppCompatActivity {

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
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
