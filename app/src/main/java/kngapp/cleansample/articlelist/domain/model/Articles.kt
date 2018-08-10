package kngapp.cleansample.articlelist.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Articles {

    @SerializedName("articles")
    @Expose
    var list: List<Article>? = null

}