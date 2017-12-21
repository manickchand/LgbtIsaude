package lgbtisaude.oceanbrasil.com.fragments


import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_sobre.*
import lgbtisaude.oceanbrasil.com.R
import lgbtisaude.oceanbrasil.com.interfaces.IhasConnection
import lgbtisaude.oceanbrasil.com.model.PageWpModel
import lgbtisaude.oceanbrasil.com.model.util.AlertDialogLgbt
import lgbtisaude.oceanbrasil.com.model.util.NetworkStatus
import lgbtisaude.oceanbrasil.com.model.util.RetrofitInit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragmentSobre : Fragment(), SwipeRefreshLayout.OnRefreshListener,IhasConnection {


    private var call = RetrofitInit().getRetrofit().getOnePage(2)
    private lateinit var swiperefreshAbout:SwipeRefreshLayout
    private lateinit var alert: Dialog

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_sobre, container, false)
        swiperefreshAbout = view.findViewById<SwipeRefreshLayout>(R.id.swiperefreshSobre)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        swiperefreshSobre.setColorScheme(R.color.colorPrimary,
                R.color.colorAccent,
                R.color.colorBlue,
                R.color.colorGreen,
                R.color.colorOrange)

        swiperefreshSobre.setOnRefreshListener(this)

        verifyIfHasConnection()
    }

    override fun verifyIfHasConnection() {
        if (NetworkStatus(activity).hasConnection()) {
            call = RetrofitInit().getRetrofit().getOnePage(2)
            getAbout(call)
        } else {
            tvSobreTab.text = ""
            showDialog(R.string.no_network)
        }
    }


    override fun onLoadComplete(){
//        Handler().postDelayed(object :Runnable{
//            override fun run() {
//                swiperefreshSobre.isRefreshing = false
//            }
//        }, DELAY_SWIPE)

        swiperefreshAbout.isRefreshing = false
    }

    override fun onRefresh() {
        Log.i("ola","refresh");
      verifyIfHasConnection()
    }


    fun getAbout(call: Call<PageWpModel>){

        swiperefreshSobre.isRefreshing = true

        call.enqueue(object :Callback<PageWpModel>{
            override fun onResponse(call: Call<PageWpModel>?, response: Response<PageWpModel>?) {

               tvSobreTab.text = Html.fromHtml(response!!.body()!!.content!!.rendered)
                Log.i("ola","response sobre");
               onLoadComplete()
            }

            override fun onFailure(call: Call<PageWpModel>?, t: Throwable?) {
                Log.i("ola","erro call sobre");
                showDialog(R.string.error_connect_server)
            }
        })
    }

    override fun showDialog(msg: Int) {
        alert = AlertDialogLgbt.createDialog(msg,activity,this)

//        alert.setPositiveButton("Tentar novamente", object : DialogInterface.OnClickListener{
//            override fun onClick(dialog: DialogInterface?, which: Int) {
//                verifyIfHasConnection()
//                dialog!!.dismiss()
//            }
//        })

       // alert.create()
        alert.show()
        onLoadComplete()
    }

    override fun onPause() {
        super.onPause()
        Log.i("ola","onPause noticias");
        call.cancel()
        onLoadComplete()
    }

}// Required empty public constructor
