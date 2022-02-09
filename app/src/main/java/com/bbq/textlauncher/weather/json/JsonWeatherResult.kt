package com.bbq.textlauncher.weather.json

/**
 * @ProjectName : textLauncher
 * @Author : bbq
 * @Time : 2021/11/01 14:24
 * @Description : 暂无描述
 */
object JsonWeatherResult {

    var city: String = ""

    var realtime: JsonWeatherRealtime? = null

    var future: Array<JsonWeatherFuture>? = null

}