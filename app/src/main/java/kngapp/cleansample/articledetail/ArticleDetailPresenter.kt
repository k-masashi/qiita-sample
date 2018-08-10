package kngapp.cleansample.articledetail

/**
 * Created by masashi on 2018/08/09.
 *
 * 記事画面のPresenter
 */

import android.content.Intent
import com.google.gson.Gson
import kngapp.cleansample.articlelist.domain.model.Article

class ArticleDetailPresenter(private val view: ArticleDetailContract.View) : ArticleDetailContract.Presenter {
    private var articleData: Article? = null

    override fun start() {
    }

    override fun stop() {
    }

    override fun loadArticleInfoTask(intent: Intent?) {
        intent?.let {
            val articleJsonString = it.getStringExtra(ArticleDetailActivity.INTENT_KEY_ARTICLE_DATA)
            if (!articleJsonString.isEmpty()) {
                val article = Gson().fromJson<Article>(articleJsonString, Article::class.java)
                this.articleData = article
                article.title?.let {
                    view.showTitle(it)
                }
                article.body?.let {
                    view.showBody(it)
                    return
                }
            }
        }
        view.showFailedLoadBodyError()
    }

}