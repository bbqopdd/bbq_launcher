package com.bbq.textlauncher.weather.data

import com.bbq.textlauncher.R
import java.util.*

/**
 * @ProjectName : textLauncher
 * @Author : bbq
 * @Time : 2021/11/04 16:00
 * @Description : 默认预制的天气种类，由聚合api接口提供
 */
data class WeatherWids(val wid: TreeMap<String, WidsTypeIcon>) {

    fun wids(key: String?): WidsTypeIcon? {
        wid["00"] = WidsTypeIcon("晴", R.drawable.ic_eclipse_weather_sun_moon_stars)
        wid["01"] = WidsTypeIcon("多云", R.drawable.ic_sunny_sun_cloud_weather_cloudy)
        wid["02"] = WidsTypeIcon("阴", R.drawable.ic_cloudy_clouds_cloud_weather_sky)
        wid["03"] = WidsTypeIcon("阵雨", R.drawable.ic_umbrella_rain_weather_sun)
        wid["04"] = WidsTypeIcon("雷阵雨", R.drawable.ic_lightning_cloud_cloudy_weather_thunder_thunderbolt)
        wid["05"] = WidsTypeIcon("雷阵雨伴有冰雹", R.drawable.ic_meteor_meteorite_fire_balls)
        wid["06"] = WidsTypeIcon("雨夹雪", R.drawable.ic_weather_clouds_cloudy_snowflakes_stormy)
        wid["07"] = WidsTypeIcon("小雨", R.drawable.ic_raining_clouds_smail_rain_cloudy_rainy_weather)
        wid["08"] = WidsTypeIcon("中雨", R.drawable.ic_raining_clouds_high_rain_cloudy_rainy_weather)
        wid["09"] = WidsTypeIcon("大雨", R.drawable.ic_raining_clouds_rain_cloudy_rainy_weather)
        wid["10"] = WidsTypeIcon("暴雨", R.drawable.ic_raining_clouds_very_more_rain_cloudy_rainy_weather)
        wid["11"] = WidsTypeIcon("大暴雨", R.drawable.ic_raining_clouds_very_more_rain_cloudy_rainy_weather)
        wid["12"] = WidsTypeIcon("特大暴雨", R.drawable.ic_flood_house_water_natural_phenomenon_catastrophe)
        wid["13"] = WidsTypeIcon("阵雪", R.drawable.ic_weather_clouds_cloudy_snowflakes_stormy)
        wid["14"] = WidsTypeIcon("小雪", R.drawable.ic_snowy_clouds_lite_snow_cloudy_weather_snowflakes)
        wid["15"] = WidsTypeIcon("中雪", R.drawable.ic_snowy_clouds_high_snow_cloudy_weather_snowflakes)
        wid["16"] = WidsTypeIcon("大雪", R.drawable.ic_raining_clouds_very_more_rain_cloudy_rainy_weather)
        wid["17"] = WidsTypeIcon("暴雪", R.drawable.ic_snowy_clouds_very_more_than_snow_cloudy_weather_snowflakes)
        wid["18"] = WidsTypeIcon("雾", R.drawable.ic_smog_earth_world_planet_clouds_cloudy)
        wid["19"] = WidsTypeIcon("冻雨", R.drawable.ic_cold_wave_thermometer_wind_cold)
        wid["20"] = WidsTypeIcon("沙尘暴", R.drawable.ic_tornado_twister_weather_natural_phenomenon_wind)
        wid["21"] = WidsTypeIcon("小到中雨", R.drawable.ic_raining_clouds_rain_cloudy_rainy_weather)
        wid["22"] = WidsTypeIcon("中到大雨", R.drawable.ic_raining_clouds_rain_cloudy_rainy_weather)
        wid["23"] = WidsTypeIcon("大到暴雨", R.drawable.ic_raining_clouds_rain_cloudy_rainy_weather)
        wid["24"] = WidsTypeIcon("暴雨到大暴雨", R.drawable.ic_raining_clouds_rain_cloudy_rainy_weather)
        wid["25"] = WidsTypeIcon("大暴雨到特大暴雨", R.drawable.ic_raining_clouds_rain_cloudy_rainy_weather)
        wid["26"] = WidsTypeIcon("小到中雪", R.drawable.ic_snowy_clouds_snow_cloudy_weather_snowflakes)
        wid["27"] = WidsTypeIcon("中到大雪", R.drawable.ic_snowy_clouds_snow_cloudy_weather_snowflakes)
        wid["28"] = WidsTypeIcon("大到暴雪", R.drawable.ic_snowy_clouds_snow_cloudy_weather_snowflakes)
        wid["29"] = WidsTypeIcon("浮尘", R.drawable.ic_wind_weather_forecast_leaves_leaf_breeze_autumn)
        wid["30"] = WidsTypeIcon("扬沙", R.drawable.ic_windy_wind_palm_tree_weather)
        wid["31"] = WidsTypeIcon("强沙尘暴", R.drawable.ic_autumn_weather_season)
        wid["53"] = WidsTypeIcon("霾", R.drawable.ic_windsocks_wind_flag_weather_time)
        return wid[key]
    }


//    {
//        "reason": "查询成功",
//        "result": [
//        {
//            "wid": "00",
//            "weather": "晴"
//        },
//        {
//            "wid": "01",
//            "weather": "多云"
//        },
//        {
//            "wid": "02",
//            "weather": "阴"
//        },
//        {
//            "wid": "03",
//            "weather": "阵雨"
//        },
//        {
//            "wid": "04",
//            "weather": "雷阵雨"
//        },
//        {
//            "wid": "05",
//            "weather": "雷阵雨伴有冰雹"
//        },
//        {
//            "wid": "06",
//            "weather": "雨夹雪"
//        },
//        {
//            "wid": "07",
//            "weather": "小雨"
//        },
//        {
//            "wid": "08",
//            "weather": "中雨"
//        },
//        {
//            "wid": "09",
//            "weather": "大雨"
//        },
//        {
//            "wid": "10",
//            "weather": "暴雨"
//        },
//        {
//            "wid": "11",
//            "weather": "大暴雨"
//        },
//        {
//            "wid": "12",
//            "weather": "特大暴雨"
//        },
//        {
//            "wid": "13",
//            "weather": "阵雪"
//        },
//        {
//            "wid": "14",
//            "weather": "小雪"
//        },
//        {
//            "wid": "15",
//            "weather": "中雪"
//        },
//        {
//            "wid": "16",
//            "weather": "大雪"
//        },
//        {
//            "wid": "17",
//            "weather": "暴雪"
//        },
//        {
//            "wid": "18",
//            "weather": "雾"
//        },
//        {
//            "wid": "19",
//            "weather": "冻雨"
//        },
//        {
//            "wid": "20",
//            "weather": "沙尘暴"
//        },
//        {
//            "wid": "21",
//            "weather": "小到中雨"
//        },
//        {
//            "wid": "22",
//            "weather": "中到大雨"
//        },
//        {
//            "wid": "23",
//            "weather": "大到暴雨"
//        },
//        {
//            "wid": "24",
//            "weather": "暴雨到大暴雨"
//        },
//        {
//            "wid": "25",
//            "weather": "大暴雨到特大暴雨"
//        },
//        {
//            "wid": "26",
//            "weather": "小到中雪"
//        },
//        {
//            "wid": "27",
//            "weather": "中到大雪"
//        },
//        {
//            "wid": "28",
//            "weather": "大到暴雪"
//        },
//        {
//            "wid": "29",
//            "weather": "浮尘"
//        },
//        {
//            "wid": "30",
//            "weather": "扬沙"
//        },
//        {
//            "wid": "31",
//            "weather": "强沙尘暴"
//        },
//        {
//            "wid": "53",
//            "weather": "霾"
//        }
//        ],
//        "error_code": 0
//    }


}
