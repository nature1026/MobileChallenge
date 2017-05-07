package com.kayshin.paytmlabs.view.widget;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

/**
 * Created by Kay on 2017-05-06.
 */

public class SqaureCardView extends CardView {
    public SqaureCardView(Context context) {
        super(context);
    }

    public SqaureCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SqaureCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
