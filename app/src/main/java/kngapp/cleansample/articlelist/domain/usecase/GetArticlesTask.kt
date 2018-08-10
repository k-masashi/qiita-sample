package kngapp.cleansample.articlelist.domain.usecase

import kngapp.cleansample.articlelist.repository.ArticleListRepository
import kngapp.cleansample.articlelist.repository.ArticleListRepositoryEvent
import kngapp.cleansample.base.BaseTask
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

/**
 * Created by masashi on 2018/08/09.
 *
 * 記事一覧取得ロジック
 */

class GetArticlesTask : BaseTask {

    override fun startTask() {
        EventBus.getDefault().register(this)
        // リポジトリクラスを用いて記事一覧を取得
        ArticleListRepository().start()
    }

    override fun stopTask() {
        EventBus.getDefault().unregister(this)
    }

    @Subscribe
    fun getRepositoryEvent(event: ArticleListRepositoryEvent) {
        if (event.isSuccess && event.articleList != null) {
            EventBus.getDefault().post(GetArticleListTaskEvent(true, event.articleList))
        } else {
            EventBus.getDefault().post(GetArticleListTaskEvent(false, null))
        }
        stopTask()
    }
}