package br.com.levimendesestudos.spidermagazine.adapters

import android.content.Context
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v4.view.ViewCompat
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
import org.jetbrains.anko.startActivity
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
        viewHolder.ivRevista?.setOnClickListener { mContext.startActivity<DetalhesActivity>("revista" to revista) }

        viewHolder.ivRevista?.let {

            Glide.with(mContext)
                    .load(url)
                    //.centerCrop()
                    //.placeholder(R.drawable.loading_spinner)
                    //.crossFade()
                    .into(it)
            /*
            val collapsing_toolbar = findViewById<View>(R.id.collapsing_toolbar) as CollapsingToolbarLayout
            (findViewById<View>(R.id.app_bar_layout) as AppBarLayout).addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
                val min_height = ViewCompat.getMinimumHeight(collapsing_toolbar) * 2
                val scale = (min_height + verticalOffset).toFloat() / min_height
                it.setScaleX(if (scale >= 0) scale else 0)
                it.setScaleY(if (scale >= 0) scale else 0)
            })
            */
        }

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
}
