package com.interpol;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;

class CriminalProfileTest {
    CriminalProfile profile;
    @BeforeEach
    void setUp(){
        profile = new CriminalProfileBuilder(1).name("Mario").surname("Rossi")
                .nationality("italiano").dateOfBirth(new Date()).setCreatorCode(99).profileState(CriminalProfile.State.valueOf("WANTED")).build();
    }

    @Test
    void getCreatorCode() {
        assertNotEquals(profile.getCreatorCode(), 50);
    }

    @Test
    void getIdentity() {
        assertEquals(profile.getName(), "Mario");
        assertEquals(profile.getSurname(), "Rossi");
        assertEquals(profile.getNationality(), "italiano");
        assertNotEquals(profile.getDateOfBirth(), new Date());
        assertEquals(profile.getCriminalCode(),1);
    }

    @Test
    void getCriminalCode() {
        assertEquals(profile.getCriminalCode(),1);
    }

    @Test
    void getState() {
        assertEquals(profile.getState().toString(),"WANTED");
    }

    @Test
    void setCreatorCode() {
        profile.setCreatorCode(9);
        assertEquals(profile.getCreatorCode(),9);
    }
}