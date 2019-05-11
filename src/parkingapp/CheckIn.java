package parkingapp;

import java.util.ArrayList;
import static parkingapp.TicketMachine.vehicleID;
import static parkingapp.TicketMachine.vehiclesInGarage;

/**
 * This class describes the function of vehicle check-in to the Parking Garage.
 * When the class is instantiated, the constructor will add a new vehicle to the 
 * Vehicle ArrayList.
 * 
 * @author tquigley1
 */
public class CheckIn {
    
    public CheckIn(ArrayList<Vehicle> vehicle, boolean specialEvent) {
        vehicleID++;
        vehicle.add(new Vehicle(vehicleID, TimeRoutine.getCheckInTime(), specialEvent));
        vehiclesInGarage++;
    }
    
}
