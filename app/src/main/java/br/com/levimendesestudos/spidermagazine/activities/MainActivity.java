package br.com.levimendesestudos.spidermagazine.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.List;
import br.com.levimendesestudos.spidermagazine.R;
import br.com.levimendesestudos.spidermagazine.adapters.RevistasListaAdapter;
import br.com.levimendesestudos.spidermagazine.model.Revista;
import br.com.levimendesestudos.spidermagazine.mvp.contracts.MainMVP;
import br.com.levimendesestudos.spidermagazine.mvp.presenter.MainPresenter;
import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainMVP.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tvCopyright)
    TextView tvCopyright;
    @BindView(R.id.gvRevistas)
    GridView gvRevistas;
    @BindView(R.id.pbProcessamento)
    ProgressBar pbProcessamento;

    private MainPresenter mPresenter;

    @Override
    public int layout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        mPresenter = new MainPresenter(this);
        mPresenter.init();
    }

    @Override
    public void copyRight(String s) {
        tvCopyright.setText(s);
    }

    @Override
    public void carregarLista(List<Revista> revistas) {
        RevistasListaAdapter adapter = new RevistasListaAdapter(this, revistas);
        gvRevistas.setAdapter(adapter);
    }

    @Override
    public void showPbProcessamento() {
     pbProcessamento.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePbProcessamento() {
        pbProcessamento.setVisibility(View.GONE);
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