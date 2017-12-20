package lgbtisaude.oceanbrasil.com.interfaces

import lgbtisaude.oceanbrasil.com.model.PostWpModel
import lgbtisaude.oceanbrasil.com.model.PageWpModel
import lgbtisaude.oceanbrasil.com.model.util.ID_CATEGORIE_INFO
import lgbtisaude.oceanbrasil.com.model.util.ID_CATEGORIE_NEWS
import lgbtisaude.oceanbrasil.com.model.util.PAGE_CONSTANT
import lgbtisaude.oceanbrasil.com.model.util.POSTS_CONSTANT

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Ocean on 13/12/2017.
 */
interface IserviceRetrofit {

    @GET("$POSTS_CONSTANT?categories=$ID_CATEGORIE_NEWS")
    fun getAllNews():Call<List<PostWpModel>>

    @GET("$POSTS_CONSTANT?categories=$ID_CATEGORIE_INFO")
    fun getAllInfos():Call<List<PostWpModel>>

    @GET("$POSTS_CONSTANT/{id}")
    fun getOnePost(@Path("id") id:Int):Call<PostWpModel>

    @GET("$PAGE_CONSTANT/{id}")
    fun getOnePage(@Path("id") id:Int):Call<PageWpModel>

}