package lgbtisaude.oceanbrasil.com.model

import java.io.Serializable

/**
 * Created by Ocean on 18/12/2017.
 */
class NewsModel :Serializable {
    var idNews:Int = -1
    var titleNews:String = ""
    var textNews:String = ""
    var dateNews:String = ""
    var imageUrlNews:String = ""
    var siteUrlNews:String = ""
    var categoryNews:Int=-1
}