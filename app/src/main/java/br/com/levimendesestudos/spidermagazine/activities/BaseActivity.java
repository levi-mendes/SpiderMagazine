package br.com.levimendesestudos.spidermagazine.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import br.com.levimendesestudos.spidermagazine.mvp.contracts.BasicView;
import butterknife.ButterKnife;

/**
 * Created by 809778 on 23/12/2016.
 */

public abstract class BaseActivity extends AppCompatActivity implements BasicView {

    public abstract int layout();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout());
        ButterKnife.bind(this);
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


    @Override
    public boolean isActive() {
        return !isDestroyed();
    }

}