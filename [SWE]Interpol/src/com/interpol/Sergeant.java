package com.interpol;

public class Sergeant extends PoliceMan {

    public Sergeant(String name, String surname, int policeID) {
        super(name, surname, policeID);
        this.agentLevel = 5;
    }

    public Sergeant(PoliceMan agent){
        this(agent.getName(),agent.getSurname(),agent.getAgentLevel());
    }

    public  int getAgentLevel(){ return agentLevel;}

    public int getPoliceID() {
        return this.policeID;
    }

    public PoliceMan promote(PoliceMan agent) {
        int agentLevel = agent.getAgentLevel() + 1;
        agent.setAgentLevel(agentLevel);
        return agentLevel == PoliceMan.SERGEANT_LEVEL ? new Sergeant(agent) : agent;
    }
}
