package lgbtisaude.oceanbrasil.com.fragments


import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_sobre.*
import kotlinx.android.synthetic.main.layout_no_has_connection.*
import lgbtisaude.oceanbrasil.com.R
import lgbtisaude.oceanbrasil.com.interfaces.IhasConnection
import lgbtisaude.oceanbrasil.com.model.PageWpModel
import lgbtisaude.oceanbrasil.com.model.util.DELAY_SWIPE
import lgbtisaude.oceanbrasil.com.model.util.NetworkStatus
import lgbtisaude.oceanbrasil.com.model.util.RetrofitInit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragmentSobre : Fragment(), SwipeRefreshLayout.OnRefreshListener,IhasConnection {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_sobre, container, false)
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

    override fun verifyIfHasConnection() =
            if(NetworkStatus(activity).hasConnection()){
                getAbout(RetrofitInit().getRetrofit().getOnePage(2))
                rlNoHasConnection.visibility=View.GONE
            }
            else {
                tvSobreTab.text=""
                onLoadComplete()
                rlNoHasConnection.visibility=View.VISIBLE
            }


    fun onLoadComplete(){
        Handler().postDelayed(object :Runnable{
            override fun run() {
                swiperefreshSobre.isRefreshing = false
            }
        }, DELAY_SWIPE)
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
                onLoadComplete()
            }
        })
    }

}// Required empty public constructor
