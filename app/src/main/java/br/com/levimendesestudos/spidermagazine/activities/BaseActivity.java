package br.com.levimendesestudos.spidermagazine.activities;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import br.com.levimendesestudos.spidermagazine.mvp.contracts.BasicView;
import br.com.levimendesestudos.spidermagazine.utils.ToastUtil;
import static br.com.levimendesestudos.spidermagazine.utils.InternetUtil.isConnectedToInternet;

/**
 * Created by 809778 on 23/12/2016.
 */
public abstract class BaseActivity extends AppCompatActivity implements BasicView {

    @Override
    public boolean hasInternet() {
        return isConnectedToInternet(this);
    }

    @Override
    public void showToast(String msg) {
        ToastUtil.showToast(this, msg);
    }

    @Override
    public void showToast(@StringRes int msg) {
        ToastUtil.showToast(this, getString(msg));
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