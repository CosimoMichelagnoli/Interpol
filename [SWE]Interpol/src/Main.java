import com.interpol.*;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main implements Serializable {
    public static void main(String[] args) {
        boolean rightDate = false;
        boolean choose = false;
        boolean exit = false;
        PoliceMan agent;
        Date dateOfDeath = new Date() ;
        SensitiveInformation sensitiveInformation;
        int option,criminalCode;
        String description;
        while (!choose){
            if(exit) {
                String again = JOptionPane.showInputDialog("New access?(si/no)  ");
                if (again.equals("no"))
                    choose = true;
                else exit = false;
            }
            if(!choose | !exit) {
                String answer = JOptionPane.showInputDialog("Are you a policeman or a sergeant? ");
                JOptionPane.showMessageDialog(null, answer);
                String name = JOptionPane.showInputDialog("Name: ");
                JOptionPane.showMessageDialog(null, name);
                String surname = JOptionPane.showInputDialog("Surname: ");
                JOptionPane.showMessageDialog(null, surname);
                int policeID = Integer.parseInt(JOptionPane.showInputDialog("Insert policeID: "));
                JOptionPane.showMessageDialog(null, policeID);
                if (answer.equals("sergeant"))
                    agent = new Sergeant(name, surname, policeID);
                else {
                    agent = new PoliceMan(name, surname, policeID);
                }

                while (!exit) {
                    option = Integer.parseInt(JOptionPane.showInputDialog("Options:       0)ADD_CRIMINAL_PROFILE,\n" +
                            "                      1)ADD_REPORT_DESCRIPTION,\n" +
                            "                      2)ADD_SENSITIVE_INFORMATION,\n" +
                            "                      3)SEARCH_CRIMINAL_PROFILE,\n" +
                            "                      4)SEARCH_SENSITIVE_INFORMATION,\n" +
                            "                      5)SEARCH_PROFILE'S_CREATOR,\n" +
                            "                      6)SEARCH_PROFILE_IDENTITY,\n" +
                            "                      7)SEARCH_PROFILE_STATE,\n" +
                            "                      8)SET_DEATH_DATE,\n" +
                            "                      9)ELIMINATE_PROFILE,\n" +
                            "                      10)EXIT"));
                    //todo;
                    switch (option) {
                        case 0 -> {
                            JOptionPane.showMessageDialog(null, "ADD_CRIMINAL_PROFILE");
                            criminalCode = Integer.parseInt(JOptionPane.showInputDialog("Please, enter the associated criminal code: "));
                            JOptionPane.showMessageDialog(null, criminalCode);
                            RealArchive.getInstance().generate(agent, criminalCode);
                        }
                        case 1 -> {
                            JOptionPane.showMessageDialog(null, "ADD_REPORT_DESCRIPTION");
                            criminalCode = Integer.parseInt(JOptionPane.showInputDialog("Please, enter the associated criminal code: "));
                            description = JOptionPane.showInputDialog("Please, enter the description that you want to add: ");
                            RealArchive.getInstance().setRecord(criminalCode, description);
                        }
                        case 2 -> {
                            JOptionPane.showMessageDialog(null, "ADD_SENSITIVE_INFORMATION");
                            criminalCode = Integer.parseInt(JOptionPane.showInputDialog("Please, enter the associated criminal code: "));
                            String gps = JOptionPane.showInputDialog("Gps: ");
                            JOptionPane.showMessageDialog(null, gps);
                            String internetData = JOptionPane.showInputDialog("Internet data: ");
                            JOptionPane.showMessageDialog(null, internetData);
                            RealArchive.getInstance().setSensitiveInformation(agent, criminalCode, gps, internetData);
                        }
                        case 3 -> {
                            JOptionPane.showMessageDialog(null, "SEARCH_CRIMINAL_PROFILE");
                            criminalCode = Integer.parseInt(JOptionPane.showInputDialog("Please, enter the associated criminal code: "));
                            RealArchive.getInstance().getCriminalIdentity(criminalCode);
                            RealArchive.getInstance().getCriminalRecord(criminalCode);
                            ProxyArchive.getInstance().getSensitiveInformation(agent, criminalCode);
                        }
                        case 4 -> {
                            JOptionPane.showMessageDialog(null, "SEARCH_SENSITIVE_INFORMATION");
                            criminalCode = Integer.parseInt(JOptionPane.showInputDialog("Please, enter the associated criminal code: "));
                            ProxyArchive.getInstance().getSensitiveInformation(agent, criminalCode);
                        }
                        case 5 -> {
                            JOptionPane.showMessageDialog(null, "SEARCH_PROFILE_CREATOR");
                            criminalCode = Integer.parseInt(JOptionPane.showInputDialog("Please, enter the associated criminal code: "));
                            ProxyArchive.getInstance().getProfileCreator(agent, criminalCode);
                        }
                        case 6 -> {
                            JOptionPane.showMessageDialog(null, "SEARCH_PROFILE_IDENTITY");
                            criminalCode = Integer.parseInt(JOptionPane.showInputDialog("Please, enter the associated criminal code: "));
                            JOptionPane.showMessageDialog(null, criminalCode);
                            RealArchive.getInstance().getCriminalIdentity(criminalCode);
                        }
                        case 7 -> {
                            JOptionPane.showMessageDialog(null, "SEARCH_PROFILE_STATE");
                            criminalCode = Integer.parseInt(JOptionPane.showInputDialog("Please, enter the associated criminal code: "));
                            RealArchive.getInstance().getCriminalState(criminalCode);
                        }
                        case 8 -> {
                            JOptionPane.showMessageDialog(null, "SET_DEATH_DATE");
                            criminalCode = Integer.parseInt(JOptionPane.showInputDialog("Please, enter the associated criminal code: "));

                            while (!rightDate) {
                                String input = JOptionPane.showInputDialog("Insert date of birth:(\"dd/MM/yyyy\")");
                                JOptionPane.showMessageDialog (null, input);
                                SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
                                try {
                                    dateOfDeath = ft.parse(input);
                                    rightDate = true;

                                } catch (ParseException e) {
                                    JOptionPane.showMessageDialog(null, "Unable to parse the date: " +input+
                                            "\nTry again..");
                                }
                            }
                            RealArchive.getInstance().eliminateProfile(criminalCode);
                            JOptionPane.showMessageDialog(null, "Done!");
                        }
                        case 9 -> {
                            JOptionPane.showMessageDialog(null, "ELIMINATE_PROFILE");
                            criminalCode = Integer.parseInt(JOptionPane.showInputDialog("Please, enter the associated criminal code: "));
                            RealArchive.getInstance().eliminateProfile(criminalCode);
                            JOptionPane.showMessageDialog(null, "Done!");
                        }
                        case 10 -> {
                            JOptionPane.showMessageDialog(null, "EXIT");
                            exit = true;
                        }
                    }
                }
            }
    }
    }
    public void initialize(){

    }
}
