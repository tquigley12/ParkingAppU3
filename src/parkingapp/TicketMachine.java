package parkingapp;

import java.util.ArrayList;

/**
 * This class performs functions related to the ticket machine in the parking garage.
 * 
 * @author tquigley1
 */
public class TicketMachine {
    public static final int GARAGE_CAPACITY = 25;
    public static int vehiclesInGarage;
    public static int vehicleID;
    public static boolean closeGarage = false;


    /**
     * This is the constructor for the TicketMachine class.  Logic is executed to determine
     * whether a check in or check out function is being requested, and the correct class 
     * is instantiated.
     * @param vehicle is ArrayList containing all the vehicle objects in the Parking Garage application.
     */
    public TicketMachine(ArrayList<Vehicle> vehicle) {
        if (isCheckIn()) {
            CheckInStation checkInStation = new CheckInStation(vehicle);
        } else {
            CheckOutStation checkOutStation = new CheckOutStation(vehicle);
        }
}

    /**
     * The following method determines whether it is a check in or check out function.
     * @return boolean value, 'true' if check in, 'false' if check out.
     */
    private boolean isCheckIn() {
        boolean checkIn;
        final int RANDOM_VALUE_RANGE = 10;
        final int CHECK_IN_VALUE_MAX = 6;
        if (isGarageEmpty()) {
            checkIn = true;
        } else if (isGarageFull()) {
            checkIn = false;
        } else if ((int) (Math.random() * RANDOM_VALUE_RANGE + 1) <= CHECK_IN_VALUE_MAX) {
            checkIn = true;
        } else {
            checkIn = false;
        }
        return checkIn;
    }

    /**
     * The following method determines whether the garage is empty.
     * @return boolean value, 'true' if garage is empty, 'false' otherwise.
     */
    private boolean isGarageEmpty() {
        boolean garageEmpty;
        if (vehiclesInGarage == 0) {
            garageEmpty = true;
        } else {
            garageEmpty = false;
        }
        return garageEmpty;
    }

    /**
     * The following method determines whether the garage is full.
     * @return boolean value, 'true' if garage is full, 'false' otherwise.
     */
    private boolean isGarageFull() {
        boolean garageFull;
        if (vehiclesInGarage == GARAGE_CAPACITY) {
            garageFull = true;
        } else {
            garageFull = false;
        }
            return garageFull;
    }

}