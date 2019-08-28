package com.sun.moviedb.utils

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.sun.moviedb.R

object AlertDialogUtil {
    @SuppressLint("InflateParams", "SetTextI18n")
    fun showAppInfoMessageDialog(
            context: Context,
            cancelable: Boolean
    ) {
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_app_info, null)
        val textVersion = view.findViewById<TextView>(R.id.textVersion)
        val textBuildTime = view.findViewById<TextView>(R.id.textBuildTime)
        val textWeb = view.findViewById<TextView>(R.id.textWeb)
        val textEmail = view.findViewById<TextView>(R.id.textEmail)
        textVersion.text = context.getString(R.string.title_version) + DeviceUtil.getVersionApp() +
                DeviceUtil.getVersionData()
        textBuildTime.text = context.getString(R.string.title_build_time) +
                DeviceUtil.getBuildTime(context.getString(R.string.date_time12))
        textWeb.text = context.getString(R.string.link_website)
        textEmail.text = context.getString(R.string.email)
        val dialog = createDialog(context, cancelable, view)
        dialog.show()
        dialog.setCancelable(cancelable)
    }

    private fun createDialog(context: Context, cancelable: Boolean, view: View): Dialog {
        val dialog = AlertDialog.Builder(context)
                .setCancelable(cancelable)
                .setView(view)
                .create()
        dialog.window?.decorView?.setBackgroundResource(android.R.color.transparent)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return dialog
    }
}
