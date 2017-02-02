package com.eliasor.earthquakeinfo.model;

import com.google.android.gms.maps.model.Marker;

/**
 * Created by eliasor on 31/01/2017.
 */

public class EarthquakeMarker {
    private Earthquake earthquake;
    private Marker marker;

    public EarthquakeMarker(Earthquake earthquake, Marker marker) {
        this.earthquake = earthquake;
        this.marker = marker;
    }

    public Marker getMarker() {
        return this.marker;
    }

    public float getMagnitude() {
        return Float.parseFloat(this.earthquake.getMagnitude());
    }
}
