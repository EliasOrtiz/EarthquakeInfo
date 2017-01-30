package com.eliasor.earthquakeinfo.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);

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
}
