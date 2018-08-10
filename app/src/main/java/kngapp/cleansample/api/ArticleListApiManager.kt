package kngapp.cleansample.api

import okhttp3.Request

/**
 * Created by masashi on 2018/08/10.
 *
 * Qiitaの記事一覧を取得するAPIとの通信を行うクラス
 * APIリクエスト用の抽象クラスを継承して実装
 *
 * @param query QiitaのAPIに付与するQueryパラメータ
 */

class ArticleListApiManager(private val query: String) : ApiRequestManager() {
    // APIの名前をキータの記事一覧取得APIに指定
    override val apiName: ApiConstants.ApiName = ApiConstants.ApiName.GET_ARTICLES_API

    // APIのリクエストを作成する
    override fun createRequest(): Request {
        return Request.Builder()
                .url(ApiConstants.GET_ARTICLES_API_URL + query)
                .get()
                .build()
    }

}