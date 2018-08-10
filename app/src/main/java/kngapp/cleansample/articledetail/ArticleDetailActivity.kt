package kngapp.cleansample.articledetail

/**
 * Created by masashi on 2018/08/09.
 *
 * 記事画面のView
 */

import android.os.Bundle
import android.widget.TextView
import kngapp.cleansample.R
import kngapp.cleansample.base.BaseActivity

class ArticleDetailActivity : BaseActivity(), ArticleDetailContract.View {
    companion object {
        val INTENT_KEY_ARTICLE_DATA = "article_data"
    }
    private lateinit var articleDetailPresenter: ArticleDetailPresenter
    private lateinit var interfacePresenter: ArticleDetailContract.Presenter
    private lateinit var bodyTextView: TextView

    override fun setPresenter(presenter: ArticleDetailContract.Presenter) {
        interfacePresenter = presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Presenterインスタンスを作成
        articleDetailPresenter = ArticleDetailPresenter(this)
        articleDetailPresenter.start()

        bodyTextView = findViewById(R.id.article_body)
    }

    override fun onStart() {
        super.onStart()
        articleDetailPresenter.loadArticleInfoTask(intent)
    }

    override fun showTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun showBody(body: String) {
        bodyTextView.text = body
    }

    override fun showFailedLoadBodyError() {
        // 本文取得失敗エラーをToastで表示
        showLongToast(this, getString(R.string.message_can_not_get_article_body_error))
    }

}