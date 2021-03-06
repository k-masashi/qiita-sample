package kngapp.cleansample.articlelist

/**
 * Created by masashi on 2018/08/10.
 *
 * Qiitaの記事一覧を出力するView
 */

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import com.google.gson.Gson
import kngapp.cleansample.R
import kngapp.cleansample.articledetail.ArticleDetailActivity
import kngapp.cleansample.articlelist.domain.model.Article
import kngapp.cleansample.base.BaseActivity

class ArticleListActivity : BaseActivity(), ArticleListContract.View {

    // 値代入が確約された変数はnullをいれずにlateinitを利用
    private lateinit var articleListPresenter: ArticleListPresenter
    private lateinit var interfacePresenter: ArticleListContract.Presenter
    private lateinit var articleListView: ListView
    private lateinit var articleListAdapter: ArticleListAdapter

    override fun setPresenter(presenter: ArticleListContract.Presenter) {
        // Presenterを生成
        interfacePresenter = presenter
    }

    override fun showArticles(articles: List<Article>) {
        // スコープ関数applyは利用しない方針 (ローカル変数との名前重複問題等を避けるため)
        articleListAdapter.setList(articles)
        articleListAdapter.notifyDataSetChanged()
    }

    override fun showGetArticlesError() {
        // 記事一覧取得失敗のメッセージをToastで表示
        showLongToast(this, getString(R.string.message_can_not_get_articles_error))
    }

    override fun showArticleDetailActivity(article: Article) {
        // 画面遷移メソッドはBaseActivityの方で持っておくべき場合もある
        val intent = Intent(this, ArticleDetailActivity::class.java)
        intent.putExtra(ArticleDetailActivity.INTENT_KEY_ARTICLE_DATA, Gson().toJson(article))
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)

        // Presenterインスタンスを作成
        articleListPresenter = ArticleListPresenter(this)
        articleListPresenter.start()
        articleListPresenter.loadArticlesTask()

        // 記事一覧表示用ListViewを設定
        articleListView = findViewById(R.id.articles_list)
        articleListAdapter = ArticleListAdapter(this)
        articleListView.adapter = articleListAdapter
        articleListView.onItemClickListener = ArticlesListClickEvent()
    }

    // 記事一覧ListViewの項目タップイベント
    internal inner class ArticlesListClickEvent : AdapterView.OnItemClickListener {
        override fun onItemClick(adapter: AdapterView<*>, view: View, position: Int, id: Long) {
            articleListPresenter.selectArticleTask(position)
        }
    }

}
