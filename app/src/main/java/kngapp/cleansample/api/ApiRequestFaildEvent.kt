package kngapp.cleansample.api

/**
 * Created by masashi on 2018/08/10.
 *
 * Apiリクエスト失敗イベント
 */

data class ApiRequestFailedEvent(
        val errorStatus: ApiRequestErrorStatus,
        val apiName: ApiConstants.ApiName,
        val errorMessage: String? = null)

/**
 * Apiリクエスト失敗時のステータス定義
 *
 * サンプルアプリのため、いくつかピックアップ
 * デフォルトのエラーステータスを実際は利用した方が良い場合もある
 */
enum class ApiRequestErrorStatus {
    NO_RESULT,
    FORBIDDEN,
    INTERNAL_SERVER_ERROR,
    OTHER_ERROR
}