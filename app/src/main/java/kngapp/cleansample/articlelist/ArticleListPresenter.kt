package kngapp.cleansample.articlelist

import kngapp.cleansample.articlelist.domain.model.Articles
import kngapp.cleansample.articlelist.domain.usecase.GetArticleListTaskEvent
import kngapp.cleansample.articlelist.domain.usecase.GetArticlesTask
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

/**
 * Created by masashi on 2018/08/09.
 *
 * 記事一覧画面のPresenter
 */

class ArticleListPresenter(private val view: ArticleListContract.View) : ArticleListContract.Presenter {
    private val getArticleTask = GetArticlesTask()
    private var articlesData :Articles? = null

    override fun start() {
        EventBus.getDefault().register(this)
    }

    override fun stop() {
        EventBus.getDefault().unregister(this)
        getArticleTask.stopTask()
    }

    override fun loadArticlesTask() {
        getArticleTask.startTask()
    }

    override fun selectArticleTask(which: Int) {
        articlesData?.list?.let {
            view.showArticleDetailActivity(it[which])
        }
    }

    @Subscribe
    override fun loadCompletedArticlesTask(event: GetArticleListTaskEvent) {
        if (event.isSuccess && event.articleList != null) {
            articlesData = event.articleList
            event.articleList.list?.let {
                view.showArticles(it)
                return
            }
        }
        view.showGetArticlesError()
    }

}