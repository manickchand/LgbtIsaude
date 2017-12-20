package lgbtisaude.oceanbrasil.com.activitys

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_news_detail.*
import kotlinx.android.synthetic.main.content_news_detail.*
import lgbtisaude.oceanbrasil.com.R
import lgbtisaude.oceanbrasil.com.model.NewsModel
import lgbtisaude.oceanbrasil.com.model.util.NEWS_SERIALIZABLE

class NewsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        setSupportActionBar(toolbar)

        Log.i("ola","NewsDetailActivity");
        var news: NewsModel? = intent.getSerializableExtra(NEWS_SERIALIZABLE) as? NewsModel

        setTitle("Detalhes da Notícia")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                finish()
            }
        })

        try {
            Picasso.with(this).load(news!!.imageUrlNews).into(ivNewsDetail,
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

        tvTextNewsDetail.text = news!!.textNews
        tvTitleNewsDetail.text = news!!.titleNews
        tvDateNewsDetail.text = news!!.dateNews

        fab.setOnClickListener { view ->
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"${resources.getString(R.string.share_text)} ${news.siteUrlNews}")
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent,"Compartilhe essa notícia"))
        }
    }

}
