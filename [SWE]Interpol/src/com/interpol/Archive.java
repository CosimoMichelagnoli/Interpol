package com.interpol;

public interface Archive{
    public void setSensitiveInformation(PoliceMan agent, int criminalCode, String gps, String internetData);
    public SensitiveInformation getSensitiveInformation(PoliceMan agent, int criminalCode);
    public void getProfileCreator(PoliceMan agent,int criminalCode);
}