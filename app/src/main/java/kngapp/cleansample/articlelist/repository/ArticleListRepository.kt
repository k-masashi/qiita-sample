package kngapp.cleansample.articlelist.repository

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import kngapp.cleansample.api.ApiRequestFailedEvent
import kngapp.cleansample.api.ApiRequestSuccessEvent
import kngapp.cleansample.api.ArticleListApiManager
import kngapp.cleansample.articlelist.domain.model.Articles
import kngapp.cleansample.base.BaseRepository
import okhttp3.Response
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

/**
 * Created by masashi on 2018/08/10.
 *
 * 記事一覧を取得するRepositoryクラス
 * 外部APIやDBとのやり取りはRepositoryクラスのみから行う
 */

class ArticleListRepository: BaseRepository<Articles, ArticleListRepositoryEvent> {

    override fun start() {
        EventBus.getDefault().register(this)
        //記事取得APIをリクエスト
        //サンプルアプリのためクエリーはダミーの「android」
        ArticleListApiManager("android").requestApi()
    }

    override fun stop() {
        EventBus.getDefault().unregister(this)
    }

    override fun parse(response: String): Articles? {
        return try {
            Gson().fromJson(response, Articles::class.java)
        } catch (e: JsonSyntaxException) {
            null
        }
    }

    override fun postResult(event: ArticleListRepositoryEvent) {
        EventBus.getDefault().post(event)
    }

    // APIからの成功レスポンスを取得するSubscribeメソッド
    @Subscribe
    fun getApiSuccessEvent(event: ApiRequestSuccessEvent) {
        if (event.result != null && event.result is Response && event.result.code() == 200) {
            // パース処理のため、レスポンスを加工
            val body = "{\"articles\":" + event.body + "}"
            val articles = parse(body)
            postResult(ArticleListRepositoryEvent(true, articles))
        } else {
            postResult(ArticleListRepositoryEvent(false, null))
        }
        stop()
    }

    // APIからの失敗レスポンスを取得するSubscribeメソッド
    @Subscribe
    fun getApiFailedEvent(event: ApiRequestFailedEvent) {
        postResult(ArticleListRepositoryEvent(false, null))
        stop()
    }
}
