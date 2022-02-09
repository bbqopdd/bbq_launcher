package com.bbq.textlauncher.weather.json

/**
 * @ProjectName : textLauncher
 * @Author : bbq
 * @Time : 2021/11/02 9:37
 * @Description : 暂无描述
 */
object JsonWeatherFuture {

//    "date":"2021-11-01",
//    "temperature":"22\/29℃",
//    "weather":"晴",
//    "wid":{
//        "day":"00",
//        "night":"00"
//    },
//    "direct":"持续无风向"

    //时间
    var data: String = ""

    //温度
    var temperature: String = ""

    //天气情况
    var weather: String = ""

    var wid: JsonWid? = null

    //风向
    var direct: String = ""

    object JsonWid {
        var day: String = ""

        var night: String = ""
    }

}