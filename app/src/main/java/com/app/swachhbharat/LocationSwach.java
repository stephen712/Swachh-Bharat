package com.app.swachhbharat;

public class LocationSwach {

    private double longitude;
    private double lattitude;

    public LocationSwach(double longitude, double lattitude) {
        this.longitude = longitude;
        this.lattitude = lattitude;
    }

    public LocationSwach() {
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }
}
