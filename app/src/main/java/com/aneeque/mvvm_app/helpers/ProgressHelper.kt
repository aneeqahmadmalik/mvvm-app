package com.aneeque.mvvm_app.helpers

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import com.aneeque.mvvm_app.R


object ProgressHelper {
    private var dialog: AlertDialog? = null

    @SuppressLint("MissingInflatedId")
    fun showProgressDialog(context: Context, message: String) {
        if (dialog == null) {
            val dialogView =
                LayoutInflater.from(context).inflate(R.layout.progress_dialog, null)
            val tvMessage = dialogView.findViewById<TextView>(R.id.tvMessage)
            tvMessage.text = message

            dialog = AlertDialog.Builder(context)
                .setCancelable(true)
                .setView(dialogView)
                .create()

            dialog?.show()
        }
    }

    fun dismissDialog() {
        if (dialog != null) {
            dialog?.dismiss()
            dialog = null
        }
    }
}