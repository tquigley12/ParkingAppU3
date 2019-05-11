package parkingapp;

import java.util.ArrayList;
import static parkingapp.TicketMachine.closeGarage;

/**
 * This class describes the functions of closing the Parking Garage.  An activity
 * report is generated for all vehicles that have checked into the garage, and exited.
 * All vehicles remain in the parking garage application.
 * 
 * @author tquigley1
 */
public class CloseGarage {
    
    /**
     * This is the constructor for class CloseGarge.
     * @param vehicle is ArrayList containing all vehicle objects in the parking garage application.
     */
    public CloseGarage(ArrayList<Vehicle> vehicle) {
        int checkIns = 0;
        int specialEvents = 0;
        int lostTickets = 0;
        int loopIndex;
        double collectedFunds = 0.00;
        double collectedFromCheckIns = 0.00;
        double collectedFromLostTickets = 0.00;
        double collectedFromSpecialEvents = 0.00;
        double collectedOverall = 0.00;
        for (loopIndex = 0; loopIndex < vehicle.size(); loopIndex++) {
            collectedFunds = vehicle.get(loopIndex).getVehicleCharge();
            if (collectedFunds > 0.00) {
                if (vehicle.get(loopIndex).getLostTicket()) {
                    lostTickets = lostTickets + 1;
                    collectedFromLostTickets = collectedFromLostTickets + collectedFunds;
                } else if (vehicle.get(loopIndex).getSpecialEvent()) {
                    specialEvents = specialEvents + 1;
                    collectedFromSpecialEvents = collectedFromSpecialEvents + collectedFunds;
                } else {
                    checkIns = checkIns + 1;
                    collectedFromCheckIns = collectedFromCheckIns + collectedFunds;
                }
                collectedOverall = collectedOverall + collectedFunds;
            }
        }
        System.out.println("");
        System.out.println("Best Value Parking Garage");
        System.out.println("");
        System.out.println("=========================");
        System.out.println("");
        System.out.println("Activity to Date");
        System.out.println("");
        System.out.println("");
        System.out.println(String.format("$%,.0f", collectedFromCheckIns) + " was collected from " +
                    checkIns + " Check Ins");
        System.out.println("");
        System.out.println(String.format("$%,.0f", collectedFromSpecialEvents) + " was collected from " +
                    specialEvents + " Special Events");
        System.out.println("");
        System.out.println(String.format("$%,.0f", collectedFromLostTickets) + " was collected from " +
                    lostTickets + " Lost Tickets");
        System.out.println("");
        System.out.println("");
        System.out.println(String.format("$%,.0f", collectedOverall) + " was collected overall");
        closeGarage = true;
    }
    
}
