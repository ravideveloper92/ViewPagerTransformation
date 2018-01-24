package com.viewpagertransformation.custom_view;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.viewpagertransformation.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class OnboardingBoxView extends RelativeLayout {
    private static final int[] f8582a = new int[]{R.id.ivOnboardingAtomVideo, R.id.ivOnboardingAtomQuote, R.id.ivOnboardingAtomMap, R.id.ivOnboardingAtomInfographic, R.id.ivOnboardingAtomStockchart, R.id.ivOnboardingAtomWikipedia, R.id.ivOnboardingAtomSound};
    private static final int f8583b = f8582a.length;
    private static final int[] f8584c = new int[]{R.dimen.onboarding_x_scroll_offset_atom_video, R.dimen.onboarding_x_scroll_offset_atom_quote, R.dimen.onboarding_x_scroll_offset_atom_map, R.dimen.onboarding_x_scroll_offset_atom_infographic, R.dimen.onboarding_x_scroll_offset_atom_stockchart, R.dimen.onboarding_x_scroll_offset_atom_wikipedia, R.dimen.onboarding_x_scroll_offset_atom_sound};
    private static final long[] f8585d = new long[]{0, 1100, 900, 700, 300, 500, 0};
    private static final long[] f8586e = new long[]{700, 700, 700, 700, 700, 700, 700};
    private final int[] f8587f;
    private final float[] f8588g;
    private Context f8589h;
    private List<ImageView> f8590i;
    private AnimatorSet f8591j;
    private boolean f8592k;

    public OnboardingBoxView(Context context) {
        super(context);
        this.f8587f = new int[f8583b];
        this.f8588g = new float[f8583b];
        this.f8590i = new ArrayList();
        this.f8592k = false;
        m13468a(context);
    }

    public OnboardingBoxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8587f = new int[f8583b];
        this.f8588g = new float[f8583b];
        this.f8590i = new ArrayList();
        this.f8592k = false;
        m13468a(context);
    }

    private void m13468a(Context context) {
        this.f8589h = context;
        inflate(context, R.layout.onboarding_box_view, this);
        setLayoutParams(new LayoutParams(-1, -1));
        Resources resources = getResources();
        for (int i = 0; i < f8583b; i++) {
            this.f8587f[i] = resources.getDimensionPixelSize(f8584c[i]);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        for (int findViewById : f8582a) {
            ImageView imageView = (ImageView) findViewById(findViewById);
            imageView.setAlpha(0.0f);
            this.f8590i.add(imageView);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        for (int i5 = 0; i5 < f8583b; i5++) {
            this.f8588g[i5] = ((ImageView) this.f8590i.get(i5)).getX();
        }
        this.f8592k = true;
    }

    public void setProgress(float f) {
        if (this.f8592k) {
            for (int i = 0; i < f8583b; i++) {
                ((ImageView) this.f8590i.get(i)).setX((((float) this.f8587f[i]) * f) + this.f8588g[i]);
            }
        }
    }

    public void m13469a() {
        this.f8591j = new AnimatorSet();
        Collection arrayList = new ArrayList();
        for (int i = 0; i < f8583b; i++) {
            @SuppressLint("ResourceType") Animator loadAnimator = AnimatorInflater.loadAnimator(this.f8589h, 17498112);
            loadAnimator.setTarget(this.f8590i.get(i));
            loadAnimator.setStartDelay(f8585d[i]);
            loadAnimator.setDuration(f8586e[i]);
            arrayList.add(loadAnimator);
        }
        this.f8591j.playTogether(arrayList);
        this.f8591j.start();
    }

    public void m13470b() {
        if (this.f8591j != null) {
            this.f8591j.cancel();
            this.f8591j = null;
        }
        for (int i = 0; i < f8583b; i++) {
            ((ImageView) this.f8590i.get(i)).setAlpha(0.0f);
        }
    }

    public void m13471c() {
        //j.a(this.f8590i);
    }
}
