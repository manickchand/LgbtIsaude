package lgbtisaude.oceanbrasil.com.model.util

import android.text.Html
import lgbtisaude.oceanbrasil.com.model.NewsModel
import lgbtisaude.oceanbrasil.com.model.PostWpModel

/**
 * Created by Ocean on 19/12/2017.
 */
class WpToModel {


    fun wpToNoticia(mWplist:List<PostWpModel>):List<NewsModel>{

        var listOfNews:MutableList<NewsModel> =ArrayList<NewsModel>()

        for (i in mWplist.indices){

            var n = NewsModel()
            n.idNews = mWplist.get(i).getId()!!
            n.titleNews = mWplist.get(i).getTitle()!!.rendered.toString()
            n.textNews = Html.fromHtml(mWplist.get(i).getContent()!!.rendered!!).toString()
            n.dateNews = DateUtils().convertDate(mWplist.get(i).getDate().toString())
            n.imageUrlNews = mWplist.get(i).getBetterFeaturedImage()!!.sourceUrl!! ?: ""
            n.siteUrlNews = mWplist.get(i).getLink().toString()
            n.categoryNews = mWplist.get(i).getCategories()!!.get(0)

            listOfNews!!.add(n)

        }

        return listOfNews
    }
}