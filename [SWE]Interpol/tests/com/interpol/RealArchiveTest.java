package com.interpol;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RealArchiveTest {
    PoliceMan policeMan;
    Sergeant sergeant;


    @BeforeEach
    void setUp(){
        policeMan = new PoliceMan("Mario","Rossi", 1);
        sergeant = new Sergeant("Paolo","Bianchi", 2);
        RealArchive.getInstance().generate(policeMan,99,"francesco","verdi",new Date(),"italiano",
                CriminalProfile.State.valueOf("WANTED"),"parigi","twitter", 1);
    }

    @Test
    void setSensitiveInformation() {
        ProxyArchive.getInstance().setSensitiveInformation(policeMan,99,"florence","youtube");
        assertNull(ProxyArchive.getInstance().getSensitiveInformation(policeMan, 99));
        ProxyArchive.getInstance().setSensitiveInformation(sergeant,99,"rome","google");
        assertEquals(ProxyArchive.getInstance().getSensitiveInformation(sergeant, 99).getGps(),"rome");
        assertEquals(ProxyArchive.getInstance().getSensitiveInformation(sergeant, 99).getInternetData(),"google");
    }

    @Test
    void getSensitiveInformation() {
        assertNull(ProxyArchive.getInstance().getSensitiveInformation(policeMan,99));
        assertEquals(ProxyArchive.getInstance().getSensitiveInformation(sergeant,99).getGps(),"parigi");
        assertEquals(ProxyArchive.getInstance().getSensitiveInformation(sergeant, 99).getInternetData(), "twitter");
    }

    @Test
    void getProfileCreator() {
        assertEquals(RealArchive.getInstance().search(99).getCreatorCode(),1);
    }

    @Test
    void setRecord() {
        RealArchive.getInstance().setRecord(99,"He is free");
        assertEquals(RealArchive.getInstance().search(99).getRecord().getDescription(),"He is free");
    }

    @Test
    void getCriminalIdentity() {
        assertEquals(RealArchive.getInstance().search(99).getName(),"francesco");
        assertEquals(RealArchive.getInstance().search(99).getSurname(),"verdi");
        assertNotEquals(RealArchive.getInstance().search(99).getDateOfBirth(),new Date());
        assertEquals(RealArchive.getInstance().search(99).getNationality(),"italiano");
    }

    @Test
    void getCriminalState() {
        assertEquals(RealArchive.getInstance().search(99).getState(), CriminalProfile.State.WANTED);
    }

    @Test
    void getCriminalRecord() {
        assertNull(RealArchive.getInstance().search(99).getRecord());
    }

    @Test
    void generate() {
        RealArchive.getInstance().generate(sergeant,88,"luigi","viola",new Date(),"francese",
                CriminalProfile.State.valueOf("RELEASED"),"parigi","snapchat", sergeant.getPoliceID());
        RealArchive.getInstance().generate(sergeant,77,"marco","nero",new Date(),"tedesco",
               CriminalProfile.State.valueOf("CONVICT"),"berlino","twitter", sergeant.getPoliceID());
        RealArchive.getInstance().generate(policeMan,66,"leonardo","marrone",new Date(),"austriaco",
                CriminalProfile.State.valueOf("WANTED"),"vienna","github", policeMan.getPoliceID());
        RealArchive.getInstance().generate(policeMan,55,"luca","giallo",new Date(),"olandese",
                 CriminalProfile.State.valueOf("ESCAPEE"),"amsterdam","facebook", policeMan.getPoliceID());
        assertNotNull(RealArchive.getInstance().search(88));
        assertNotNull(RealArchive.getInstance().search(77));
        assertNotNull(RealArchive.getInstance().search(66));
        assertNotNull(RealArchive.getInstance().search(55));
        assertEquals(RealArchive.getInstance().search(88).getName(),"luigi");
        assertEquals(RealArchive.getInstance().search(88).getSurname(),"viola");
        assertNotEquals(RealArchive.getInstance().search(88).getDateOfBirth(),new Date());
        assertEquals(RealArchive.getInstance().search(88).getNationality(),"francese");
        assertEquals(RealArchive.getInstance().search(88).getState(), CriminalProfile.State.RELEASED);
        assertEquals(ProxyArchive.getInstance().getSensitiveInformation(sergeant, 88).getGps(),"parigi");
        assertEquals(ProxyArchive.getInstance().getSensitiveInformation(sergeant, 88).getInternetData(),"snapchat");
        assertEquals(RealArchive.getInstance().search(77).getName(),"marco");
        assertEquals(RealArchive.getInstance().search(77).getSurname(),"nero");
        assertNotEquals(RealArchive.getInstance().search(77).getDateOfBirth(),new Date());
        assertEquals(RealArchive.getInstance().search(77).getNationality(),"tedesco");
        assertEquals(RealArchive.getInstance().search(77).getState(), CriminalProfile.State.CONVICT);
        assertEquals(ProxyArchive.getInstance().getSensitiveInformation(sergeant, 77).getGps(),"berlino");
        assertEquals(ProxyArchive.getInstance().getSensitiveInformation(sergeant, 77).getInternetData(),"twitter");
        assertEquals(RealArchive.getInstance().search(66).getName(),"leonardo");
        assertEquals(RealArchive.getInstance().search(66).getSurname(),"marrone");
        assertNotEquals(RealArchive.getInstance().search(66).getDateOfBirth(),new Date());
        assertEquals(RealArchive.getInstance().search(66).getNationality(),"austriaco");
        assertEquals(RealArchive.getInstance().search(66).getState(), CriminalProfile.State.WANTED);
        assertNull(ProxyArchive.getInstance().getSensitiveInformation(policeMan, 66));
        assertNull(ProxyArchive.getInstance().getSensitiveInformation(policeMan, 66));
        assertEquals(RealArchive.getInstance().search(55).getName(),"luca");
        assertEquals(RealArchive.getInstance().search(55).getSurname(),"giallo");
        assertNotEquals(RealArchive.getInstance().search(55).getDateOfBirth(),new Date());
        assertEquals(RealArchive.getInstance().search(55).getNationality(),"olandese");
        assertEquals(RealArchive.getInstance().search(55).getState(), CriminalProfile.State.ESCAPEE);
        assertNull(ProxyArchive.getInstance().getSensitiveInformation(policeMan, 55));
        assertNull(ProxyArchive.getInstance().getSensitiveInformation(policeMan, 55));
    }

    @Test
    void eliminateProfile() {
        RealArchive.getInstance().eliminateProfile(99);
        assertNull(RealArchive.getInstance().search(99));
    }


}