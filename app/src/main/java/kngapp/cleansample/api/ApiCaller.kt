package kngapp.cleansample.api

import android.os.Handler
import okhttp3.*
import org.greenrobot.eventbus.EventBus
import java.io.IOException

/**
 * Created by masashi on 2018/08/10.
 *
 * Apiリクエスト用の抽象クラス
 */

abstract class ApiCaller {
    // API指定
    abstract val apiName: ApiConstants.ApiName

    /**
     * Apiリクエスト生成用メソッド
     * @return Requestクラス
     */
    abstract fun createRequest(): Request

    /**
     * APIをリクエスト
     *
     * リクエスト結果をEventBusを利用してPOSTする
     */
    fun requestApi() {
        val handler = Handler()
        OkHttpClient().newCall(createRequest()).enqueue(object : Callback {

            // 失敗の場合はApiリクエスト失敗用のイベントをPOST
            override fun onFailure(call: Call?, e: IOException?) {
                var errorMessage = ""
                e?.let {
                    errorMessage = it.message.toString()
                }
                handler.post {
                    // 今回はサンプルアプリのためエラーステータスの判定は省略
                    EventBus.getDefault().post(ApiRequestFailedEvent(ApiRequestErrorStatus.OTHER_ERROR, apiName, errorMessage))
                }
            }

            // 成功の場合はApiリクエスト成功用のイベントをPOST
            override fun onResponse(call: Call?, response: Response?) {
                var body = ""
                if (response == null) {
                    handler.post {
                        EventBus.getDefault().post(ApiRequestFailedEvent(ApiRequestErrorStatus.NO_RESULT, apiName, ""))
                    }
                    return
                } else {
                    response.body()?.let {
                        body = it.string()
                    }
                }
                handler.post {
                    EventBus.getDefault().post(ApiRequestSuccessEvent(response, body, apiName, null))
                }
            }
        })
    }

}