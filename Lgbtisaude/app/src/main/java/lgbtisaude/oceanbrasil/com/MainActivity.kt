package lgbtisaude.oceanbrasil.com

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import lgbtisaude.oceanbrasil.com.fragments.FragmentInfos
import lgbtisaude.oceanbrasil.com.fragments.FragmentNoticias
import lgbtisaude.oceanbrasil.com.fragments.FragmentSobre
import lgbtisaude.oceanbrasil.com.model.util.KEY_FRAGMENT

class MainActivity : AppCompatActivity(),BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        bottom_nav_view.setOnNavigationItemSelectedListener(this)

        if( supportFragmentManager.findFragmentByTag(KEY_FRAGMENT) == null ) {
            changeFragment(FragmentNoticias())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
       // menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        var fragment:Fragment

        when(item.itemId){
            R.id.nav_news->fragment = FragmentNoticias()
            R.id.nav_info->fragment = FragmentInfos()
            else->fragment = FragmentSobre()
        }

        changeFragment(fragment)

        return true
    }


    private fun changeFragment( fragment: Fragment ){

        /*
         * Remove as pilhas de fragmentos para que não haja a
         * possibilidade de navegação entre os itens do
         * BottomNavigation, respeitando assim uma das regras
         * de negócio deste componente.
         * */
        supportFragmentManager
                .popBackStack( null, FragmentManager.POP_BACK_STACK_INCLUSIVE )

        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations( android.R.anim.fade_in, android.R.anim.fade_out )
                .replace(R.id.rl_container, fragment, KEY_FRAGMENT)
                .commit()
    }

   fun closeApp(){
       finish()
   }


}
