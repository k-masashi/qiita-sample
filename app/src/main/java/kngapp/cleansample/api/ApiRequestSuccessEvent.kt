package kngapp.cleansample.api

/**
 * Created by masashi on 2018/08/10.
 *
 * APIリクエスト成功イベント
 */

data class ApiRequestSuccessEvent(
        val result: Any?,
        val body: String,
        val apiName: ApiConstants.ApiName,
        val error: String? = null)
