package br.com.levimendesestudos.spidermagazine.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import br.com.levimendesestudos.spidermagazine.model.Revista;

/**
 * Created by 809778 on 22/12/2016.
 */

public class RevistasListaAdapter extends BaseAdapter {

    private Context mContext;
    private  List<Revista> mList;

    public RevistasListaAdapter(Context context, List<Revista> listaRevistas) {
        mContext = context;
        mList = listaRevistas;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Revista getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
