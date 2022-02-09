package com.bbq.textlauncher.db

import org.litepal.crud.LitePalSupport

/**
 * @ProjectName : textLauncher
 * @Author : bbq
 * @Time : 2021/11/08 16:24
 * @Description : 存储天气信息的数据库,更新时间，城市，接口json信息
 */
data class DBWeatherInfo(var updateTime: Long, var city: String, var weather_info: String) : LitePalSupport() {
    var id: Long = 0
}
