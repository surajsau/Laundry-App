package com.halfplatepoha.laundry.ui

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatTextView
import com.halfplatepoha.laundry.R

class TextView : AppCompatTextView {

    constructor(context: Context?) : super(context, null, 0) {
        initAttrs(context!!, null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initAttrs(context!!, attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initAttrs(context!!, attrs)
    }

    fun initAttrs(context: Context, attrs: AttributeSet?) {
        if(attrs != null) {
            val typedArray: TypedArray? = context.obtainStyledAttributes(attrs, R.styleable.CustomView)

            var drawableLeft: Drawable? = null
            var drawableRight: Drawable? = null
            var drawableTop: Drawable? = null
            var drawableBottom: Drawable? = null

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                drawableLeft = typedArray?.getDrawable(R.styleable.CustomView_drawableLeftCompat)
                drawableRight = typedArray?.getDrawable(R.styleable.CustomView_drawableRightCompat)
                drawableTop = typedArray?.getDrawable(R.styleable.CustomView_drawableTopCompat)
                drawableBottom = typedArray?.getDrawable(R.styleable.CustomView_drawableBottomCompat)
            } else {
                val drawableLeftId = typedArray?.getResourceId(R.styleable.CustomView_drawableLeftCompat, -1)
                val drawableRightId = typedArray?.getResourceId(R.styleable.CustomView_drawableRightCompat, -1)
                val drawableTopId = typedArray?.getResourceId(R.styleable.CustomView_drawableTopCompat, -1)
                val drawableBottomId = typedArray?.getResourceId(R.styleable.CustomView_drawableBottomCompat, -1)

                if(drawableLeftId != -1)
                    drawableLeft = AppCompatResources.getDrawable(context, drawableLeftId!!)
                if(drawableLeftId != -1)
                    drawableRight = AppCompatResources.getDrawable(context, drawableRightId!!)
                if(drawableLeftId != -1)
                    drawableTop = AppCompatResources.getDrawable(context, drawableTopId!!)
                if(drawableLeftId != -1)
                    drawableBottom = AppCompatResources.getDrawable(context, drawableBottomId!!)
            }

            setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom)

            typedArray?.recycle()
        }
    }

}