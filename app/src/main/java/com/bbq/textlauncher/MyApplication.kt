package com.bbq.textlauncher

import android.app.Application
import org.litepal.LitePal

/**
 * @ProjectName : textLauncher
 * @Author : bbq
 * @Time : 2021/11/10 11:48
 * @Description : 暂无描述
 */
class MyApplication:Application() {


    override fun onCreate() {
        super.onCreate()
        //实例化数据库插件
        LitePal.initialize(this)
    }


}