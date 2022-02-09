package com.bbq.textlauncher.activity

import android.R
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity


/**
 * @ProjectName : textLauncher
 * @Author : bbq
 * @Time : 2021/10/27 10:07
 * @Description : 父类activity，负责主体控制
 */
@Suppress("DEPRECATION")
open class BaseActivity : AppCompatActivity() {

    /**
     * 如果需要内容紧贴着StatusBar
     * 应该在对应的xml布局文件中，设置根布局fitsSystemWindows=true。
     */
    private var contentViewGroup: View? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setStatusBarFullTransparent()
    }

    /**
     * 全透状态栏
     */
    private fun setStatusBarFullTransparent() {
        val window: Window = window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.TRANSPARENT
    }

    /**
     * 半透明状态栏
     */
    private fun setHalfTransparent() {
        val decorView: View = window.decorView
        val option: Int = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        decorView.systemUiVisibility = option
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    }


    protected fun setFitSystemWindow(fitSystemWindow: Boolean) {
        if (contentViewGroup == null) {
            contentViewGroup = (findViewById<View>(R.id.content) as ViewGroup).getChildAt(0)
        }
        contentViewGroup?.fitsSystemWindows = fitSystemWindow
    }


}