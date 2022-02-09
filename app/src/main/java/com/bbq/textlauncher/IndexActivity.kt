package com.bbq.textlauncher

import android.app.WallpaperManager
import android.content.Context
import android.graphics.drawable.Drawable
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.util.Log
import com.alibaba.fastjson.JSONObject
import com.bbq.textlauncher.activity.BaseActivity
import com.bbq.textlauncher.weather.data.WeatherWids
import com.bbq.textlauncher.weather.data.WidsTypeIcon
import com.bbq.textlauncher.databinding.ActivityIndexBinding
import com.bbq.textlauncher.db.DBWeatherInfo
import com.bbq.textlauncher.weather.RefreshWeatherListener
import com.bbq.textlauncher.weather.WeatherControl
import com.bbq.textlauncher.weather.json.JsonWeatherInfo
import com.bbq.textlauncher.weather.json.OnWeatherInfoListener
import com.bbq.textlauncher.weather.json.SimpleWeather
import org.litepal.LitePal
import java.util.*

/**
 * @ProjectName : textLauncher
 * @Author : bbq
 * @Time : 2021/10/28 13:43
 * @Description : 暂无描述
 */
class IndexActivity : BaseActivity() {

    private lateinit var mActivityIndexBinding: ActivityIndexBinding

    private lateinit var mWallpaperManager: WallpaperManager

    private lateinit var mDrawable: Drawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityIndexBinding = ActivityIndexBinding.inflate(layoutInflater)
        setContentView(mActivityIndexBinding.root)

        // 获取壁纸管理器
        mWallpaperManager = WallpaperManager.getInstance(this)

        // 获取壁纸
        mDrawable = mWallpaperManager.drawable

    }


    override fun onResume() {
        super.onResume()

        //天气组件
        WeatherControl(refreshWeatherListener, this).start()


    }


    /**
     *
     * 刷新天气UI模块显示信息
     */
    private val refreshWeatherListener: RefreshWeatherListener = object : RefreshWeatherListener {
        override fun refreshWeather(mJsonWeatherInfo: JsonWeatherInfo) {

            var weatherWids: WidsTypeIcon? = WeatherWids(TreeMap()).wids(mJsonWeatherInfo.result?.realtime?.wid)

            mActivityIndexBinding.viewWeatherWidget.imgWeatherIcon.setBackgroundResource(weatherWids!!.typeIconID)

            var str = mJsonWeatherInfo.result?.realtime?.temperature

            if (!str!!.contains("-")) {
                str = "+$str℃"
            }

            mActivityIndexBinding.viewWeatherWidget.txtWeatherInfo.text = str

            var txtWeatherMsg: String =
                    mJsonWeatherInfo.result!!.realtime!!.info +
                            "  空气质量：" + mJsonWeatherInfo.result!!.realtime!!.aqi +
                            "  湿度：" + mJsonWeatherInfo.result!!.realtime!!.humidity

            mActivityIndexBinding.viewWeatherWidget.txtWeatherMsg.text = txtWeatherMsg

        }
    }


}