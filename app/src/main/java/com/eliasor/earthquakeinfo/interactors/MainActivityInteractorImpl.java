package com.eliasor.earthquakeinfo.interactors;

import com.eliasor.earthquakeinfo.interfaces.MainActivityInteractor;
import com.eliasor.earthquakeinfo.interfaces.MainActivityPresenter;
import com.eliasor.earthquakeinfo.model.EarthquakeResponse;
import com.eliasor.earthquakeinfo.network.APIService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.eliasor.earthquakeinfo.BuildConfig.API_URL;

/**
 * Created by eliasor on 30/01/2017.
 */

public class MainActivityInteractorImpl implements MainActivityInteractor {
    private MainActivityPresenter presenter;
    private Retrofit retrofit;
    private APIService apiService;

    public MainActivityInteractorImpl(MainActivityPresenter presenter) {
        this.presenter = presenter;
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API_URL)
                .build();
        apiService = retrofit.create(APIService.class);
    }

    @Override
    public void loadRecentEarthquakes() {
        Map<String, String> params = new HashMap<>();

        final Observable<EarthquakeResponse> recentEarthquakes = apiService.getRecentEarthquakes(params);

        recentEarthquakes.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<EarthquakeResponse>() {
                    EarthquakeResponse earthquakes;

                    @Override
                    public void onCompleted() {
                        presenter.loadRecentOK(earthquakes);
                    }

                    @Override
                    public void onError(Throwable e) {
                        presenter.loadRecentError("Not possible to load earthquakes");
                    }

                    @Override
                    public void onNext(EarthquakeResponse earthquakeResponse) {
                        earthquakes = earthquakeResponse;
                    }
                });
    }
}
