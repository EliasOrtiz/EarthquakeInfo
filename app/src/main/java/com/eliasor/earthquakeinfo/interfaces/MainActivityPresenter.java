package com.eliasor.earthquakeinfo.interfaces;

import com.eliasor.earthquakeinfo.model.EarthquakeResponse;

/**
 * Created by eliasor on 30/01/2017.
 */

public interface MainActivityPresenter {

    void loadRecentEarthquakes();

    void loadRecentOK(EarthquakeResponse earthquakeResponse);

    void loadRecentError(String error);

    void filterMarkersByMagnitude(int magnitude);
}
