package com.bbq.textlauncher.weather

import android.app.Activity
import android.content.Context
import android.util.Log
import com.alibaba.fastjson.JSONObject
import com.bbq.textlauncher.db.DBWeatherInfo
import com.bbq.textlauncher.weather.json.JsonWeatherInfo
import com.bbq.textlauncher.weather.json.OnWeatherInfoListener
import com.bbq.textlauncher.weather.json.SimpleWeather
import org.litepal.LitePal

/**
 * @ProjectName : textLauncher
 * @Author : bbq
 * @Time : 2021/12/08 10:02
 * @Description : 用来处理天气组件的类
 */
class WeatherControl(val refreshWeatherListener: RefreshWeatherListener, val mContext: Context) {

    /**
     * 实例化天气模块组件
     */
    fun start() {

        val dbWeatherInfo: DBWeatherInfo? = LitePal.find(DBWeatherInfo::class.java, 1)

        //定位和位置设置后期再通过设置部分增加
        if (dbWeatherInfo == null || (System.currentTimeMillis() - dbWeatherInfo.updateTime) >= 30 * 60 * 1000) {
            Log.e("======", "====读取联网查询天气====")
            SimpleWeather.queryWeather("深圳", onWeatherInfoListener)

        } else {
            //半小时刷新一次，因为api一天只许查100次
            Log.e("======", "====读取本地天气缓存====")
            this.refreshWeatherListener.refreshWeather(JSONObject.parseObject(dbWeatherInfo.weather_info, JsonWeatherInfo::class.java))
        }

    }


    /**
     * 天气接口回调
     */
    private val onWeatherInfoListener: OnWeatherInfoListener = object : OnWeatherInfoListener {

        override fun onWeatherInfo(mJsonWeatherInfo: JsonWeatherInfo?) {

            if (mJsonWeatherInfo == null) {
                return
            }

            var dbWeatherInfo: DBWeatherInfo? = LitePal.find(DBWeatherInfo::class.java, 1)

            if (dbWeatherInfo == null) {
                dbWeatherInfo = DBWeatherInfo(
                        System.currentTimeMillis(),
                        mJsonWeatherInfo.result?.city.toString(),
                        JSONObject.toJSONString(mJsonWeatherInfo)
                )
            } else {
                dbWeatherInfo.updateTime = System.currentTimeMillis()

                dbWeatherInfo.city = mJsonWeatherInfo.result?.city.toString()

                dbWeatherInfo.weather_info = JSONObject.toJSONString(mJsonWeatherInfo)
            }

            val isSave = dbWeatherInfo.saveOrUpdate()

            Log.e("======", "==isSave==$isSave")

            (mContext as Activity).runOnUiThread {
                refreshWeatherListener.refreshWeather(mJsonWeatherInfo)
            }

        }

    }


}