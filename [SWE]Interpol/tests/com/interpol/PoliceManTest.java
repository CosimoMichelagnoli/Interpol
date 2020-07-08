package com.interpol;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PoliceManTest {
    PoliceMan agent;

    @BeforeEach
    void setUp(){
        agent = new PoliceMan("Mario", "Rossi", 89);
    }

    @Test
    void getAgentLevel() {
        assertEquals(agent.getAgentLevel(), 0);
    }

    @Test
    void getName() {
        assertEquals(agent.getName(),"Mario");
    }

    @Test
    void getSurname() {
        assertEquals(agent.getSurname(), "Rossi");
    }

    @Test
    void getPoliceID() {
        assertEquals(agent.getPoliceID(), 89);
    }

    @Test
    void setAgentLevel() {
        agent.setAgentLevel(25);
        assertNotEquals(agent.getAgentLevel(), 89);
    }
}