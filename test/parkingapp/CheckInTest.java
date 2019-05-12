package parkingapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The purpose of this class is to test the check in process.  In the TicketMachine class
 * it is randomly determined whether a check in or check out will occur.  The assumption
 * is that TicketMachine has set the process to "check in".  From there the CheckInStation
 * class executes to gather input from the user to specify one of three options:
 *   1.  Check In
 *   2.  Special Event
 *   3.  Close Garage
 * 
 * In this class we will verify that options 1 and 2 work properly.  The TimeRoutine
 * class will be tested in this JUnit class as well.  Close Garage will be
 * addressed in a separate test class.
 * 
 * For this test class to work properly we must populate the Vehicle ArrayList from
 * the output.txt file.  Unfortunately the data does not carry over automatically from
 * the ParkingAppTest class.
 * 
 * @author tquigley1
 */
public class CheckInTest {
    
    public CheckInTest() {
        
    }

    String inputFileName = "output.txt";
    String outputFileName = "output2.txt";
    Scanner inputFile;
    String inputRecord;
    ArrayList<Vehicle> vehicle = new ArrayList<>();
    int vehiclesInGarage = 0;
    int loadVehicleID = 0;
    int checkInTime = 0;
    int checkOutTime = 0;
    double vehicleCharge;
    String lostTicketString;
    boolean lostTicket;
    String specialEventString;
    boolean specialEvent;
    PrintWriter outputFile;
    int vehicleID;
    
    @Before
    public void OpenAndLoadFileTest() throws FileNotFoundException {
        File file = new File(inputFileName);
        inputFile = new Scanner(file);
        outputFile = new PrintWriter(outputFileName);
        while (inputFile.hasNextLine()) {
            inputRecord = inputFile.nextLine();
            loadVehicleID = Integer.parseInt(inputRecord.substring(0,4).trim());
            checkInTime = Integer.parseInt(inputRecord.substring(4,8).trim());
            checkOutTime = Integer.parseInt(inputRecord.substring(8,12).trim());
            if (checkOutTime == 0) {
                vehiclesInGarage++;
            }
            lostTicketString = inputRecord.substring(12,17);
            if (lostTicketString.equals("false")) {
                lostTicket = false;
            } else {
                lostTicket = true;
            }
            specialEventString = inputRecord.substring(17,22);
            if (specialEventString.equals("false")) {
                specialEvent = false;
            } else {
                specialEvent = true;
            }
            vehicleCharge = Double.parseDouble(inputRecord.substring(22).trim());
            vehicle.add(new Vehicle(loadVehicleID, checkInTime, checkOutTime, vehicleCharge, lostTicket, specialEvent));
        }
    }
    
    @Test
    public void CheckInTest() {
        /**
         * Test non special event
         */
        vehicleID = 1000;
        specialEvent = false;
        vehicle.add(new Vehicle(vehicleID, TimeRoutine.getCheckInTime(), specialEvent));
        
        vehicleID = 1001;
        specialEvent = false;
        vehicle.add(new Vehicle(vehicleID, TimeRoutine.getCheckInTime(), specialEvent));
        
        /**
         * Test special event
         */
        vehicleID = 1002;
        specialEvent = true;
        vehicle.add(new Vehicle(vehicleID, TimeRoutine.getCheckInTime(), specialEvent));
    }
    
    @After
    public void LoadAndCloseFilesTest() {
        if (!vehicle.isEmpty()) {
            for (int loop = 0; loop < vehicle.size(); loop++) {
                outputFile.printf("%-4d%-4d%-4d%-5b%-5b%-20f\n", vehicle.get(loop).getVehicleID(), vehicle.get(loop).getCheckInTime(), 
                        vehicle.get(loop).getCheckOutTime(), vehicle.get(loop).getLostTicket(), vehicle.get(loop).getSpecialEvent(),
                        vehicle.get(loop).getVehicleCharge());
            }
        }
        inputFile.close();
        outputFile.close();
    }

}