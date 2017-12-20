package lgbtisaude.oceanbrasil.com.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import lgbtisaude.oceanbrasil.com.R


/**
 * A simple [Fragment] subclass.
 */
class FragmentInfos : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_fragment_infos, container, false)
    }

}
