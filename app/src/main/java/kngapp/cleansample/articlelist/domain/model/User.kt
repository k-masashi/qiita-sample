package kngapp.cleansample.articlelist.domain.model

/**
 * Created by masashi on 2018/08/10.
 */

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("facebook_id")
    @Expose
    var facebookId: String? = null
    @SerializedName("followees_count")
    @Expose
    var followeesCount: Int? = null
    @SerializedName("followers_count")
    @Expose
    var followersCount: Int? = null
    @SerializedName("github_login_name")
    @Expose
    var githubLoginName: String? = null
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("items_count")
    @Expose
    var itemsCount: Int? = null
    @SerializedName("linkedin_id")
    @Expose
    var linkedinId: String? = null
    @SerializedName("location")
    @Expose
    var location: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("organization")
    @Expose
    var organization: String? = null
    @SerializedName("permanent_id")
    @Expose
    var permanentId: Int? = null
    @SerializedName("profile_image_url")
    @Expose
    var profileImageUrl: String? = null
    @SerializedName("twitter_screen_name")
    @Expose
    var twitterScreenName: String? = null
    @SerializedName("website_url")
    @Expose
    var websiteUrl: String? = null

}