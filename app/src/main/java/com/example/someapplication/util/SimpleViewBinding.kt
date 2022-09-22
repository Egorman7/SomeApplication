package com.example.someapplication.util

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlin.reflect.KProperty

inline fun <reified T: ViewDataBinding> Activity.simpleViewBinding(layoutId: Int) : ViewBinderDelegate<T> {
    return ViewBinderDelegate(this, layoutId)
}

class ViewBinderDelegate<T: ViewDataBinding>(context: Context, layoutId: Int) {
    private val storedBinding: T by lazy { DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, null, false) }
    operator fun getValue(owner: Any?, property: KProperty<*>) : T {
        return storedBinding
    }
}