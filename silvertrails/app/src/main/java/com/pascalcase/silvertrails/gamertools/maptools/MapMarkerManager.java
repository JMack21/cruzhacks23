package com.pascalcase.silvertrails.gamertools.maptools;

import java.util.ArrayList;
import java.util.Map;

public class MapMarkerManager
{
    private ArrayList<MapMarker> markers;

    public MapMarkerManager()
    {
        this.markers = new ArrayList<>();
    }

    public void addMarker(MapMarker marker)
    {
        markers.add(marker);
    }

    public void updateMarkerPositions(float x, float y)
    {
        for (MapMarker marker : markers)
        {
            marker.view.setX(x);
            marker.view.setY(y);
        }
    }
}
