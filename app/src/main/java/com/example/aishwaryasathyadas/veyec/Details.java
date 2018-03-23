package com.example.aishwaryasathyadas.veyec;

/**
 * Created by aishwaryasathyadas on 11/03/2018.
 */

public class Details {


    private String date;
    private String phone;
    private String videourl;
    private String location;
    private double longitude;
    private double latitude;

    public Details() {
        // This is default constructor.
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }


    public String getVideourl() {

        return videourl;
    }

    public void setVideourl(String videourl) {

        this.videourl = videourl;
    }


    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {

        this.location = location;
    }

    public double getLongitude() {

        return longitude;
    }

    public void setLongitude(double longitude) {

        this.longitude = longitude;
    }

    public double getLatitude() {

        return latitude;
    }

    public void setLatitude(double latitude) {

        this.latitude = latitude;
    }
}
