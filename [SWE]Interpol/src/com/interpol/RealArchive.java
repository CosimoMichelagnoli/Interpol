package com.interpol;

import javax.swing.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RealArchive implements Archive {
    private static final RealArchive instance;
    private  ArrayList<CriminalProfile> storageCriminalProfile;
    //private List<Profile.com.interpol.CriminalProfile> mostWantedList;

    public RealArchive() {
        storageCriminalProfile = new ArrayList<>();
    }

    static {
        instance = new RealArchive();
    }

    public static RealArchive getInstance() {
        return instance;
    }

    @Override
    public void setSensitiveInformation(PoliceMan agent, int criminalCode, String gps, String internetData) {
        try {
            CriminalProfile tmpProfile = new CriminalProfileBuilder(criminalCode).copyCostructor(searchAndExtract(criminalCode))
                    .gps(gps).internetData(internetData).addAgentCodeInteractedSensitiveInformation(agent.getPoliceID()).build();
            storageCriminalProfile.add(tmpProfile);
        }catch (IllegalStateException e){
            JOptionPane.showMessageDialog (null, "There was an error unexpected");
        }catch (NoSuchElementException e){
            JOptionPane.showMessageDialog (null, "No criminal profile associated with the code " +criminalCode+ " was found\n");
            String answer = JOptionPane.showInputDialog("Please, enter the associated criminal code: ");
            if(answer.equals("yes"))
                generateCriminalProfileIdentity(agent, criminalCode, gps, internetData);
        }
    }

    @Override
    public SensitiveInformation getSensitiveInformation(PoliceMan agent, int criminalCode) {
        try {
             CriminalProfile tmpProfile = search(criminalCode);
             return tmpProfile.getSensitiveInformation();
        } catch (NoSuchElementException e){
            JOptionPane.showMessageDialog (null, "No criminal profile associated with the code " +criminalCode+ " was found\n");
            return null;
        }
    }

    @Override
    public void getProfileCreator(PoliceMan agent, int criminalCode) {
        try {
            JOptionPane.showMessageDialog(null,"the creator of this profile " +criminalCode+ " is: "+search(criminalCode).getCreatorCode());
        }catch (NoSuchElementException e){
            JOptionPane.showMessageDialog (null, "No criminal profile associated with the code " +criminalCode+ " was found\n");
        }

    }

    public void setRecord(int criminalCode, String description){
        try {
            CriminalProfile tmpProfile = new CriminalProfileBuilder(criminalCode).copyCostructor(searchAndExtract(criminalCode))
                    .description(description).build();
            storageCriminalProfile.add(tmpProfile);
        }catch (IllegalStateException e){
            JOptionPane.showMessageDialog (null, "There was an error unexpected");
        }catch (NoSuchElementException e){
            JOptionPane.showMessageDialog (null, "No criminal profile associated with the code " +criminalCode+ " was found\n"
            +"You should create a profile..");
        }

    }

    public void getMostWantedList(){}

    public void getCriminalIdentity(int criminalCode){
        try {
            search(criminalCode).getIdentity();
        }catch (NoSuchElementException e){
            JOptionPane.showMessageDialog (null, "No criminal profile associated with the code " +criminalCode+ " was found\n");
        }
    }

    public void getCriminalState(int criminalCode){
        try {
            JOptionPane.showMessageDialog (null, "The state associated to this code  " +criminalCode+
                    " is: " +search(criminalCode).getState() );
        }catch (NoSuchElementException e){
            JOptionPane.showMessageDialog (null, "No criminal profile associated with the code " +criminalCode+ " was found\n");
        }
    }

    public void getCriminalRecord(int criminalCode){
        try {
            JOptionPane.showMessageDialog (null, "The description associated to this code  " +criminalCode+
                    " is: " +search(criminalCode).getRecord().getDescription() );
        }catch (NoSuchElementException e){
            JOptionPane.showMessageDialog (null, "No criminal profile associated with the code " +criminalCode+ " was found\n");
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog (null, "There isn't any description for: " +criminalCode);
        }
    }

    public void generateCriminalProfileIdentity(PoliceMan agent, int criminalCode, String gps, String internetData)  {
        boolean rightDate = false;
        Date dateOfBirth = new Date() ;
        String name = JOptionPane.showInputDialog("Insert name:");
        JOptionPane.showMessageDialog (null, name);
        String surname = JOptionPane.showInputDialog("Insert surname:");
        JOptionPane.showMessageDialog (null, surname);
        String nationality = JOptionPane.showInputDialog("Insert nationality:");
        JOptionPane.showMessageDialog (null, nationality);
        String strContactType = JOptionPane.showInputDialog("Insert profile state options: \n" +
                "             RELEASED,\n" +
                "             WANTED,\n" +
                "             CONVICT,\n" +
                "             ESCAPEE");
        CriminalProfile.State profileState = CriminalProfile.State.valueOf(strContactType);
        JOptionPane.showMessageDialog (null, strContactType);
        while (!rightDate) {
            String input = JOptionPane.showInputDialog("Insert date of birth:(\"dd/MM/yyyy\")");
            JOptionPane.showMessageDialog (null, input);
            SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
            try {
                dateOfBirth = ft.parse(input);
                rightDate = true;

            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Unable to parse the date: " +input+
                        "\nTry again..");
            }
        }
        CriminalProfile profile = new CriminalProfileBuilder(criminalCode).name(name)
                .surname(surname).dateOfBirth(dateOfBirth).nationality(nationality)
                .profileState(profileState).gps(gps).internetData(internetData).setCreatorCode(agent.getPoliceID())
                .addAgentCodeInteractedSensitiveInformation(agent.getPoliceID()).build();
        storageCriminalProfile.add(profile);
        JOptionPane.showMessageDialog(null, "\nThe profile "+ criminalCode +"  was generated and entered in the archive");
    }

    public void generate(PoliceMan agent, int criminalCode){
        boolean rightDate = false;
        Date dateOfBirth = new Date() ;
        String name = JOptionPane.showInputDialog("Insert name:");
        JOptionPane.showMessageDialog (null, name);
        String surname = JOptionPane.showInputDialog("Insert surname:");
        JOptionPane.showMessageDialog (null, surname);
        String nationality = JOptionPane.showInputDialog("Insert nationality:");
        JOptionPane.showMessageDialog (null, nationality);
        String strContactType = JOptionPane.showInputDialog("Insert profile state options: RELEASED,\n" +
                "             WANTED,\n" +
                "             CONVICT,\n" +
                "             ESCAPEE");
        CriminalProfile.State profileState = CriminalProfile.State.valueOf(strContactType);
        JOptionPane.showMessageDialog (null, strContactType);
        while (!rightDate) {
            String input = JOptionPane.showInputDialog("Insert date of birth:(\"dd/MM/yyyy\")");
            JOptionPane.showMessageDialog (null, input);
            SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
            try {
                dateOfBirth = ft.parse(input);
                rightDate = true;

            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "unable to parse the date: " + input);
            }
        }
        CriminalProfile profile = new CriminalProfileBuilder(criminalCode).name(name)
                .surname(surname).dateOfBirth(dateOfBirth).nationality(nationality)
                .profileState(profileState).setCreatorCode(agent.getPoliceID()).build();
        storageCriminalProfile.add(profile);
        JOptionPane.showMessageDialog(null, "\nThe profile "+ criminalCode +"  was generated and entered in the archive");
    }

    public void generate(PoliceMan agent, int criminalCode, String name, String surname, Date dateOfBirth, String nationality, CriminalProfile.State profileState, String gps, String internetData, int creatorCode){
        CriminalProfile profile = new CriminalProfileBuilder(criminalCode).name(name)
                .surname(surname).dateOfBirth(dateOfBirth).nationality(nationality)
                .profileState(profileState).setCreatorCode(creatorCode).gps(gps).internetData(internetData).build();
        storageCriminalProfile.add(profile);
    }

    public void getAgentCodesModify(int criminalCode){
        JOptionPane.showMessageDialog (null, "Click \"OK\" to see the codes of agents that modified sensitive information of this profile" +criminalCode);

    }

    public void eliminateProfile(int criminalCode){
        try {
            storageCriminalProfile.remove(search(criminalCode));
        }catch (NoSuchElementException e){
            JOptionPane.showMessageDialog (null, "No criminal profile associated with the code " +criminalCode+ " was found\n");
        }
    }

    public CriminalProfile search(int criminalCode) throws NoSuchElementException {
        for (CriminalProfile iterator : storageCriminalProfile){
            if(iterator.getCriminalCode() == criminalCode)
                return iterator;
        }
        throw new NoSuchElementException("There are no criminal profiles associated with this criminalCode..");
    }

    private CriminalProfile searchAndExtract(int criminalCode) throws IllegalStateException, IllegalCallerException {
        for (CriminalProfile iterator : storageCriminalProfile){
            if(iterator.getCriminalCode() == criminalCode)
                if (storageCriminalProfile.remove(iterator))
                    return iterator;
                else throw  new IllegalStateException("Error..");
            }
        throw new IllegalCallerException("There are no criminal profiles associated with this criminalCode..");
    }

    public ArrayList<CriminalProfile> getStorageCriminalProfile() {
        return storageCriminalProfile;
    }

    public  void setStorageCriminalProfile(ArrayList<CriminalProfile> storageCriminalProfile) {
        this.storageCriminalProfile = storageCriminalProfile;
    }

    public static void initialize(){

    }
}
