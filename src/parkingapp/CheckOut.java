package parkingapp;

import java.util.ArrayList;
import static parkingapp.TicketMachine.vehiclesInGarage;

/**
 * This class describes the function of vehicle check-out from the Parking Garage.
 * Both with processed ticket (minimum/ maximum charge or special event change) and lost ticket.
 * 
 * @author tquigley1
 */
public class CheckOut {

    private final String chargeType;
    
    /**
     * This is the constructor for class CheckOut.  Logic is invoked to calculate
     * charge and display information for the vehicle as it exits the parking garage.
     * @param vehicle is ArrayList of all the vehicle objects in the parking garage application.
     * @param lostTicket 
     */
    public CheckOut(ArrayList<Vehicle> vehicle, boolean lostTicket) {
        
        /**
         * Get array list index of vehicle to check out.
         */
        int checkOutIndex = getCheckOutIndex(vehicle);
        
        /**
         * Get instance variables for vehicle to be checked out.
         */
        int localVehicleID = vehicle.get(checkOutIndex).getVehicleID();
        boolean specialEvent = vehicle.get(checkOutIndex).getSpecialEvent();
        int localCheckInTime = vehicle.get(checkOutIndex).getCheckInTime();
        int localCheckOutTime = TimeRoutine.getCheckOutTime();
        
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
        
        double localVehicleCharge = ChargeApp.run(chargeType, localCheckInTime, localCheckOutTime);
        
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
    
    /**
     * Obtain the index for the specific vehicle to be checked out of the parking garage.
     * This is accomplished by randomly selecting a vehicle object.
     * @param vehicle is ArrayList of all vehicle objects in the parking garage application.
     * @return index of vehicle in Vehicle ArrayList to be checked out.
     */
    private int getCheckOutIndex(ArrayList<Vehicle> vehicle) {
        int checkOutIndex = 0;
        int vehicleCheckOut = (int) (Math.random() * vehiclesInGarage + 1);
        int searchIndex = 0;
        int numberOfVehicleHits = 0;
        do {
            if (vehicle.get(searchIndex).getCheckOutTime() == 0) {
                numberOfVehicleHits++;
            }
            if (numberOfVehicleHits != vehicleCheckOut) {
                searchIndex++;
            }
        } while (numberOfVehicleHits != vehicleCheckOut);
        checkOutIndex = searchIndex;
        return checkOutIndex;
    }
    
}
