package kngapp.cleansample.articlelist.domain.model

/**
 * Created by masashi on 2018/08/10.
 */

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Tag {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("versions")
    @Expose
    var versions: List<Any>? = null

}