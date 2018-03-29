package br.com.levimendesestudos.spidermagazine.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.List;
import br.com.levimendesestudos.spidermagazine.R;
import br.com.levimendesestudos.spidermagazine.activities.DetalhesActivity;
import br.com.levimendesestudos.spidermagazine.model.Revista;

import static java.lang.String.format;
import static java.lang.String.valueOf;

/**
 * Created by 809778 on 22/12/2016.
 */

public class RevistasListaAdapter extends BaseAdapter {

    private  List<Revista> mList;

    public RevistasListaAdapter(List<Revista> list) {
        mList = list;
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
    public View getView(int i, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.row_lista_revista, parent, false);

        TextView tvIssueNumber = view.findViewById(R.id.tvIssueNumber);
        ImageView ivRevista    = view.findViewById(R.id.ivRevista);

        Revista revista = mList.get(i);

        tvIssueNumber.setText(valueOf(revista.issueNumber));

        String url = format("%s/portrait_medium.jpg", revista.thumbnailPath);

        Glide.with(context)
            .load(url)
            //.centerCrop()
            //.placeholder(R.drawable.loading_spinner)
            //.crossFade()
            .into(ivRevista);

        ivRevista.setOnClickListener(view1 -> callDetalhes(context, revista));

        return view;
    }

    public void callDetalhes(Context context, Revista revista) {
        Intent intent = new Intent(context, DetalhesActivity.class);
        intent.putExtra("revista", revista);
        context.startActivity(intent);
    }
}
