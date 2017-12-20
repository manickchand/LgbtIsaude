package lgbtisaude.oceanbrasil.com.model.util

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by Ocean on 14/12/2017.
 */
class NetworkStatus(var mContext:Context) {

    fun hasConnection():Boolean{
        val connectionManeger = mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectionManeger.activeNetworkInfo
        return activeNetwork !=null && activeNetwork.isConnectedOrConnecting
    }

}