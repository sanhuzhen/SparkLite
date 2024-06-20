package com.sanhuzhen.sparklite.util

import android.content.Context
import android.widget.Toast

object Toast {
    fun ToastLong(context: Context, msg: String){
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }
}