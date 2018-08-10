package kngapp.cleansample.api

import okhttp3.Request

/**
 * Created by masashi on 2018/08/10.
 *
 * キータの記事一覧を取得するApiのリクエストクラス
 */

class ArticleListApiCaller(private val query: String) : ApiCaller() {
    override val apiName: ApiConstants.ApiName = ApiConstants.ApiName.GET_ARTICLES_API
    override fun createRequest(): Request {
        return Request.Builder()
                .url(ApiConstants.GET_ARTICLES_API_URL + query)
                .get()
                .build()
    }

}