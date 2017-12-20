package lgbtisaude.oceanbrasil.com.model.util

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog

/**
 * Created by Ocean on 20/12/2017.
 */
class AlertDialogNoNetwork {

    fun createDialog(mActivity:Activity,mContext:Context):AlertDialog.Builder{

        val alert = AlertDialog.Builder(mContext)
        alert.setMessage("Sem Conexão =(")
                .setNegativeButton("Sair",object :DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        mActivity.finish()
                    }
                })


        return alert
    }

}