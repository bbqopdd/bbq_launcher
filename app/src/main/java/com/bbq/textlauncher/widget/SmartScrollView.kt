package com.bbq.textlauncher.widget

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.core.widget.NestedScrollView

/**
 * @ProjectName : textLauncher
 * @Author : bbq
 * @Time : 2021/10/27 15:13
 * @Description : 暂无描述
 */
class SmartScrollView : NestedScrollView {

    constructor(@NonNull context: Context) : super(context) {

    }

    constructor(@NonNull context: Context, @Nullable attrs: AttributeSet) : super(context, attrs) {

    }

    constructor(@NonNull context: Context, @Nullable attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {

    }

    private var isScrolledToTop: Boolean = true

    private var isScrolledToBottom: Boolean = true

    private var mSmartScrollChangedListener: ISmartScrollChangedListener? = null

    /** 定义监听接口  */
    interface ISmartScrollChangedListener {
        fun onScrolledToBottom()
        fun onScrolledToTop()
        fun onScrolledToOther()
    }

    override fun onOverScrolled(scrollX: Int, scrollY: Int, clampedX: Boolean, clampedY: Boolean) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY)

        if (scrollY == 0) {
            isScrolledToTop = clampedY;
            isScrolledToBottom = false
        } else {
            isScrolledToTop = false
            isScrolledToBottom = clampedY
        }
        notifyScrollChangedListeners()

    }

    private fun notifyScrollChangedListeners() {
        if (isScrolledToTop) {
            if (mSmartScrollChangedListener != null) {
                mSmartScrollChangedListener!!.onScrolledToTop()
            }
        } else if (isScrolledToBottom) {
            if (mSmartScrollChangedListener != null) {
                mSmartScrollChangedListener!!.onScrolledToBottom()
            }
        }else{
            if (mSmartScrollChangedListener != null) {
                mSmartScrollChangedListener!!.onScrolledToOther()
            }
        }
    }

    fun setMSmartScrollChangedListener(mSmartScrollChangedListener: ISmartScrollChangedListener?) {
        this.mSmartScrollChangedListener = mSmartScrollChangedListener
    }

    fun isScrolledToTop(): Boolean {
        return isScrolledToTop
    }

    fun isScrolledToBottom(): Boolean {
        return isScrolledToBottom
    }


}