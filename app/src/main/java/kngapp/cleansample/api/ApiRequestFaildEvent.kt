package kngapp.cleansample.api

/**
 * Created by masashi on 2018/08/10.
 *
 * Apiリクエスト失敗イベント
 */

data class ApiRequestFailedEvent(
        // エラーステータス
        val errorStatus: ApiRequestErrorStatus,
        // 通信したAPIの名前
        val apiName: ApiConstants.ApiName,
        // エラー文言
        val errorMessage: String? = null)

/**
 * Apiリクエスト失敗時のステータス定義
 *
 * サンプルアプリのため、いくつかピックアップ
 * デフォルトのエラーステータスを実際は利用した方が良いが簡易アプリのため用意
 */
enum class ApiRequestErrorStatus {
    NETWORK_ERROR,
    OTHER_ERROR
}