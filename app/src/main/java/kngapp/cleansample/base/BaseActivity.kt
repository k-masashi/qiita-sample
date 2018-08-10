package kngapp.cleansample.base

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by masashi on 2018/08/10.
 *
 * Activityの共通処理をまとめて記述するためのBaseクラス
 */

open class BaseActivity : AppCompatActivity() {

    /**
     * Toast表示用メソッド
     * @param context コンテキスト
     * @param text 表示文字列
     */
    fun showShortToast(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    /**
     * Toast表示用メソッド
     * @param context コンテキスト
     * @param text 表示文字列
     */
    fun showLongToast(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }

}