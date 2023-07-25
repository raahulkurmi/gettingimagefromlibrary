package com.airbnb.lottie;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class LottieAnimationView extends View {
    public LottieAnimationView(Context context) {
        this(context, null);
    }

    public LottieAnimationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LottieAnimationView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setAnimation(int lottie) {
    }

    public void playAnimation() {
    }
}
