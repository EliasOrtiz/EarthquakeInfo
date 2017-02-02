package com.eliasor.earthquakeinfo.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.eliasor.earthquakeinfo.R;
import com.eliasor.earthquakeinfo.interfaces.MainActivityPresenter;
import com.eliasor.earthquakeinfo.interfaces.MainActivityView;
import com.eliasor.earthquakeinfo.presenters.MainActivityPresenterImpl;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity implements MainActivityView, OnMapReadyCallback {
    private FirebaseAnalytics mFirebaseAnalytics;
    private GoogleMap mMap;
    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        presenter = new MainActivityPresenterImpl(this);

        loadRecentEarthquakes();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    @Override
    public void loadRecentEarthquakes() {
        presenter.loadRecentEarthquakes();
    }

    @Override
    public GoogleMap getMapInstance() {
        return mMap;
    }

    public void filterMagnitude(View view) {
        int id = view.getId();
        int magnitude = -1;
        switch (id) {
            case R.id.magnitude1:
                magnitude = 1;
                break;
            case R.id.magnitude2:
                magnitude = 2;
                break;
            case R.id.magnitude3:
                magnitude = 3;
                break;
            case R.id.magnitude4:
                magnitude = 4;
                break;
            case R.id.magnitude5:
                magnitude = 5;
                break;
            case R.id.magnitude6:
                magnitude = 6;
                break;
            case R.id.magnitude7:
                magnitude = 7;
                break;
            case R.id.magnitude8:
                magnitude = 8;
                break;
            case R.id.magnitude9:
                magnitude = 9;
                break;
            case R.id.magnitudeMore:
                magnitude = 10;
                break;
            default:
                magnitude = -1;
                break;
        }
        presenter.filterMarkersByMagnitude(magnitude);
    }
}
