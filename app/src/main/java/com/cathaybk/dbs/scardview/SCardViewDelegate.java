package com.cathaybk.dbs.scardview;

import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by Hongren 2021/5/18.
 * */
public interface SCardViewDelegate {
    void setCardBackground(Drawable drawable);

    Drawable getCardBackground();

    boolean getUseCompatPadding();

    boolean getPreventCornerOverlap();

    void setShadowPadding(int left, int top, int right, int bottom);

    void setMinWidthHeightInternal(int width, int height);

    View getCardView();
}
