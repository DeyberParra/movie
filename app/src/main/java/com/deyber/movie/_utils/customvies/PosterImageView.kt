package com.deyber.movie._utils.customvies


import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.deyber.movie.R


class PosterImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatImageView(context, attrs) {

    private var posterRatio:Float = 1.5f
    private var posterWith:Int = measuredWidth
    private var posterHeigth:Int= measuredHeight

    init {
        val atributes = context.obtainStyledAttributes(attrs, R.styleable.PosterImageView)
        posterRatio = atributes.getFloat(R.styleable.PosterImageView_ratio, 1.5f)
        atributes.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if(posterHeigth == 0 && posterWith == 0){
            return
        }

        if(posterWith > 0){
            posterHeigth = (posterWith * posterRatio).toInt()
        }else if(posterHeigth > 0){
            posterWith = (posterHeigth/posterRatio).toInt()
        }
        setMeasuredDimension(posterWith, posterHeigth)

    }


}