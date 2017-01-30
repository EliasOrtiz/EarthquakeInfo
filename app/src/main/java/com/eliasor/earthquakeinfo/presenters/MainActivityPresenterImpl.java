package com.eliasor.earthquakeinfo.presenters;

import com.eliasor.earthquakeinfo.interactors.MainActivityInteractorImpl;
import com.eliasor.earthquakeinfo.interfaces.MainActivityInteractor;
import com.eliasor.earthquakeinfo.interfaces.MainActivityPresenter;
import com.eliasor.earthquakeinfo.interfaces.MainActivityView;
import com.eliasor.earthquakeinfo.model.Earthquake;
import com.eliasor.earthquakeinfo.model.EarthquakeResponse;
import com.eliasor.earthquakeinfo.model.MagnitudeColor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eliasor on 30/01/2017.
 */

public class MainActivityPresenterImpl implements MainActivityPresenter {
    private MainActivityView view;
    private MainActivityInteractor interactor;

    public MainActivityPresenterImpl(MainActivityView view) {
        this.view = view;
        interactor = new MainActivityInteractorImpl(this);
    }

    @Override
    public void loadRecentEarthquakes() {
        interactor.loadRecentEarthquakes();
    }

    @Override
    public void loadRecentOK(EarthquakeResponse earthquakeResponse) {

        List<Marker> markers = new ArrayList<>();
        for (Earthquake earthquake : earthquakeResponse.getEarthquakes()) {
            LatLng pos = new LatLng(Double.parseDouble(earthquake.getLat()), Double.parseDouble(earthquake.getLon()));
            Marker marker = view.getMapInstance().addMarker(
                    new MarkerOptions()
                            .position(pos)
                            .icon(BitmapDescriptorFactory.defaultMarker(MagnitudeColor.determineMagnitudeColor(Float.parseFloat(earthquake.getMagnitude()))))
                            .title(earthquake.getRegion())
                            .snippet(earthquake.getMagnitude()));


            markers.add(marker);
        }
    }

    @Override
    public void loadRecentError(String error) {
    }

    private int rgbToHue(int r, int g, int b) {
        return 0;
    }
}
