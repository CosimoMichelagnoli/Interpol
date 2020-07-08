package com.interpol;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SensitiveInformationTest {
    SensitiveInformation information;

    @BeforeEach
    void setUp(){
        information = new SensitiveInformation();
        information.setGps("florence");
        information.setInternetData("youtube");
    }

    @Test
    void getGps() {
        assertEquals(information.getGps(), "florence");
    }

    @Test
    void setGps() {
        information.setGps("rome");
        assertNotEquals(information.getGps(), "florence");
    }

    @Test
    void getInternetData() {
        assertEquals(information.getInternetData(), "youtube");
    }

    @Test
    void setInternetData() {
        information.setInternetData("google");
        assertNotEquals(information.getInternetData(), "youtube");
    }
}