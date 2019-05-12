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
 * The purpose of this class is to test aspects of the ParkingApp driver class.
 * In ParkingApp, a text file is read to populate an ArrayList, then there is processing
 * against the data in the ArrayList, and at the end the updated ArrayList is populated 
 * to the text file so it is available for the next run.  This test class will verify
 * the logic that reads and writes the text file.  There will be two text files, one
 * for input ('input.txt') and another for output ('output.txt').  At the end of this
 * class execution the two files will be visually compared.  If they are the same, then
 * the test is successful.  By extension this will also prove that the ArrayList is 
 * populated correctly.
 * 
 * @author tquigley1
 */
public class ParkingAppTest {
    
    public ParkingAppTest() {
        
    }

    String inputFileName = "input.txt";
    String outputFileName = "output.txt";
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
    
    @Before
    public void OpenFilesTest() throws FileNotFoundException {
        File file = new File(inputFileName);
        inputFile = new Scanner(file);
        outputFile = new PrintWriter(outputFileName);
    }
    
    @Test
    public void ProcessFilesTest() {
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
        if (!vehicle.isEmpty()) {
            for (int loop = 0; loop < vehicle.size(); loop++) {
                outputFile.printf("%-4d%-4d%-4d%-5b%-5b%-20f\n", vehicle.get(loop).getVehicleID(), vehicle.get(loop).getCheckInTime(), 
                        vehicle.get(loop).getCheckOutTime(), vehicle.get(loop).getLostTicket(), vehicle.get(loop).getSpecialEvent(),
                        vehicle.get(loop).getVehicleCharge());
            }
        }
    }
    
    @After
    public void CloseFilesTest() {
        inputFile.close();
        outputFile.close();
    }

}