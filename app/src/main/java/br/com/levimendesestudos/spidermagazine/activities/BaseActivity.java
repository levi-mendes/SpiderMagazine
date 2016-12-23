package br.com.levimendesestudos.spidermagazine.activities;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by 809778 on 23/12/2016.
 */

public class BaseActivity extends AppCompatActivity {

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
