package lgbtisaude.oceanbrasil.com.model.util

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Ocean on 14/12/2017.
 */
class DateUtils {

    fun convertDate(dateNews:String):String{
        var dateFormat = SimpleDateFormat("yyyy-MM-dd")
        var date:Date = dateFormat.parse(dateNews)

        dateFormat =  SimpleDateFormat("dd/MM/yyyy")

        var dateToReturn = ""
        Log.e("Erro","dateNews: $dateNews");

        try {
            dateToReturn = dateFormat.format(date).toString()
        }catch (e:Exception){
           e.printStackTrace()
        }
        return dateToReturn
    }
}