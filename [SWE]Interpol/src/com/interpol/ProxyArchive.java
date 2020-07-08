package com.interpol;

import javax.swing.*;

public class ProxyArchive implements Archive {
    private int agentLevel;
    private static final ProxyArchive instance;

    static {
        instance = new ProxyArchive();
    }

    public static ProxyArchive getInstance() {
        return instance;
    }

    @Override
    public SensitiveInformation getSensitiveInformation(PoliceMan agent, int criminalCode) {
        this.agentLevel = agent.getAgentLevel();
        if(checkAgentLevel())
            return RealArchive.getInstance().getSensitiveInformation(agent, criminalCode);
        else JOptionPane.showMessageDialog (null, "YOU ARE NOT ALLOW..");
        return null;
    }

    @Override
    public void getProfileCreator(PoliceMan agent, int criminalCode) {
        this.agentLevel = agent.getAgentLevel();
        if(checkAgentLevel())
            RealArchive.getInstance().getProfileCreator(agent, criminalCode);
        else JOptionPane.showMessageDialog (null, "YOU ARE NOT ALLOW..");

    }

    @Override
    public void setSensitiveInformation(PoliceMan agent, int criminalCode, String gps, String internetData) {
        this.agentLevel = agent.getAgentLevel();
        if(checkAgentLevel())
            RealArchive.getInstance().setSensitiveInformation(agent, criminalCode, gps, internetData);
        else JOptionPane.showMessageDialog (null, "YOU ARE NOT ALLOW..");
    }

    private boolean checkAgentLevel(){
        return IdentifyLevel.checkAgentLevel(agentLevel);
    }
}
