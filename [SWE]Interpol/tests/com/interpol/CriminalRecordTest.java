package com.interpol;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CriminalRecordTest {

    CriminalRecord record;

    @BeforeEach
    void setUp(){
        record = new CriminalRecord();
        record.setDescription("He made a crime");
    }


    @Test
    void getDescription() {
        assertEquals(record.getDescription(),"He made a crime");
    }

    @Test
    void setDescription() {
        record.setDescription("He is free");
        assertEquals(record.getDescription(),"He is free");
    }
}