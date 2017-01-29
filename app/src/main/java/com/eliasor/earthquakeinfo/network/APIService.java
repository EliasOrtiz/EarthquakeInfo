package com.eliasor.earthquakeinfo.network;

import com.eliasor.earthquakeinfo.model.EarthquakeResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by eliasor on 30/01/2017.
 */

//API SERVICE : http://www.seismi.org/api/


public interface APIService {

    @GET("eqs")
    Call<EarthquakeResponse> getRecentEarthquakes(@QueryMap Map<String, String> options);

    @GET("eqs/{year}")
    Call<EarthquakeResponse> getEarthquakesOnYear(
            @Path("year") String year,
            @QueryMap Map<String, String> options);

    @GET("eqs/{year}/{month}")
    Call<EarthquakeResponse> getEarthquakesOnYearAndMonth(
            @Path("year") String year,
            @Path("month") String month,
            @QueryMap Map<String, String> options);

    //TODO: Review how to manage it
    /*@GET("totals")
    Call<EarthquakeResponse> getTotalEarthquakes();*/

}
