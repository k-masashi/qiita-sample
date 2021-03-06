package kngapp.cleansample.base

/**
 * Created by masashi on 2018/08/10.
 *
 * Base Repository クラス
 *
 * @param T 取得する情報を格納する型を指定
 * @param S 取得した結果を格納してPOSTするイベントの型
 */

interface BaseRepository<out T, in S> {
    fun start()
    fun stop()
    /**
     * 外部APIやDBから取得したレスポンスのパース処理
     *
     * @param response レスポンス文字列
     */
    fun parse(response: String): T?

    /**
     * 取得した結果をEventBusへPOSTするメソッド
     *
     * @param event EventBusでpostするイベント
     */
    fun postResult(event: S)
}