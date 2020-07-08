package com.interpol;

import java.io.Serializable;

public class SensitiveInformation {
    private String gps;
    private String internetData;

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getInternetData() {
        return internetData;
    }

    public void setInternetData(String internetData) {
        this.internetData = internetData;
    }
}
