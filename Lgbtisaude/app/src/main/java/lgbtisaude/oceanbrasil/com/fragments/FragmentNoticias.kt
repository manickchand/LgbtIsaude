package lgbtisaude.oceanbrasil.com.fragments


import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_noticias.*
import kotlinx.android.synthetic.main.layout_no_has_connection.*
import lgbtisaude.oceanbrasil.com.R
import lgbtisaude.oceanbrasil.com.activitys.NewsDetailActivity
import lgbtisaude.oceanbrasil.com.adapters.AdapterNews
import lgbtisaude.oceanbrasil.com.interfaces.IRecyclerViewOnClickListener
import lgbtisaude.oceanbrasil.com.interfaces.IhasConnection
import lgbtisaude.oceanbrasil.com.model.NewsModel
import lgbtisaude.oceanbrasil.com.model.PostWpModel
import lgbtisaude.oceanbrasil.com.model.util.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentNoticias : Fragment(),
                            SwipeRefreshLayout.OnRefreshListener,
                            IhasConnection,
                            IRecyclerViewOnClickListener{

    private var mListOfNews =ArrayList<NewsModel>()
    private var call = RetrofitInit().getRetrofit().getAllNews()
    private lateinit var swiperefresh:SwipeRefreshLayout

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view =  inflater!!.inflate(R.layout.fragment_noticias, container, false)
        swiperefresh = view.findViewById<SwipeRefreshLayout>(R.id.swiperefresh)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("ola","onViewCreated noticias");
        swiperefresh.setColorScheme(R.color.colorPrimary,
                R.color.colorAccent,
                R.color.colorBlue,
                R.color.colorGreen,
                R.color.colorOrange)

        swiperefresh.setOnRefreshListener(this)

        val llm = LinearLayoutManager(activity)
        llm.orientation = LinearLayoutManager.VERTICAL
        rvNews.setHasFixedSize(true)
        rvNews.layoutManager = llm

        verifyIfHasConnection()
    }

    override fun verifyIfHasConnection() {
        if (NetworkStatus(activity).hasConnection()) {
            call = RetrofitInit().getRetrofit().getAllNews()
            getNews(call)
        } else {

            var alert = AlertDialogNoNetwork().createDialog(activity,activity)
            alert.setPositiveButton("Tentar Novamente", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    verifyIfHasConnection()
                    dialog!!.dismiss()
                }
            })

            alert.create()
            alert.show()
            onLoadComplete()
        }
    }
//
    fun getNews(call:Call<List<PostWpModel>>){

        Log.i("ola","call.isExecuted = ${!call.isExecuted}");

           swiperefresh.isRefreshing = true
           call.enqueue(object : Callback<List<PostWpModel>> {
               override fun onResponse(call: Call<List<PostWpModel>>?, response: Response<List<PostWpModel>>?) {

                   Log.i("ola","response ok");

                   mListOfNews = WpToModel().wpToNoticia(response!!.body()!!) as ArrayList<NewsModel>

                   var ad = AdapterNews(activity, mListOfNews)
                   ad.setReciclerViewOnClickListener(this@FragmentNoticias)
                   rvNews!!.adapter = ad
                   onLoadComplete()
               }

               override fun onFailure(call: Call<List<PostWpModel>>?, t: Throwable?) {
                   Log.i("ola","erro ${t.toString()}");

                   onLoadComplete()
               }
           })


    }


    fun onLoadComplete(){
//        Handler().postDelayed(object :Runnable{
//            override fun run() {
//                swiperefresh.isRefreshing = false
//            }
//        }, DELAY_SWIPE)
        swiperefresh.isRefreshing = false
    }

    override fun onRefresh() {
        Log.i("ola","refresh");
        call.cancel()
        verifyIfHasConnection()
    }

    override fun onClickRecyclerView(v: View, position: Int) {

       val intent = Intent(activity,NewsDetailActivity::class.java)
        intent.putExtra(NEWS_SERIALIZABLE,mListOfNews.get(position))
        startActivity(intent)
    }

    override fun onPause() {
        super.onPause()
        Log.i("ola","onPause noticias");
        call.cancel()
        swiperefresh.isRefreshing = false
    }

    override fun onResume() {
        super.onResume()
        Log.i("ola","onResume noticias");
    }
}
