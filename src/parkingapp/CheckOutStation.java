package parkingapp;

import static java.lang.Character.toUpperCase;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class describes the check-out functions of the Parking Garage.
 * 
 * @author tquigley1
 */
public class CheckOutStation {
    private char action;
    private boolean validAction = false;
    Scanner keyboard = new Scanner(System.in);
    
    /**
     * This is the constructor for class CheckOutStation.  Logic is invoked to create menu
     * options for the user to input choices and to process the input.
     * @param vehicle is ArrayList containing all vehicle objects in the parking garage application.
     */
    public CheckOutStation(ArrayList<Vehicle> vehicle) {
        writeCheckOutMenu();
        action = toUpperCase(keyboard.nextLine().charAt(0));
        validAction = verifyCheckOutAction(action);
        while (!validAction) {
            System.out.println("Invalid action.  Please re-enter. ");
            System.out.println("");
            writeCheckOutMenu();
            action = toUpperCase(keyboard.nextLine().charAt(0));
            validAction = verifyCheckOutAction(action);
        }
        processCheckOutInput(action, vehicle);
    }
    
    /**
     * Display the check out menu.
     */
    private void writeCheckOutMenu() {
        System.out.println("");
        System.out.println("Best Value Parking Garage");
        System.out.println("");
        System.out.println("=========================");
        System.out.println("");
        System.out.println("1 - Check/Out");
        System.out.println("");
        System.out.println("2 - Lost Ticket");
        System.out.println("");
        System.out.print("==> ");
    }

    /**
     * Check whether the user input is valid.
     * @param action is user input action.
     * @return boolean value of 'true' if user input is valid, 'false' otherwise.
     */
    private boolean verifyCheckOutAction(char action) {
        switch (action) {
            case '1':
            case '2':
                return true;
            default:
                return false;
        }
    }

    /**
     * If user input is valid, instantiate objects to either check out a vehicle.
     * @param action is user input action.
     * @param vehicle is ArrayList containing all the vehicle objects in the parking garage application.
     */
    private void processCheckOutInput(char action, ArrayList<Vehicle> vehicle) {
        boolean lostTicket;
        switch (action) {
            case '1':
                lostTicket = false;
                break;
            case '2':
                lostTicket = true;
                break;
            default:
                lostTicket = false;
                break;
        }
        CheckOut checkOut = new CheckOut(vehicle, lostTicket);
    }

}
