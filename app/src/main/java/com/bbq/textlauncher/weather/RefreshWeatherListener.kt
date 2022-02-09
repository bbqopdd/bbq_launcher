package com.bbq.textlauncher.weather

import com.bbq.textlauncher.weather.json.JsonWeatherInfo

/**
 * @ProjectName : textLauncher
 * @Author : bbq
 * @Time : 2021/12/08 10:05
 * @Description : 暂无描述
 */
interface RefreshWeatherListener {

    fun refreshWeather(mJsonWeatherInfo: JsonWeatherInfo)

}