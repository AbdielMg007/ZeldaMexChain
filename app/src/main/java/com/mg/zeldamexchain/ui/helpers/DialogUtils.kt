package com.mg.zeldamexchain.ui.helpers

import android.app.AlertDialog
import android.content.Context

object DialogUtils{

    fun showAlertDialog(context: Context?, title: String, message: String, positiveButtonText: String) {
        AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(positiveButtonText, null)
            .create()
            .show()
    }
}
