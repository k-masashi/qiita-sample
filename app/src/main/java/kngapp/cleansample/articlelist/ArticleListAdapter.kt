package kngapp.cleansample.articlelist

import android.annotation.SuppressLint
import android.content.Context
import android.widget.TextView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.BaseAdapter
import kngapp.cleansample.R
import kngapp.cleansample.articlelist.domain.model.Article


/**
 * Created by masashi on 2018/08/09.
 *
 * 記事一覧表示用Listで利用するAdapter
 */

class ArticleListAdapter(context: Context) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private var items: List<Article> = ArrayList()

    fun setList(list: List<Article>) {
        items = list
    }

    @SuppressLint("InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        var viewHolder: CustomViewHolder? = null

        view?.let {
            viewHolder = it.tag as CustomViewHolder?
        } ?: run {
            view = inflater.inflate(R.layout.article_item, null)
            viewHolder = CustomViewHolder(view?.findViewById<TextView>(R.id.title) as TextView)
            view?.tag = viewHolder
        }

        viewHolder?.let {
            it.textView.text = items[position].title
        }

        return view as View
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }

    class CustomViewHolder(var textView: TextView)
}