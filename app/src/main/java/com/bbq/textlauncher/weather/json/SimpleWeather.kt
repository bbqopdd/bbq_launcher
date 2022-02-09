package com.bbq.textlauncher.weather.json

import android.util.Log
import com.alibaba.fastjson.JSONObject
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.util.*

/**
 * @ProjectName : textLauncher
 * @Author : bbq
 * @Time : 2021/10/30 18:02
 * @Description : 天气查询类，接口来自聚合api免费版
 */
object SimpleWeather {

    // 天气情况查询接口地址
    private const val API_URL = "http://apis.juhe.cn/simpleWeather/query"

    // 接口请求Key
    private const val API_KEY = "3024285086597db75d7d37cfdc187d18"

    /**
     * 根据城市名查询天气情况
     *
     * @param cityName
     */
    fun queryWeather(cityName: String, onWeatherInfoListener: OnWeatherInfoListener) {
        Thread {
            var mJson: JsonWeatherInfo? = null

            val params: MutableMap<String, Any> = HashMap() //组合参数
            params["city"] = cityName
            params["key"] = API_KEY
            val queryParams = urlToCode(params)

            val response = doGet(API_URL, queryParams)
            try {

                val jsonObject = JSONObject.parseObject(response)
                val error_code = jsonObject.getInteger("error_code")

                if (error_code == 0) {
                    Log.e("=======", "" + "调用接口成功：")

                    mJson = JSONObject.parseObject(response, JsonWeatherInfo::class.java)

                    Log.e("=======", "城市：" + JsonWeatherResult.city)
                    Log.e("=======", "天气：" + JsonWeatherRealtime.info)
                    Log.e("=======", "空气质量：" + JsonWeatherRealtime.aqi)
                    Log.e("=======", "风向：" + JsonWeatherRealtime.direct)
                    Log.e("=======", "湿度：" + JsonWeatherRealtime.humidity)
                    Log.e("=======", "风力：" + JsonWeatherRealtime.power)
                    Log.e("=======", "温度：" + JsonWeatherRealtime.temperature)
                    Log.e("=======", "" + JsonWeatherRealtime.wid)

                    onWeatherInfoListener.onWeatherInfo(mJson)

                } else {
                    Log.e("=======", "" + "调用接口失败：" + jsonObject.getString("reason"))
                }

            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("=======", "" + "调用接口异常：" + e.message)
                onWeatherInfoListener.onWeatherInfo(mJson)
            }

        }.start()

        onWeatherInfoListener.onWeatherInfo(null)

    }

    /**
     * get方式的http请求
     *
     * @param httpUrl 请求地址
     * @return 返回结果
     */
    private fun doGet(httpUrl: String?, queryParams: String?): String? {
        var connection: HttpURLConnection? = null
        var inputStream: InputStream? = null
        var bufferedReader: BufferedReader? = null
        var result: String? = null // 返回结果字符串
        try {

            // 创建远程url连接对象
            val url = URL(StringBuffer(httpUrl!!).append("?").append(queryParams).toString())
            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = url.openConnection() as HttpURLConnection
            // 设置连接方式：get
            connection.requestMethod = "GET"
            // 设置连接主机服务器的超时时间：15000毫秒
            connection.connectTimeout = 5000
            // 设置读取远程返回的数据时间：60000毫秒
            connection.readTimeout = 6000
            // 发送请求
            connection.connect()
            // 通过connection连接，获取输入流
            if (connection.responseCode == 200) {
                inputStream = connection.inputStream
                // 封装输入流，并指定字符集
                bufferedReader = BufferedReader(InputStreamReader(inputStream, StandardCharsets.UTF_8))
                // 存放数据
                val sbf = StringBuilder()
                var temp: String?
                while (bufferedReader.readLine().also { temp = it } != null) {
                    sbf.append(temp)
                    sbf.append(System.getProperty("line.separator"))
                }
                result = sbf.toString()
            }

        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            // 关闭资源
            if (null != bufferedReader) {
                try {
                    bufferedReader.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            if (null != inputStream) {
                try {
                    inputStream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            connection?.disconnect()
        }
        return result
    }

    /**
     * 将map型转为请求参数型
     *
     * @param data
     * @return
     */
    private fun urlToCode(data: Map<String, *>): String {
        val sb = StringBuilder()
        for ((key, value) in data) {
            try {
                sb.append(key).append("=").append(URLEncoder.encode(value.toString() + "", "UTF-8")).append("&")
            } catch (e: UnsupportedEncodingException) {
                e.printStackTrace()
            }
        }
        var result = sb.toString()
        result = result.substring(0, result.lastIndexOf("&"))
        return result
    }

}