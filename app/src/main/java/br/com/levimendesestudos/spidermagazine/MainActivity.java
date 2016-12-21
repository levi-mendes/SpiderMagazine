package br.com.levimendesestudos.spidermagazine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.List;

import br.com.levimendesestudos.spidermagazine.model.Revista;
import br.com.levimendesestudos.spidermagazine.mvp.contracts.MainMVP;
import br.com.levimendesestudos.spidermagazine.mvp.presenter.MainPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainMVP.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.img_marvel_logo);

        mPresenter = new MainPresenter(this);
        mPresenter.buscarRevistas();
    }

    @Override
    public void carregarLista(List<Revista> revistas) {
        Log.e("carregarLista", "" + revistas.size());
        Log.e("carregarLista", "" + revistas.isEmpty());
        //TODO
    }
}
