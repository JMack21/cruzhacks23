package com.pascalcase.silvertrails.gamertools.maptools;

import android.view.View;

public class MapMarker
{
    public final View view;
    public float offsetX;
    public float offsetY;

    public MapMarker(View view, float offsetX, float offsetY)
    {
        this.view = view;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }
}
