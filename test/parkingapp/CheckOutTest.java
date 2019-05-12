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
 * The purpose of this class is to test the check out process.  In the TicketMachine class
 * it is randomly determined whether a check in or check out will occur.  The assumption
 * is that TicketMachine has set the process to "check out".  From there the CheckOutStation
 * class executes to gather input from the user to specify one of three options:
 *   1.  Check Out
 *   2.  Lost Ticket
 * 
 * In this class we will verify that options 1 and 2 work properly.  The TimeRoutine
 * class will be tested in this JUnit class as well.  In this test class it will process
 * the 3 vehicles that were added in the CheckInTest class.  By extension, this JUnit
 * class will also test the three types of charges (minimum/ maximum, lost ticket and
 * special event).
 * 
 * For this test class to work properly we must populate the Vehicle ArrayList from
 * the output2.txt file.  Unfortunately the data does not carry over automatically from
 * the CheckInTest class.
 * 
 * @author tquigley1
 */
public class CheckOutTest {
    
    public CheckOutTest() {
        
    }

    String inputFileName = "output2.txt";
    String outputFileName = "output3.txt";
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
        ChargeFactory chargeFactory = ChargeFactoryImpl.INSTANCE;
        ChargeApp chargeApp = new ChargeApp(chargeFactory);
        chargeApp.getInstance();
    }
    
    @Test
    public void CheckOutTest() {
        int checkOutIndex;
        int localVehicleID;
        boolean specialEvent;
        int localCheckInTime;
        int localCheckOutTime;
        boolean lostTicket;
        String chargeType;
        double localVehicleCharge;
        
        /**
         * Test the minimum/ maximum charge
         */
        checkOutIndex = 34;
        localVehicleID = vehicle.get(checkOutIndex).getVehicleID();
        specialEvent = vehicle.get(checkOutIndex).getSpecialEvent();
        localCheckInTime = vehicle.get(checkOutIndex).getCheckInTime();
        localCheckOutTime = TimeRoutine.getCheckOutTime();
        lostTicket = false;
        
        /**
         * Call the ChargeApp class to get the value for the charge.
         */
        if (lostTicket) {
            chargeType = "lost ticket";
        } else if (specialEvent) {
            chargeType = "special event";
        } else {
            chargeType = "minimum maximum";
        }
        
        localVehicleCharge = ChargeApp.run(chargeType, localCheckInTime, localCheckOutTime);
        
        /**
         * Set instance variables for vehicle to be checked out.
         */
        vehicle.get(checkOutIndex).setCheckOutTime(localCheckOutTime);
        vehicle.get(checkOutIndex).setVehicleCharge(localVehicleCharge);
        vehicle.get(checkOutIndex).setLostTicket(lostTicket);
        
        /**
         * Print information for the vehicle object as it exits the parking garage.
         */
        System.out.println("");
        System.out.println("Best Value Parking Garage");
        System.out.println("");
        System.out.println("=========================");
        System.out.println("");
        System.out.println("Receipt for a vehicle id " + localVehicleID);
        System.out.println("");
        System.out.println("");
        if (lostTicket) {
            System.out.println("Lost Ticket");
        } else if (specialEvent) {
            System.out.println("Special Event");
        } else {
            System.out.println((localCheckOutTime - localCheckInTime) + " hours parked  " +
                   (localCheckInTime <= 12 ? localCheckInTime : (localCheckInTime - 12)) +
                   (localCheckInTime < 12 ? "am" : "pm") + " - " +
                   (localCheckOutTime <= 12 ? localCheckOutTime : (localCheckOutTime - 12)) +
                   (localCheckOutTime < 12 ? "am" : "pm"));
        }
        System.out.println("");
        System.out.println(String.format("$%,.2f", localVehicleCharge));
        System.out.println("");
        System.out.println("");
        vehiclesInGarage--;
        
        /**
         * Test the lost ticket charge
         */
        checkOutIndex = 35;
        localVehicleID = vehicle.get(checkOutIndex).getVehicleID();
        specialEvent = vehicle.get(checkOutIndex).getSpecialEvent();
        localCheckInTime = vehicle.get(checkOutIndex).getCheckInTime();
        localCheckOutTime = TimeRoutine.getCheckOutTime();
        lostTicket = true;
        
        /**
         * Call the ChargeApp class to get the value for the charge.
         */
        if (lostTicket) {
            chargeType = "lost ticket";
        } else if (specialEvent) {
            chargeType = "special event";
        } else {
            chargeType = "minimum maximum";
        }
        
        localVehicleCharge = ChargeApp.run(chargeType, localCheckInTime, localCheckOutTime);
        
        /**
         * Set instance variables for vehicle to be checked out.
         */
        vehicle.get(checkOutIndex).setCheckOutTime(localCheckOutTime);
        vehicle.get(checkOutIndex).setVehicleCharge(localVehicleCharge);
        vehicle.get(checkOutIndex).setLostTicket(lostTicket);
        
        /**
         * Print information for the vehicle object as it exits the parking garage.
         */
        System.out.println("");
        System.out.println("Best Value Parking Garage");
        System.out.println("");
        System.out.println("=========================");
        System.out.println("");
        System.out.println("Receipt for a vehicle id " + localVehicleID);
        System.out.println("");
        System.out.println("");
        if (lostTicket) {
            System.out.println("Lost Ticket");
        } else if (specialEvent) {
            System.out.println("Special Event");
        } else {
            System.out.println((localCheckOutTime - localCheckInTime) + " hours parked  " +
                   (localCheckInTime <= 12 ? localCheckInTime : (localCheckInTime - 12)) +
                   (localCheckInTime < 12 ? "am" : "pm") + " - " +
                   (localCheckOutTime <= 12 ? localCheckOutTime : (localCheckOutTime - 12)) +
                   (localCheckOutTime < 12 ? "am" : "pm"));
        }
        System.out.println("");
        System.out.println(String.format("$%,.2f", localVehicleCharge));
        System.out.println("");
        System.out.println("");
        vehiclesInGarage--;
        
        /**
         * Test the special event charge
         */
        checkOutIndex = 36;
        localVehicleID = vehicle.get(checkOutIndex).getVehicleID();
        specialEvent = vehicle.get(checkOutIndex).getSpecialEvent();
        localCheckInTime = vehicle.get(checkOutIndex).getCheckInTime();
        localCheckOutTime = TimeRoutine.getCheckOutTime();
        lostTicket = false;
        
        /**
         * Call the ChargeApp class to get the value for the charge.
         */
        if (lostTicket) {
            chargeType = "lost ticket";
        } else if (specialEvent) {
            chargeType = "special event";
        } else {
            chargeType = "minimum maximum";
        }
        
        localVehicleCharge = ChargeApp.run(chargeType, localCheckInTime, localCheckOutTime);
        
        /**
         * Set instance variables for vehicle to be checked out.
         */
        vehicle.get(checkOutIndex).setCheckOutTime(localCheckOutTime);
        vehicle.get(checkOutIndex).setVehicleCharge(localVehicleCharge);
        vehicle.get(checkOutIndex).setLostTicket(lostTicket);
        
        /**
         * Print information for the vehicle object as it exits the parking garage.
         */
        System.out.println("");
        System.out.println("Best Value Parking Garage");
        System.out.println("");
        System.out.println("=========================");
        System.out.println("");
        System.out.println("Receipt for a vehicle id " + localVehicleID);
        System.out.println("");
        System.out.println("");
        if (lostTicket) {
            System.out.println("Lost Ticket");
        } else if (specialEvent) {
            System.out.println("Special Event");
        } else {
            System.out.println((localCheckOutTime - localCheckInTime) + " hours parked  " +
                   (localCheckInTime <= 12 ? localCheckInTime : (localCheckInTime - 12)) +
                   (localCheckInTime < 12 ? "am" : "pm") + " - " +
                   (localCheckOutTime <= 12 ? localCheckOutTime : (localCheckOutTime - 12)) +
                   (localCheckOutTime < 12 ? "am" : "pm"));
        }
        System.out.println("");
        System.out.println(String.format("$%,.2f", localVehicleCharge));
        System.out.println("");
        System.out.println("");
        vehiclesInGarage--;
        
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