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

    public void updateMarkerPositions(float transX, float transY, float scaleX, float scaleY)
    {
        for (MapMarker marker : markers)
        {
            marker.view.setX(transX + marker.offsetX * scaleX);
            marker.view.setY(transY + marker.offsetY * scaleY);
        }
    }
}
