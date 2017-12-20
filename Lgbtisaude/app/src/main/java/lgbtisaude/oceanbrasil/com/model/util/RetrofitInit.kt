package lgbtisaude.oceanbrasil.com.model.util

import lgbtisaude.oceanbrasil.com.interfaces.IserviceRetrofit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Ocean on 13/12/2017.
 */
class RetrofitInit {

    val CONNECT_TIMEOUT:Long = 5
    val READ_TIMEOUT:Long = 30
    val WRITE_TIMEOUT:Long = 15

    fun getRetrofit():IserviceRetrofit{
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(settingClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val iServiceRetrofit =  retrofit.create(IserviceRetrofit::class.java)

        return iServiceRetrofit
    }

    //configure timeout
    fun settingClient():OkHttpClient{
        val client = OkHttpClient().newBuilder()
        client.connectTimeout(CONNECT_TIMEOUT,TimeUnit.SECONDS)
        client.readTimeout(READ_TIMEOUT,TimeUnit.SECONDS)
        client.writeTimeout(WRITE_TIMEOUT,TimeUnit.SECONDS)

        return client.build()
    }

}