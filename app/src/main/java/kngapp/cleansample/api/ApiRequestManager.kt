package kngapp.cleansample.api

import android.os.Handler
import okhttp3.*
import org.greenrobot.eventbus.EventBus
import java.io.IOException

/**
 * Created by masashi on 2018/08/10.
 *
 * APIリクエスト用の抽象クラス
 * 各APIごとに継承してAPIリクエスト用のクラスを作成
 */

abstract class ApiRequestManager {
    // APIの名前をオーバーライドして指定
    abstract val apiName: ApiConstants.ApiName

    /**
     * APIリクエスト生成用メソッド
     * APIごとに必要なリクエストを作成するメソッドを実装する
     *
     * @return Requestクラス
     */
    abstract fun createRequest(): Request

    /**
     * APIをリクエスト
     * リクエスト結果をEventBusを利用してPOSTする
     */
    fun requestApi() {
        val handler = Handler()
        OkHttpClient().newCall(createRequest()).enqueue(object : Callback {

            // 失敗の場合(ネットワーク接続失敗など)はApiリクエスト失敗用のイベントをPOST
            override fun onFailure(call: Call?, e: IOException?) {
                var errorMessage = ""
                e?.let {
                    errorMessage = it.message.toString()
                }
                handler.post {
                    EventBus.getDefault().post(ApiRequestFailedEvent(ApiRequestErrorStatus.NETWORK_ERROR, apiName, errorMessage))
                }
            }

            // 成功の場合(レスポンスが返却された場合)はApiリクエスト成功用のイベントをPOST
            override fun onResponse(call: Call?, response: Response?) {
                var body = ""
                if (response == null) {
                    handler.post {
                        EventBus.getDefault().post(ApiRequestFailedEvent(ApiRequestErrorStatus.OTHER_ERROR, apiName, ""))
                    }
                    return
                }

                response.body()?.let {
                    body = it.string()
                }

                handler.post {
                    EventBus.getDefault().post(ApiRequestSuccessEvent(response, body, apiName, null))
                }
            }
        })
    }

}