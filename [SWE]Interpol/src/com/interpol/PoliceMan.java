package com.interpol;

public class PoliceMan {
    public static final int SERGEANT_LEVEL = 5;
    protected final String name;
    protected final String surname;
    protected int policeID;
    protected int agentLevel;

    public PoliceMan(String name, String surname, int policeID) {
        this.name = name;
        this.surname = surname;
        this.policeID = policeID;
    }


    public  int getAgentLevel(){ return agentLevel;}

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPoliceID() {
        return policeID;
    }

    public void setAgentLevel(int agentLevel){
        this.agentLevel = agentLevel;
    }

    }



