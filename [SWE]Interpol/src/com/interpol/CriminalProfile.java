package com.interpol;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




public class CriminalProfile {
    public enum State{
        RELEASED,
        WANTED,
        CONVICT,
        ESCAPEE
    }
    private final String name;
    private final String surname;
    private final Date dateOfBirth;
    private final String nationality;
    private final int criminalCode;
    private State state;
    private CriminalRecord record;
    private SensitiveInformation sensitiveInformation;
    private int creatorCode;
    private List<Integer> agentCodesInteractedSensitiveInformation;

    public CriminalProfile(String name, String surname, Date dateOfBirth, String nationality, int criminalCode, State state, CriminalRecord record, SensitiveInformation sensitiveInformation, int creatorCode) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.criminalCode = criminalCode;
        this.state = state;
        this.record = record;
        this.sensitiveInformation = sensitiveInformation;
        this.agentCodesInteractedSensitiveInformation = new ArrayList<>();
        this.creatorCode = creatorCode;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public int getCreatorCode() {
        return creatorCode;
    }

    public List<Integer> getAgentCodesInteractedSensitiveInformation() {
        return agentCodesInteractedSensitiveInformation;
    }

    public void getIdentity(){
        JOptionPane.showMessageDialog (null, name +" "+ surname +" \n"+ nationality +" \n"+ dateOfBirth +"\n"+ state);
    }

    public int getCriminalCode() {
        return criminalCode;
    }

    public State getState() {
        return state;
    }

    public CriminalRecord getRecord() {
        return record;
    }

    public void showAgentCodesInteracted(){
        for(Integer iterator: agentCodesInteractedSensitiveInformation)
            System.out.println(iterator);
    }

    public SensitiveInformation getSensitiveInformation() {
        return sensitiveInformation;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setRecord(CriminalRecord record) {
        this.record = record;
    }

    public void setSensitiveInformation(SensitiveInformation sensitiveInformation) {
        this.sensitiveInformation = sensitiveInformation;
    }

    public void setCreatorCode(int creatorCode) {
        this.creatorCode = creatorCode;
    }

    public void setAgentCodesInteractedSensitiveInformation(List<Integer> agentCodesInteractedSensitiveInformation) {
        this.agentCodesInteractedSensitiveInformation = agentCodesInteractedSensitiveInformation;
    }
}
