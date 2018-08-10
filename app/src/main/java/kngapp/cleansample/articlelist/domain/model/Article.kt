package kngapp.cleansample.articlelist.domain.model

/**
 * Created by masashi on 2018/08/09.
 */

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Article {
    @SerializedName("rendered_body")
    @Expose
    var renderedBody: String? = null
    @SerializedName("body")
    @Expose
    var body: String? = null
    @SerializedName("coediting")
    @Expose
    var coediting: Boolean? = null
    @SerializedName("comments_count")
    @Expose
    var commentsCount: Int? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("group")
    @Expose
    var group: Any? = null
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("likes_count")
    @Expose
    var likesCount: Int? = null
    @SerializedName("private")
    @Expose
    var private: Boolean? = null
    @SerializedName("reactions_count")
    @Expose
    var reactionsCount: Int? = null
    @SerializedName("tags")
    @Expose
    var tags: List<Tag>? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("user")
    @Expose
    var user: User? = null
    @SerializedName("page_views_count")
    @Expose
    var pageViewsCount: Any? = null

}