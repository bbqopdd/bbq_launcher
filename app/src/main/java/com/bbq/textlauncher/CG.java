package com.bbq.textlauncher;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.bbq.textlauncher.activity.BaseActivity;

import org.jetbrains.annotations.Nullable;

/**
 * @ProjectName : textLauncher
 * @Author : bbq
 * @Time : 2021/10/27 17:52
 * @Description : 暂无描述
 */
public class CG extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bjk bjk = new Bjk();
        bjk.setOnWifiChangeListener(onWifiChangeListener);

    }

    private OnWifiChangeListener onWifiChangeListener = new OnWifiChangeListener() {
        @Override
        public void onWifiChanged() {

        }

        @Override
        public void onWifiClose() {

        }
    };



}