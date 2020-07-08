package com.interpol;

import java.util.Date;
import java.util.List;


public final class CriminalProfileBuilder {
    private  String name;
    private  String surname;
    private  Date dateOfBirth;
    private  String nationality;
    private final int criminalCode;
    private int creatorCode;
    private CriminalProfile.State profileState;
    private List<Integer> agentCodesInteractedSensitiveInformation;
    private CriminalRecord record;
    private SensitiveInformation sensitiveInformation;

    public CriminalProfileBuilder(int criminalCode) {
        this.criminalCode = criminalCode;
    }

    public static CriminalProfileBuilder newBuilder(int criminalCode) {
        return new CriminalProfileBuilder(criminalCode);
    }

    public CriminalProfile build() {
        return new CriminalProfile(name, surname, dateOfBirth, nationality, criminalCode, profileState, record, sensitiveInformation, creatorCode);
    }

    public CriminalProfileBuilder name(String name){
        this.name = name;
        return this;
    }

    public CriminalProfileBuilder surname(String surname){
        this.surname = surname;
        return this;
    }

    public CriminalProfileBuilder dateOfBirth(Date dateOfBirth){
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public CriminalProfileBuilder nationality(String nationality){
        this.nationality = nationality;
        return this;
    }

    public CriminalProfileBuilder profileState(CriminalProfile.State profileState){
        this.profileState = profileState;
        return this;
    }

    public CriminalProfileBuilder addAgentCodeInteractedSensitiveInformation(int agentCode){
        this.agentCodesInteractedSensitiveInformation.add(agentCode);
        return this;
    }

    public CriminalProfileBuilder record(CriminalRecord record){
        this.record = record;
        return this;
    }

    public CriminalProfileBuilder sensitiveInformation(SensitiveInformation sensitiveInformation){
        this.sensitiveInformation = sensitiveInformation;
        return this;
    }

    public CriminalProfileBuilder gps(String gps) {
        sensitiveInformation = sensitiveInformation == null ? new SensitiveInformation() : sensitiveInformation;
        sensitiveInformation.setGps(gps);
        return  this;
    }

    public CriminalProfileBuilder internetData(String data) {
        sensitiveInformation = sensitiveInformation == null ? new SensitiveInformation() : sensitiveInformation;
        sensitiveInformation.setInternetData(data);
        return  this;
    }

    public CriminalProfileBuilder setCreatorCode(int creatorCode) {
        this.creatorCode = creatorCode;
        return  this;
    }

    public CriminalProfileBuilder description(String description){
        record = record == null ? new CriminalRecord() : record;
        record.setDescription(description);
        return this;
    }

    public CriminalProfileBuilder copyCostructor(CriminalProfile profile){
        this.name = profile.getName();
        this.surname = profile.getSurname();
        this.dateOfBirth = profile.getDateOfBirth();
        this.nationality = profile.getNationality();
        this.profileState = profile.getState();
        this.record = profile.getRecord();
        this.agentCodesInteractedSensitiveInformation = profile.getAgentCodesInteractedSensitiveInformation();
        return this;
    }
}
