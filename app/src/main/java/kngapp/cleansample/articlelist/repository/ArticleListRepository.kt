package kngapp.cleansample.articlelist.repository

import com.google.gson.Gson
import kngapp.cleansample.api.ApiRequestFailedEvent
import kngapp.cleansample.api.ApiRequestSuccessEvent
import kngapp.cleansample.api.ArticleListApiCaller
import kngapp.cleansample.articlelist.domain.model.Articles
import kngapp.cleansample.base.BaseRepository
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

/**
 * Created by masashi on 2018/08/10.
 *
 * 記事一覧を取得するRepositoryクラス
 */

class ArticleListRepository: BaseRepository<Articles, ArticleListRepositoryEvent> {
    override fun start() {
        EventBus.getDefault().register(this)
        //記事取得APIをリクエスト
        //サンプルアプリのためクエリーはダミーの「android」
        ArticleListApiCaller("android").requestApi()
    }

    override fun stop() {
        EventBus.getDefault().unregister(this)
    }

    override fun parse(response: String): Articles? {
        return Gson().fromJson(response, Articles::class.java)
    }

    override fun postResult(event: ArticleListRepositoryEvent) {
        EventBus.getDefault().post(event)
    }

    @Subscribe
    fun getApiSuccessEvent(event: ApiRequestSuccessEvent) {
        // パース処理のため、レスポンスを加工
        val body = "{\"articles\":" + event.body + "}"
        val articles = parse(body)
        postResult(ArticleListRepositoryEvent(true, articles))
        stop()
    }

    @Subscribe
    fun getApiFailedEvent(event: ApiRequestFailedEvent) {
        postResult(ArticleListRepositoryEvent(false, null))
        stop()
    }
}
