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
//import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.levimendesestudos.spidermagazine.R;
import br.com.levimendesestudos.spidermagazine.activities.DetalhesActivity;
import br.com.levimendesestudos.spidermagazine.model.Revista;

import static java.lang.String.valueOf;

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
    public View getView(int i, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_lista_revista, parent, false);

        TextView tvIssueNumber = (TextView)view.findViewById(R.id.tvIssueNumber);
        ImageView ivRevista    = (ImageView)view.findViewById(R.id.ivRevista);

        Revista revista = mList.get(i);

        tvIssueNumber.setText(valueOf(revista.issueNumber));
        /*Picasso.with(mContext)
                .load(revista.thumbnailPath +  "/portrait_medium.jpg")
                .into(ivRevista);*/

        Glide.with(mContext)
            .load(revista.thumbnailPath +  "/portrait_medium.jpg")
            .centerCrop()
            //.placeholder(R.drawable.loading_spinner)
            .crossFade()
            .into(ivRevista);

        ivRevista.setOnClickListener(view1 ->  {
                Intent intent = new Intent(mContext, DetalhesActivity.class);
                intent.putExtra("revista", revista);
                mContext.startActivity(intent);
        });

        return view;
    }
}
