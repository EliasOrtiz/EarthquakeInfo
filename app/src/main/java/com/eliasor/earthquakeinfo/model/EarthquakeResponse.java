package com.eliasor.earthquakeinfo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by eliasor on 30/01/2017.
 */
/* class created with http://www.jsonschema2pojo.org/ */

public class EarthquakeResponse {

    @SerializedName("count")
    @Expose
    private String count;
    @SerializedName("earthquakes")
    @Expose
    private List<Earthquake> earthquakes = null;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<Earthquake> getEarthquakes() {
        return earthquakes;
    }

    public void setEarthquakes(List<Earthquake> earthquakes) {
        this.earthquakes = earthquakes;
    }

    @Override
    public String toString() {
        return "EarthquakeResponse{" +
                "count='" + count + '\'' +
                ", earthquakes=" + earthquakes +
                '}';
    }
}
