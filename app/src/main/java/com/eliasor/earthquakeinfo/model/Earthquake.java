package com.eliasor.earthquakeinfo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by eliasor on 30/01/2017.
 */
/* class created with http://www.jsonschema2pojo.org/ */
public class Earthquake {

    @SerializedName("src")
    @Expose
    private String src;
    @SerializedName("eqid")
    @Expose
    private String eqid;
    @SerializedName("timedate")
    @Expose
    private String timedate;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lon")
    @Expose
    private String lon;
    @SerializedName("magnitude")
    @Expose
    private String magnitude;
    @SerializedName("depth")
    @Expose
    private String depth;
    @SerializedName("region")
    @Expose
    private String region;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getEqid() {
        return eqid;
    }

    public void setEqid(String eqid) {
        this.eqid = eqid;
    }

    public String getTimedate() {
        return timedate;
    }

    public void setTimedate(String timedate) {
        this.timedate = timedate;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "src='" + src + '\'' +
                ", eqid='" + eqid + '\'' +
                ", timedate='" + timedate + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", magnitude='" + magnitude + '\'' +
                ", depth='" + depth + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}