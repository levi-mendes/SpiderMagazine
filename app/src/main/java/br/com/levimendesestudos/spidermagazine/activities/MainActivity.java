package br.com.levimendesestudos.spidermagazine.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import java.util.List;
import br.com.levimendesestudos.spidermagazine.R;
import br.com.levimendesestudos.spidermagazine.adapters.RevistasListaAdapter;
import br.com.levimendesestudos.spidermagazine.model.Revista;
import br.com.levimendesestudos.spidermagazine.mvp.contracts.MainMVP;
import br.com.levimendesestudos.spidermagazine.mvp.presenter.MainPresenter;

public class MainActivity extends BaseActivity implements MainMVP.View {

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(this);
        mPresenter.init();
    }

    @Override
    public void configToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }

    @Override
    public void showSemInternet() {
        findViewById(R.id.tvSemInternet).setVisibility(View.VISIBLE);
    }

    @Override
    public void hideSemInternet() {
        findViewById(R.id.tvSemInternet).setVisibility(View.GONE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void copyRight(String s) {
        ((TextView)findViewById(R.id.tvCopyright)).setText(s);
    }

    @Override
    public void carregarLista(List<Revista> revistas) {
        RevistasListaAdapter adapter = new RevistasListaAdapter(revistas);
        ((GridView)findViewById(R.id.gvRevistas)).setAdapter(adapter);
    }

    @Override
    public void showPbProcessamento() {
        findViewById(R.id.pbProcessamento).setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePbProcessamento() {
        findViewById(R.id.pbProcessamento).setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mPresenter.navigate(item.getItemId());

        return true;
    }

    @Override
    public void callSobreActivity() {
        Intent intent = new Intent(MainActivity.this, SobreActivity.class);
        startActivity(intent);
    }
}