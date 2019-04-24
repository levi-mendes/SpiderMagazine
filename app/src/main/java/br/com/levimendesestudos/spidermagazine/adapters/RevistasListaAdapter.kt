package br.com.levimendesestudos.spidermagazine.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import br.com.levimendesestudos.spidermagazine.R
import br.com.levimendesestudos.spidermagazine.activities.DetalhesActivity
import br.com.levimendesestudos.spidermagazine.model.Revista
import java.lang.String.format

/**
 * Created by 809778 on 22/12/2016.
 */

class RevistasListaAdapter(private val mContext: Context, private val mList: List<Revista>) : BaseAdapter() {

    override fun getCount(): Int {
        return mList.size
    }

    override fun getItem(i: Int): Revista {
        return mList[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder: ViewHolder
        val view: View

        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.row_lista_revista, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder

        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val revista = mList[position]
        val url = format("%s/portrait_medium.jpg", revista.thumbnailPath)

        viewHolder.tvIssueNumber?.text = revista.issueNumber.toString()
        viewHolder.ivRevista?.setOnClickListener { callDetalhes(mContext, revista) }

        Glide.with(mContext)
                .load(url)
                //.centerCrop()
                //.placeholder(R.drawable.loading_spinner)
                //.crossFade()
                .into(viewHolder.ivRevista)

        return view
    }

    private class ViewHolder(row: View?) {
        var tvIssueNumber: TextView? = null
        var ivRevista: ImageView? = null

        init {
            tvIssueNumber = row?.findViewById(R.id.tvIssueNumber)
            ivRevista = row?.findViewById(R.id.ivRevista)
        }
    }

    private fun callDetalhes(context: Context, revista: Revista) {
        val intent = Intent(context, DetalhesActivity::class.java)
        intent.putExtra("revista", revista)
        context.startActivity(intent)
    }
}
