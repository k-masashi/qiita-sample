package kngapp.cleansample.api

/**
 * Created by masashi on 2018/08/10.
 *
 * Apiリクエスト失敗(レスポンスが返されなかった場合)イベント
 */

data class ApiRequestFailedEvent(
        // エラー情報
        val errorStatus: ApiRequestErrorStatus,
        // 通信したAPIの名前
        val apiName: ApiConstants.ApiName,
        // エラー文言
        val errorMessage: String? = null)

/**
 * Apiリクエスト失敗時(レスポンスが返されなかった場合)のステータス定義
 *
 * サンプルアプリのため、いくつかピックアップ
 */
enum class ApiRequestErrorStatus {
    NETWORK_ERROR,
    OTHER_ERROR
}