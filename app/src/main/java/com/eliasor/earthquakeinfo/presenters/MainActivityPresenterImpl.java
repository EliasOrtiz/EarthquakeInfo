package com.eliasor.earthquakeinfo.presenters;

import com.eliasor.earthquakeinfo.interactors.MainActivityInteractorImpl;
import com.eliasor.earthquakeinfo.interfaces.MainActivityInteractor;
import com.eliasor.earthquakeinfo.interfaces.MainActivityPresenter;
import com.eliasor.earthquakeinfo.interfaces.MainActivityView;
import com.eliasor.earthquakeinfo.model.Earthquake;
import com.eliasor.earthquakeinfo.model.EarthquakeMarker;
import com.eliasor.earthquakeinfo.model.EarthquakeResponse;
import com.eliasor.earthquakeinfo.model.MagnitudeColor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.floor;
import static java.lang.Math.round;

/**
 * Created by eliasor on 30/01/2017.
 */

public class MainActivityPresenterImpl implements MainActivityPresenter {
    private MainActivityView view;
    private MainActivityInteractor interactor;
    List<EarthquakeMarker> markersOnMap;

    public MainActivityPresenterImpl(MainActivityView view) {
        this.view = view;
        markersOnMap = new ArrayList<>();
        interactor = new MainActivityInteractorImpl(this);
    }

    @Override
    public void loadRecentEarthquakes() {
        interactor.loadRecentEarthquakes();
    }

    @Override
    public void loadRecentOK(EarthquakeResponse earthquakeResponse) {

        for (Earthquake earthquake : earthquakeResponse.getEarthquakes()) {
            LatLng pos = new LatLng(Double.parseDouble(earthquake.getLat()), Double.parseDouble(earthquake.getLon()));
            Marker marker = view.getMapInstance().addMarker(
                    new MarkerOptions()
                            .position(pos)
                            .icon(BitmapDescriptorFactory.defaultMarker(MagnitudeColor.determineMagnitudeColor(Float.parseFloat(earthquake.getMagnitude()))))
                            .title(earthquake.getRegion())
                            .snippet(earthquake.getMagnitude()));
            markersOnMap.add(new EarthquakeMarker(earthquake, marker));
        }
    }

    @Override
    public void filterMarkersByMagnitude(int magnitude) {
        if (magnitude == -1) { //show all
            for (EarthquakeMarker earthquakeMarker : markersOnMap) {
                earthquakeMarker.getMarker().setVisible(true);
            }
        } else { //show selected magnitude
            for (EarthquakeMarker earthquakeMarker : markersOnMap) {

                if (round(floor(earthquakeMarker.getMagnitude())) != magnitude) {
                    earthquakeMarker.getMarker().setVisible(false);
                } else {
                    earthquakeMarker.getMarker().setVisible(true);
                }
            }
        }
    }

    @Override
    public void loadRecentError(String error) {
    }

}
