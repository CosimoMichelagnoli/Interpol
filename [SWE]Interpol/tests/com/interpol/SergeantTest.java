package com.interpol;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SergeantTest {
    PoliceMan agent;

    @BeforeEach
    void setUp(){
        agent = new Sergeant("Mario","Rossi",22);
    }

    @Test
    void getAgentLevel() {
        assertEquals(agent.getAgentLevel(), 5);
    }

    @Test
    void getPoliceID() {
        assertEquals(agent.getPoliceID(), 22);
    }

    @Test
    void setAgentLevel(){
        agent.setAgentLevel(4);
        assertNotEquals(agent.getAgentLevel(), 5);
    }

}