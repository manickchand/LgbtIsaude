package lgbtisaude.oceanbrasil.com.adapters

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_news.view.*
import lgbtisaude.oceanbrasil.com.R
import lgbtisaude.oceanbrasil.com.interfaces.IRecyclerViewOnClickListener
import lgbtisaude.oceanbrasil.com.model.NewsModel
import lgbtisaude.oceanbrasil.com.model.util.DateUtils

/**
 * Created by Ocean on 13/12/2017.
 */
class AdapterNews(val mContext:Context,val mListofNews:List<NewsModel>): RecyclerView.Adapter<AdapterNews.MyViewHolder>() {

    val mlayoutInflater:LayoutInflater = mContext.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater //
    var iRecyclerViewOnClickListener:IRecyclerViewOnClickListener?=null
    lateinit var view:View

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        view = mlayoutInflater.inflate(R.layout.item_news,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {

        try {
            Picasso.with(mContext).load(mListofNews.get(position).imageUrlNews).into(holder!!.ivImageItemNews,
                    object  : com.squareup.picasso.Callback{

                        override fun onSuccess() {
                            Log.e("Erro","certo picasso");
                        }

                        override fun onError() {
                            Log.e("Erro","Erro picasso");
                        }
                    })
        }catch (e:Exception){
            e.stackTrace
        }

        holder!!.tvNameItemNews.text = mListofNews.get(position).titleNews
        holder!!.tvDateItemNews.text = mListofNews.get(position).dateNews
    }


    override fun getItemCount(): Int {
        return mListofNews.size
    }

    fun setReciclerViewOnClickListener(r: IRecyclerViewOnClickListener) {
        this.iRecyclerViewOnClickListener = r
    }

    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView),View.OnClickListener{

        val ivImageItemNews:ImageView
        val tvNameItemNews:TextView
        val tvDateItemNews:TextView
        init {
            itemView.setOnClickListener(this)
            ivImageItemNews = itemView.ivImageItemNews
            tvNameItemNews = itemView.tvNameItemNews
            tvDateItemNews = itemView.tvDateItemNews
        }

        override fun onClick(v: View?) {
            iRecyclerViewOnClickListener!!.onClickRecyclerView(v!!, adapterPosition);
        }
    }

}