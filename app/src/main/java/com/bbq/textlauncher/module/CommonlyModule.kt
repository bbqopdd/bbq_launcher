package com.bbq.textlauncher.module

import android.content.Intent
import android.provider.MediaStore
import com.bbq.textlauncher.R

/**
 * @ProjectName : textLauncher
 * @Author : bbq
 * @Time : 2021/11/19 10:00
 * @Description : 基础常用模块的预制配置
 */
enum class CommonlyModule(name: String, var icon: Int, var enableState: Boolean, var toIntent: Intent?) {

    PHONE("拨号", R.drawable.ic_dianhuajianpan, true,
            Intent(Intent.ACTION_CALL_BUTTON)),
    MESSAGE("短信", R.drawable.ic_duanxin, true,
            Intent(Intent.ACTION_MAIN).setClassName("com.android.mms",
                    "com.android.mms.ui.ConversationList")),
    ADDRESS_BOOK("通讯录", R.drawable.ic_lianxiren, true,
            Intent().setAction(Intent.ACTION_GET_CONTENT).setType("vnd.android.cursor.item/phone")),
    CALCULATOR("计算器", R.drawable.ic_jisuanqi, false, null),
    CAMERA("相机", R.drawable.ic_camera, true, Intent().setAction(MediaStore.ACTION_IMAGE_CAPTURE))

}