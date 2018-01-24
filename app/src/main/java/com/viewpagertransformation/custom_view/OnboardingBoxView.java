package com.viewpagertransformation.custom_view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.viewpagertransformation.R;

import java.util.ArrayList;
import java.util.List;


public class OnboardingBoxView extends RelativeLayout {
    private static final int[] views = new int[]{R.id.ivOnboardingAtomVideo, R.id.ivOnboardingAtomQuote, R.id.ivOnboardingAtomMap, R.id.ivOnboardingAtomInfographic, R.id.ivOnboardingAtomStockchart, R.id.ivOnboardingAtomWikipedia, R.id.ivOnboardingAtomSound};
    private static final int view_length = views.length;
    private static final int[] view_pos = new int[]{R.dimen.onboarding_x_scroll_offset_atom_video, R.dimen.onboarding_x_scroll_offset_atom_quote, R.dimen.onboarding_x_scroll_offset_atom_map, R.dimen.onboarding_x_scroll_offset_atom_infographic, R.dimen.onboarding_x_scroll_offset_atom_stockchart, R.dimen.onboarding_x_scroll_offset_atom_wikipedia, R.dimen.onboarding_x_scroll_offset_atom_sound};
    private final int[] view_pixelsize;
    private final float[] view_x;
    private List<ImageView> imageViewList;

    public OnboardingBoxView(Context context) {
        super(context);
        this.view_pixelsize = new int[view_length];
        this.view_x = new float[view_length];
        this.imageViewList = new ArrayList();

        setView(context);
    }

    public OnboardingBoxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.view_pixelsize = new int[view_length];
        this.view_x = new float[view_length];
        this.imageViewList = new ArrayList();

        setView(context);
    }

    private void setView(Context context) {
        inflate(context, R.layout.onboarding_box_view, this);
        setLayoutParams(new LayoutParams(-1, -1));
        Resources resources = getResources();
        for (int i = 0; i < view_length; i++) {
            this.view_pixelsize[i] = resources.getDimensionPixelSize(view_pos[i]);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        for (int findViewById : views) {
            ImageView imageView = (ImageView) findViewById(findViewById);
            imageView.setAlpha(0.0f);
            this.imageViewList.add(imageView);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        for (int i5 = 0; i5 < view_length; i5++) {
            this.view_x[i5] = ((ImageView) this.imageViewList.get(i5)).getX();
        }
    }


}
