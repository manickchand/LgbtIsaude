package lgbtisaude.oceanbrasil.com.model.util

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import lgbtisaude.oceanbrasil.com.MainActivity
import lgbtisaude.oceanbrasil.com.interfaces.IhasConnection

/**
 * Created by Ocean on 20/12/2017.
 */
class AlertDialogLgbt {

    companion object {

        fun createDialog(message: Int, mContext: Context,inter:IhasConnection): Dialog {

            val alert = AlertDialog.Builder(mContext)
            alert.setMessage(mContext.resources.getString(message))
                    .setNegativeButton("Sair", object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            MainActivity().closeApp()
                        }
                    })
                    .setPositiveButton("Tentar novamente", object :DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        inter.verifyIfHasConnection()
                        dialog!!.dismiss()
                    }
                     })

            return alert.create()
        }
    }
}