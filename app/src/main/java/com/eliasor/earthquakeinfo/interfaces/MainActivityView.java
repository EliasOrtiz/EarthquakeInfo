package com.eliasor.earthquakeinfo.interfaces;

import com.google.android.gms.maps.GoogleMap;

/**
 * Created by eliasor on 30/01/2017.
 */

public interface MainActivityView {
    void loadRecentEarthquakes();
    GoogleMap getMapInstance();
}
